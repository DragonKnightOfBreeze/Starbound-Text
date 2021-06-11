package icu.windea.starboundText.editor

import com.intellij.codeInsight.template.*
import com.intellij.psi.*
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.*

class StarboundTextTemplateContext : TemplateContextType(starboundTextId, starboundTextName){
	override fun isInContext(file: PsiFile, offset: Int): Boolean {
		val element = file.findElementAt(offset)?:return false
		val parent = element.parent?:return false
		return parent is PsiFile || parent is StarboundTextString
	}
}
