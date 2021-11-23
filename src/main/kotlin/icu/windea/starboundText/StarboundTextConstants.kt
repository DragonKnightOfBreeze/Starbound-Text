package icu.windea.starboundText

import com.intellij.icons.*

//Common Constants

const val starboundTextBundleName = "messages.StarboundTextBundle"
val locationClass = StarboundTextBundle::class.java

const val starboundTextName = "Starbound Text"
const val starboundTextDescription = "Starbound text"
const val starboundTextId = "STARBOUND_TEXT"
val starboundTextDemoText = "/demoText/StarboundText.txt".toUrl(locationClass).readText()

const val foldingPlaceholder = ""

//Icons

val starboundTextFileIcon = AllIcons.FileTypes.Text
