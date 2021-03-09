package com.windea.plugin.idea.sbtext.editor

import com.intellij.lang.annotation.*
import com.intellij.lang.annotation.HighlightSeverity.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.windea.plugin.idea.sbtext.*
import com.windea.plugin.idea.sbtext.highlighter.SbTextAttributesKeys.COLORFUL_TEXT_KEYS
import com.windea.plugin.idea.sbtext.highlighter.SbTextAttributesKeys.createColorfulTextKey
import com.windea.plugin.idea.sbtext.psi.*
import java.awt.*

class SbTextAnnotator : Annotator, DumbAware {
	override fun annotate(element: PsiElement, holder: AnnotationHolder) {
		when(element) {
			is SbTextColorfulText -> {
				val colorId = element.name ?: return
				val color = element.color
				if(color == null) {
					holder.newAnnotation(ERROR, message("sbText.annotator.unsupportedColor", colorId))
						.range(element.colorMarker).create()
				} else {
					annotateColor(colorId,color, holder, element)
				}
			}
		}
	}

	private fun annotateColor(colorId: String,color: Color, holder: AnnotationHolder, element: SbTextColorfulText) {
		val attributesKey = COLORFUL_TEXT_KEYS.getOrPut(colorId){
			createColorfulTextKey(colorId,color)
		}
		//高亮颜色文本
		//val strings = element.collectDescendantsOfType<SbTextString>()
		//for(string in strings) {
		//	holder.newSilentAnnotation(INFORMATION).range(string).textAttributes(attributesKey).create()
		//}
		val string = element.string?:return
		holder.newSilentAnnotation(INFORMATION).range(string).textAttributes(attributesKey).create()
	}
}

