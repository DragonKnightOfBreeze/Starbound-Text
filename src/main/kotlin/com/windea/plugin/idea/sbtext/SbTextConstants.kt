package com.windea.plugin.idea.sbtext

import com.intellij.icons.*

const val sbTextName = "Starbound Text"
const val sbTextNamePc = "StarboundText"
const val sbTextNameSsc = "STARBOUND_TEXT"
const val sbTextLanguageName = "Starbound Text"
const val sbTextFileTypeName = "$sbTextName File"
const val sbTextFileTypeDescription = "Starbound rich text"
const val sbTextExtension = "sbtxt"
const val sbTextBundleName = "messages.SbTextBundle"

val sbTextDummyText = """
	This is some ^red;red^reset; text.
	And this is some ^#f8f8f8;custom color^reset; text.
""".trimIndent()

val sbTextFileIcon = AllIcons.FileTypes.Text
