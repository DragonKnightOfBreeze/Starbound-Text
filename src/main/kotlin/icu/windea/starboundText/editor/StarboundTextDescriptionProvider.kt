package icu.windea.starboundText.editor

import com.intellij.psi.*
import com.intellij.usageView.UsageViewTypeLocation
import icu.windea.starboundText.StarboundTextBundle
import icu.windea.starboundText.psi.StarboundTextColorfulText

class StarboundTextDescriptionProvider : ElementDescriptionProvider {
	override fun getElementDescription(element: PsiElement, location: ElementDescriptionLocation): String? {
		return when(element){
			is StarboundTextColorfulText -> {
				if(location == UsageViewTypeLocation.INSTANCE) StarboundTextBundle.message("starboundText.description.colorfulText")
				else element.name
			}
			else -> null
		}
	}
}
