package icu.windea.starboundText.editor

import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.psi.PsiFile
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.StarboundTextFile
import icu.windea.starboundText.psi.StarboundTextString

class StarboundTextTemplateContext : TemplateContextType(starboundTextId, starboundTextName) {
    override fun isInContext(file: PsiFile, offset: Int): Boolean {
        val element = file.findElementAt(offset) ?: return false
        val parent = element.parent ?: return false
        return parent is StarboundTextString
    }
}
