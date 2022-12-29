@file:Suppress("HasPlatformType")

package icu.windea.starboundText.editor

import com.intellij.openapi.fileTypes.*
import com.intellij.openapi.options.colors.*
import icons.StarboundTextIcons
import icu.windea.starboundText.*
import icu.windea.starboundText.highlighter.StarboundTextAttributesKeys

class StarboundTextColorSettingsPage : ColorSettingsPage{
	companion object{
		//Capitalized words
		private val attributesDescriptors = arrayOf(
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.marker"), StarboundTextAttributesKeys.MARKER_KEY),
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.colorCode"), StarboundTextAttributesKeys.COLOR_CODE_KEY),
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.text"), StarboundTextAttributesKeys.TEXT_KEY),
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.validEscape"), StarboundTextAttributesKeys.VALID_ESCAPE_KEY),
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.invalidEscape"), StarboundTextAttributesKeys.INVALID_ESCAPE_KEY),
			AttributesDescriptor(StarboundTextBundle.message("starboundText.color.badCharacter"), StarboundTextAttributesKeys.BAD_CHARACTER_KEY)
		)
	}

	override fun getHighlighter() = SyntaxHighlighterFactory.getSyntaxHighlighter(StarboundTextLanguage,null,null)

	override fun getAdditionalHighlightingTagToDescriptorMap() = null

	override fun getIcon() = StarboundTextIcons.StarboundTextFile

	override fun getAttributeDescriptors() = attributesDescriptors

	override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY

	override fun getDisplayName() = StarboundTextBundle.message("options.starboundText.displayName")

	override fun getDemoText() = starboundTextDemoText
}

