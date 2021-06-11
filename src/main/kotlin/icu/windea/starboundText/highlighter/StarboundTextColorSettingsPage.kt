@file:Suppress("HasPlatformType")

package icu.windea.starboundText.highlighter

import com.intellij.openapi.fileTypes.*
import com.intellij.openapi.options.colors.*
import icu.windea.starboundText.*

class StarboundTextColorSettingsPage : ColorSettingsPage{
	companion object{
		//Capitalized words
		private val attributesDescriptors = arrayOf(
			AttributesDescriptor(message("starboundText.color.marker"),StarboundTextAttributesKeys.MARKER_KEY),
			AttributesDescriptor(message("starboundText.color.colorCode"),StarboundTextAttributesKeys.COLOR_CODE_KEY),
			AttributesDescriptor(message("starboundText.color.text"),StarboundTextAttributesKeys.TEXT_KEY),
			AttributesDescriptor(message("starboundText.color.validEscape"),StarboundTextAttributesKeys.VALID_ESCAPE_KEY),
			AttributesDescriptor(message("starboundText.color.invalidEscape"),StarboundTextAttributesKeys.INVALID_ESCAPE_KEY),
			AttributesDescriptor(message("starboundText.color.badCharacter"),StarboundTextAttributesKeys.BAD_CHARACTER_KEY)
		)
	}

	override fun getHighlighter() = SyntaxHighlighterFactory.getSyntaxHighlighter(StarboundTextLanguage,null,null)

	override fun getAdditionalHighlightingTagToDescriptorMap() = null

	override fun getIcon() = starboundTextFileIcon

	override fun getAttributeDescriptors() = attributesDescriptors

	override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

	override fun getDisplayName() = starboundTextName

	override fun getDemoText() = starboundTextDemoText
}

