package icu.windea.starboundText.editor

import com.intellij.psi.*
import com.intellij.usageView.*
import icu.windea.starboundText.*
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.*

class SbTextDescriptionProvider : ElementDescriptionProvider {
	override fun getElementDescription(element: PsiElement, location: ElementDescriptionLocation): String? {
		return when(element){
			is SbTextColorfulText -> {
				if(location == UsageViewTypeLocation.INSTANCE) message("sbText.description.colorfulText")
				else element.name
			}
			else -> null
		}
	}
}
