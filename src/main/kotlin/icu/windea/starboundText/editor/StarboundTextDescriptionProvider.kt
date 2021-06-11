package icu.windea.starboundText.editor

import com.intellij.psi.*
import com.intellij.usageView.*
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.*

class StarboundTextDescriptionProvider : ElementDescriptionProvider {
	override fun getElementDescription(element: PsiElement, location: ElementDescriptionLocation): String? {
		return when(element){
			is StarboundTextColorfulText -> {
				if(location == UsageViewTypeLocation.INSTANCE) message("starboundText.description.colorfulText")
				else element.name
			}
			else -> null
		}
	}
}
