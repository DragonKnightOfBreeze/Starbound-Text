package com.windea.plugin.idea.sbtext.inspections

import com.intellij.codeInspection.*
import com.intellij.openapi.application.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.windea.plugin.idea.sbtext.*
import com.windea.plugin.idea.sbtext.psi.*

class UnnecessaryMarkerInspection: LocalInspectionTool() {
	companion object{
		private fun _description1(name:String) = message("sbText.inspection.unnecessaryColorMarker",name)
		private val _description2 = message("sbText.inspection.unnecessaryResetMarker")
	}
	
	override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
		return Visitor(holder)
	}
	
	private class Visitor(private val holder:ProblemsHolder):SbTextVisitor(){
		override fun visitElement(element: PsiElement) {
			when{
				element is SbTextColorMarker && element.nextSibling !is SbTextString -> {
					holder.registerProblem(element, _description1(element.text),RemoveMarker(element))
				}
				element is SbTextResetMarker && (element.prevSibling !is SbTextString || element.parent !is SbTextColorfulText)-> {
					holder.registerProblem(element, _description2,RemoveMarker(element))
				}
			}
		}
	}
	
	private class RemoveMarker(element:PsiElement):LocalQuickFixAndIntentionActionOnPsiElement(element){
		companion object{
			private val _name = message("sbText.quickFix.removeUnnecessaryMarker")
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