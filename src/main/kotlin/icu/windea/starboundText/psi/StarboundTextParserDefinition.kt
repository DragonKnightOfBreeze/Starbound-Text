@file:Suppress("HasPlatformType")

package icu.windea.starboundText.psi

import com.intellij.lang.*
import com.intellij.openapi.project.*
import com.intellij.psi.*
import com.intellij.psi.tree.*
import icu.windea.starboundText.*

class StarboundTextParserDefinition: ParserDefinition {
	companion object {
		val WHITE_SPACES = TokenSet.EMPTY
		val COMMENTS = TokenSet.EMPTY
		val STRINGS = TokenSet.create(StarboundTextTypes.TEXT_TOKEN)
		val FILE = IFileElementType(StarboundTextLanguage)
	}

	override fun createLexer(project: Project?) = StarboundTextLexerAdapter()

	override fun getWhitespaceTokens() = WHITE_SPACES

	override fun getCommentTokens() = COMMENTS

	override fun getStringLiteralElements() = STRINGS

	override fun createParser(project: Project?) = StarboundTextParser()

	override fun getFileNodeType() = FILE

	override fun createFile(viewProvider: FileViewProvider) = StarboundTextFile(viewProvider)

	override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
		return ParserDefinition.SpaceRequirements.MUST_NOT
	}

	override fun createElement(node: ASTNode?) = StarboundTextTypes.Factory.createElement(node)
}

