package icu.windea.starboundText.highlighter

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.HighlighterColors.*
import com.intellij.openapi.editor.colors.*
import com.intellij.openapi.editor.colors.TextAttributesKey.*
import icu.windea.starboundText.*
import icu.windea.starboundText.editor.*
import java.awt.*

object SbTextAttributesKeys {
	@JvmField val MARKER_KEY = createTextAttributesKey(message("sbText.syntax.marker"), KEYWORD)
	@JvmField val COLOR_CODE_KEY = createTextAttributesKey(message("sbText.syntax.colorCode"), KEYWORD)
	@JvmField val TEXT_KEY = createTextAttributesKey(message("sbText.syntax.text"),TEXT)
	@JvmField val VALID_ESCAPE_KEY = createTextAttributesKey(message("sbText.syntax.validEscape"), VALID_STRING_ESCAPE)
	@JvmField val INVALID_ESCAPE_KEY = createTextAttributesKey(message("sbText.syntax.invalidEscape"), INVALID_STRING_ESCAPE)
	@JvmField val BAD_CHARACTER_KEY = createTextAttributesKey(message("sbText.syntax.badCharacter"), BAD_CHARACTER)
	
	@JvmField val COLORFUL_TEXT_KEYS = StarboundColor.map.mapValuesTo(mutableMapOf()) { (_, value) ->
		val attributes = TEXT.defaultAttributes.clone().apply{
			foregroundColor=value.color
		}
		createTextAttributesKey("${message("sbText.syntax.colorfulText")}_${value.key.toUpperCase()}", attributes)
	}
	fun createColorfulTextKey(colorId:String,color:Color):TextAttributesKey{
		val attributes = TEXT.defaultAttributes.clone().apply{
			foregroundColor=color
		}
		return createTextAttributesKey("${message("sbText.syntax.colorfulText")}_${colorId.toUpperCase()}", attributes)
	}
}
