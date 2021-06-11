package icu.windea.starboundText.inspections

import com.intellij.codeInspection.*
import com.intellij.openapi.application.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import icu.windea.starboundText.*
import icu.windea.starboundText.psi.*

class UnnecessaryMarkerInspection: LocalInspectionTool() {
	companion object{
		private fun _description1(name:String) = message("starboundText.inspection.unnecessaryColorMarker",name)
		private val _description2 = message("starboundText.inspection.unnecessaryResetMarker")
	}
	
	override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
		return Visitor(holder)
	}
	
	private class Visitor(private val holder:ProblemsHolder): StarboundTextVisitor(){
		override fun visitElement(element: PsiElement) {
			when{
				element is StarboundTextColorMarker && element.nextSibling !is StarboundTextString -> {
					holder.registerProblem(element, _description1(element.text),RemoveMarker(element))
				}
				element is StarboundTextResetMarker && (element.prevSibling !is StarboundTextString || element.parent !is StarboundTextColorfulText)-> {
					holder.registerProblem(element, _description2,RemoveMarker(element))
				}
			}
		}
	}
	
	private class RemoveMarker(element:PsiElement):LocalQuickFixAndIntentionActionOnPsiElement(element){
		companion object{
			private val _name = message("starboundText.quickFix.removeUnnecessaryMarker")
		}
		
		override fun getFamilyName() = _name
		
		override fun getText() = _name
		
		override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
			runCatching {
				runWriteAction {
					startElement.delete()
				}
			}
		}
	}
}