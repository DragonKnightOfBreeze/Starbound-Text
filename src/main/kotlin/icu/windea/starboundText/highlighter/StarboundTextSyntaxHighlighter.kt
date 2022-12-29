package icu.windea.starboundText.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType.BAD_CHARACTER
import com.intellij.psi.tree.IElementType
import icu.windea.starboundText.psi.StarboundTextLexerAdapter
import icu.windea.starboundText.psi.StarboundTextTypes.*

class StarboundTextSyntaxHighlighter: SyntaxHighlighterBase(){
	companion object{
		private val MARKER_KEYS = arrayOf(StarboundTextAttributesKeys.MARKER_KEY)
		private val COLOR_CODE_KEYS = arrayOf(StarboundTextAttributesKeys.COLOR_CODE_KEY)
		private val TEXT_KEYS = arrayOf(StarboundTextAttributesKeys.TEXT_KEY)
		private val VALID_ESCAPE_KEYS = arrayOf(StarboundTextAttributesKeys.VALID_ESCAPE_KEY)
		private val INVALID_ESCAPE_KEYS = arrayOf(StarboundTextAttributesKeys.INVALID_ESCAPE_KEY)
		private val BAD_CHARACTER_KEYS = arrayOf(StarboundTextAttributesKeys.BAD_CHARACTER_KEY)
		private val EMPTY_KEYS = TextAttributesKey.EMPTY_ARRAY
	}

	override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
		return when(tokenType){
			COLOR_MARKER_START, COLOR_MARKER_END, RESET_MARKER_TOKEN, TRUNCATE_MARKER_TOKEN -> MARKER_KEYS
			COLOR_CODE -> COLOR_CODE_KEYS
			TEXT_TOKEN -> TEXT_KEYS
			VALID_ESCAPE_TOKEN -> VALID_ESCAPE_KEYS
			INVALID_ESCAPE_TOKEN -> INVALID_ESCAPE_KEYS
			BAD_CHARACTER -> BAD_CHARACTER_KEYS
			else -> EMPTY_KEYS
		}
	}

	override fun getHighlightingLexer() = StarboundTextLexerAdapter()
}

