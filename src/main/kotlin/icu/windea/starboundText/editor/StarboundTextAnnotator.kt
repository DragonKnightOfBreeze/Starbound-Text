package icu.windea.starboundText.editor

import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import icu.windea.starboundText.*
import icu.windea.starboundText.highlighter.StarboundTextAttributesKeys.COLORFUL_TEXT_KEYS
import icu.windea.starboundText.highlighter.StarboundTextAttributesKeys.createColorfulTextKey
import icu.windea.starboundText.psi.*

class StarboundTextAnnotator : Annotator, DumbAware {
	companion object{
		private val colorIdRegex = "(#[0-9a-fA-F]{3})|(#[0-9a-fA-F]{6})|([a-zA-Z]+)".toRegex()
	}
	
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element){
			is StarboundTextColorfulText -> {
				val colorMarker = element.colorMarker
				val colorId = colorMarker.colorCode?.text?:return
				//判断colorId是否合法，又是否支持，如果合法且支持，则高亮彩色文本
				if(!colorId.matches(colorIdRegex)) {
					holder.newAnnotation(ERROR, message("starboundText.annotator.invalidColorId", colorId))
						.range(colorMarker)
						.create()
				}else{
					val color = element.color
					if(color == null) {
						holder.newAnnotation(ERROR, message("starboundText.annotator.unsupportedColorId", colorId))
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
		//	is StarboundTextColorMarker -> {
		//		val colorId = element.colorCode?.text ?: return
		//		//判断colorId是否合法，又是否支持，如果合法且支持，则高亮彩色文本
		//		if(!colorId.matches(colorIdRegex)) {
		//			holder.newAnnotation(ERROR, message("starboundText.annotator.invalidColorId", colorId)).create()
		//		}else{
		//			val color = element.color
		//			if(color == null) {
		//				holder.newAnnotation(ERROR, message("starboundText.annotator.unsupportedColorId", colorId)).create()
		//			} else {
		//				//高亮彩色文本
		//				val string = element.nextSibling as? StarboundTextString ?:return
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

