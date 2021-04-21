package com.windea.plugin.idea.sbtext.editor

import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.windea.plugin.idea.sbtext.*
import com.windea.plugin.idea.sbtext.highlighter.SbTextAttributesKeys.COLORFUL_TEXT_KEYS
import com.windea.plugin.idea.sbtext.highlighter.SbTextAttributesKeys.createColorfulTextKey
import com.windea.plugin.idea.sbtext.psi.*

class SbTextAnnotator : Annotator, DumbAware {
	companion object{
		private val colorIdRegex = "(#[0-9a-fA-F]{3})|(#[0-9a-fA-F]{6})|([a-zA-Z]+)".toRegex()
	}
	
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element){
			is SbTextColorfulText -> {
				val colorMarker = element.colorMarker
				val colorId = colorMarker.colorCode?.text?:return
				//判断colorId是否合法，又是否支持，如果合法且支持，则高亮彩色文本
				if(!colorId.matches(colorIdRegex)) {
					holder.newAnnotation(ERROR, message("sbText.annotator.invalidColorId", colorId))
						.range(colorMarker)
						.create()
				}else{
					val color = element.color
					if(color == null) {
						holder.newAnnotation(ERROR, message("sbText.annotator.unsupportedColorId", colorId))
							.range(colorMarker)
							.create()
					} else {
						//高亮彩色文本
						val string = element.string ?:return
						val attributesKey = COLORFUL_TEXT_KEYS.getOrPut(colorId){
							createColorfulTextKey(colorId,color)
						}
						holder.newSilentAnnotation(INFORMATION).range(string).textAttributes(attributesKey).create()
					}
				}
			}
		}
		//when(element) {
		//	is SbTextColorMarker -> {
		//		val colorId = element.colorCode?.text ?: return
		//		//判断colorId是否合法，又是否支持，如果合法且支持，则高亮彩色文本
		//		if(!colorId.matches(colorIdRegex)) {
		//			holder.newAnnotation(ERROR, message("sbText.annotator.invalidColorId", colorId)).create()
		//		}else{
		//			val color = element.color
		//			if(color == null) {
		//				holder.newAnnotation(ERROR, message("sbText.annotator.unsupportedColorId", colorId)).create()
		//			} else {
		//				//高亮彩色文本
		//				val string = element.nextSibling as? SbTextString ?:return
		//				val attributesKey = COLORFUL_TEXT_KEYS.getOrPut(colorId){
		//					createColorfulTextKey(colorId,color)
		//				}
		//				holder.newSilentAnnotation(INFORMATION).range(string).textAttributes(attributesKey).create()
		//			}
		//		}
		//	}
		//}
	}
}

