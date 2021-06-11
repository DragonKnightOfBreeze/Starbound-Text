package icu.windea.starboundText.editor

import com.intellij.openapi.editor.*
import com.intellij.psi.*
import icu.windea.starboundText.psi.*
import java.awt.*

class SbTextColorProvider: ElementColorProvider {
	override fun getColorFrom(element: PsiElement): Color? {
		return when(element){
			is SbTextColorfulText -> element.color
			else -> null
		}
	}

	override fun setColorTo(element: PsiElement, color: Color) {
		when(element){
			is SbTextColorfulText -> element.setColor(color)
		}
	}
}
