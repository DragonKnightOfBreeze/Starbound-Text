package icu.windea.starboundText.editor

import com.intellij.lang.*
import com.intellij.lang.folding.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import icu.windea.starboundText.*
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
