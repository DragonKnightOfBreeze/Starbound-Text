package icu.windea.starboundText.editor

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.FoldingGroup
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementVisitor
import icu.windea.starboundText.foldingPlaceholder
import icu.windea.starboundText.psi.*

//折叠颜色标记

class StarboundTextFoldingBuilder : FoldingBuilder, DumbAware {
	companion object {
		private val foldingGroup = FoldingGroup.newGroup("STARBOUND_TEXT_COLOR_MARKER")
	}
	
	//这里的node/root居然默认是FILE……
	override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
		val result = mutableListOf<FoldingDescriptor>()
		val file = node.psi.containingFile ?: return FoldingDescriptor.EMPTY
		file.acceptChildren(object:PsiRecursiveElementVisitor(){
			override fun visitElement(element: PsiElement) {
				when(element){
					is StarboundTextColorfulText -> super.visitElement(element)
					is StarboundTextColorMarker -> result += FoldingDescriptor(element.node,element.textRange,foldingGroup)
					is StarboundTextResetMarker -> result += FoldingDescriptor(element.node,element.textRange,foldingGroup)
					is StarboundTextTruncateMarker -> result += FoldingDescriptor(element.node,element.textRange,foldingGroup)
				}
			}
		})
		return result.toTypedArray()
	}

	override fun getPlaceholderText(node: ASTNode): String {
		return foldingPlaceholder
	}

	override fun isCollapsedByDefault(node: ASTNode): Boolean {
		return false
	}
}
