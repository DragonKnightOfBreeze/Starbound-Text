package icu.windea.starboundText.codeInsight.template

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.psi.PsiFile
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.StarboundTextString

class StarboundTextTemplateContext : TemplateContextType(StarboundTextBundle.message("starboundText.templateContextType")) {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        val file = templateActionContext.file
        val offset = templateActionContext.startOffset
        val element = file.findElementAt(offset) ?: return false
        val parent = element.parent ?: return false
        return parent is StarboundTextString
    }
}
