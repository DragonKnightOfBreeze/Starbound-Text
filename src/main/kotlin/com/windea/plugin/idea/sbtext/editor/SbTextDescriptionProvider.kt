package com.windea.plugin.idea.sbtext.editor

import com.intellij.psi.*
import com.intellij.usageView.*
import com.windea.plugin.idea.sbtext.*
import com.windea.plugin.idea.sbtext.psi.*

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
