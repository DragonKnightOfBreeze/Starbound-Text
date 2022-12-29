package icu.windea.starboundText

import com.intellij.openapi.fileTypes.LanguageFileType
import icons.StarboundTextIcons

object StarboundTextFileType : LanguageFileType(StarboundTextLanguage) {
	override fun getName() = "Starbound Text"

	override fun getDescription() = StarboundTextBundle.message("filetype.starboundText.description")

	override fun getDisplayName() = StarboundTextBundle.message("filetype.starboundText.displayName")

	override fun getDefaultExtension() = ""

	override fun getIcon() = StarboundTextIcons.StarboundTextFile
}
