package icu.windea.starboundText

import com.intellij.icons.*

//Core Constants

const val starboundTextBundleName = "messages.StarboundTextBundle"
val locationClass = StarboundTextBundle::class.java

//String Constants

const val starboundTextName = "Starbound Text"
const val starboundTextDescription = "Starbound text"
const val starboundTextId = "StarboundText"
val starboundTextDemoText = "/demoText/StarboundText.txt".toUrl(locationClass).readText()

//Misc Constants

const val foldingPlaceholder = ""

//Icons

val starboundTextFileIcon = AllIcons.FileTypes.Text
