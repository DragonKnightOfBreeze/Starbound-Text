package com.windea.plugin.idea.sbtext.editor

import com.intellij.lang.*
import com.intellij.lang.folding.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.intellij.psi.impl.file.*
import com.intellij.psi.tree.*
import com.intellij.psi.util.*
import com.windea.plugin.idea.sbtext.psi.*

//折叠颜色标记

class SbTextFoldingBuilder : FoldingBuilder, DumbAware {
	companion object {
		private val foldingGroup = FoldingGroup.newGroup("STARBOUND_TEXT_COLOR_MARKER")
	}
	
	//这里的node/root居然默认是FILE……
	override fun buildFoldRegions(node: ASTNode, document: Document): Array<FoldingDescriptor> {
		val result = mutableListOf<FoldingDescriptor>()
		val file = node.psi.containingFile ?: return FoldingDescriptor.EMPTY
		file.accept(object:PsiRecursiveElementVisitor(){
			override fun visitElement(element: PsiElement) {
				when(element){
					is SbTextColorMarker -> result += FoldingDescriptor(element.node,element.textRange,foldingGroup)
					is SbTextColorResetMarker -> result += FoldingDescriptor(element.node,element.textRange,foldingGroup)
				}
			}
		})
		return result.toTypedArray()
	}

	override fun getPlaceholderText(node: ASTNode): String? {
		return "<>"
	}

	override fun isCollapsedByDefault(node: ASTNode): Boolean {
		return false
	}
}
