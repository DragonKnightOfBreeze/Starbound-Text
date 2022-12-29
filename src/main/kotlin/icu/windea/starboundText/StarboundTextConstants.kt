package icu.windea.starboundText

val locationClass = StarboundTextBundle::class.java

val starboundTextDemoText = "/demoText/StarboundText.txt".toUrl(locationClass).readText()

const val foldingPlaceholder = "</>"
