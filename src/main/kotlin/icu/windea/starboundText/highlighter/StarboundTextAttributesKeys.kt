@file:Suppress("DEPRECATION")

package icu.windea.starboundText.highlighter

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors.*
import com.intellij.openapi.editor.HighlighterColors.BAD_CHARACTER
import com.intellij.openapi.editor.HighlighterColors.TEXT
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import icu.windea.starboundText.StarboundTextBundle
import icu.windea.starboundText.editor.StarboundColor
import java.awt.Color
import java.util.*

object StarboundTextAttributesKeys {
    @JvmField val MARKER_KEY = createTextAttributesKey("STARBOUND_TEXT.MARKER", KEYWORD)
    @JvmField val COLOR_CODE_KEY = createTextAttributesKey("STARBOUND_TEXT.COLOR_CODE", KEYWORD)
    @JvmField val TEXT_KEY = createTextAttributesKey("STARBOUND_TEXT.TEXT", TEXT)
    @JvmField val VALID_ESCAPE_KEY = createTextAttributesKey("STARBOUND_TEXT.VALID_ESCAPE", VALID_STRING_ESCAPE)
    @JvmField val INVALID_ESCAPE_KEY = createTextAttributesKey("STARBOUND_TEXT.INVALID_ESCAPE", INVALID_STRING_ESCAPE)
    @JvmField val BAD_CHARACTER_KEY = createTextAttributesKey("STARBOUND_TEXT.BAD_CHARACTER", BAD_CHARACTER)

    @JvmField val COLORFUL_TEXT_KEYS = StarboundColor.map.mapValuesTo(mutableMapOf()) { (_, value) ->
        val attributes = TEXT.defaultAttributes.clone().apply {
            foregroundColor = value.color
        }
        createTextAttributesKey("STARBOUND_TEXT.COLORFUL_TEXT_${value.key.uppercase()}", attributes)
    }

    @JvmStatic
    fun createColorfulTextKey(colorId: String, color: Color): TextAttributesKey {
        val attributes = TEXT.defaultAttributes.clone().apply {
            foregroundColor = color
        }
        return createTextAttributesKey("STARBOUND_TEXT.COLORFUL_TEXT_${colorId.uppercase()}", attributes)
    }
}
