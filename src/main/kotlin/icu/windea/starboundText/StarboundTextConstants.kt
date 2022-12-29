package icu.windea.starboundText

val locationClass = StarboundTextBundle::class.java

const val starboundTextName = "Starbound Text"
val starboundTextDemoText = "/demoText/StarboundText.txt".toUrl(locationClass).readText()

const val foldingPlaceholder = "</>"
