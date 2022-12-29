package icu.windea.starboundText.editor

import com.intellij.openapi.editor.ElementColorProvider
import com.intellij.psi.PsiElement
import icu.windea.starboundText.psi.StarboundTextColorfulText
import java.awt.Color

class StarboundTextColorProvider: ElementColorProvider {
	override fun getColorFrom(element: PsiElement): Color? {
		return when(element){
			is StarboundTextColorfulText -> element.color
			else -> null
		}
	}

	override fun setColorTo(element: PsiElement, color: Color) {
		when(element){
			is StarboundTextColorfulText -> element.setColor(color)
		}
	}
}
