package icu.windea.starboundText.highlighter

import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class StarboundTextSyntaxHighlighterFactory: SyntaxHighlighterFactory(){
	override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = StarboundTextSyntaxHighlighter()
}
