package com.windea.plugin.idea.sbtext

import com.intellij.openapi.fileTypes.*

object SbTextFileType: LanguageFileType(SbTextLanguage){
	override fun getName() = sbTextName

	override fun getDescription() = sbTextNameCw

	override fun getDefaultExtension() = ""

	override fun getIcon() = sbTextFileIcon
}
