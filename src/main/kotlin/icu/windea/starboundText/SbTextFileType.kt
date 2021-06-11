package icu.windea.starboundText

import com.intellij.openapi.fileTypes.*

object SbTextFileType: LanguageFileType(SbTextLanguage){
	override fun getName() = sbTextName

	override fun getDescription() = sbTextDescription

	override fun getDefaultExtension() = ""

	override fun getIcon() = sbTextFileIcon
}
