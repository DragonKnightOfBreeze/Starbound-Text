package icu.windea.starboundText.highlighter

import com.intellij.openapi.fileTypes.*
import com.intellij.openapi.project.*
import com.intellij.openapi.vfs.*

class StarboundTextSyntaxHighlighterFactory: SyntaxHighlighterFactory(){
	override fun getSyntaxHighlighter(project: Project?, virtualFile: VirtualFile?) = StarboundTextSyntaxHighlighter()
}
