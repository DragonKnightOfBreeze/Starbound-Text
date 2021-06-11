package icu.windea.starboundText

import com.intellij.openapi.fileTypes.*

object StarboundTextFileType: LanguageFileType(StarboundTextLanguage){
	override fun getName() = starboundTextName

	override fun getDescription() = starboundTextDescription

	override fun getDefaultExtension() = ""

	override fun getIcon() = starboundTextFileIcon
}
