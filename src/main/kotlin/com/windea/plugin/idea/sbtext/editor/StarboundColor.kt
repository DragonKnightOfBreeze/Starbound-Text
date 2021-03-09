package com.windea.plugin.idea.sbtext.editor

import com.intellij.util.ui.*
import java.awt.*
import java.util.concurrent.*

//TODO 更加完善的预定义颜色

//purple
//indigo
//brown
//cornflowerblue
//black
//shadow

enum class StarboundColor(
	val key:String,
	val color: Color
) {
	Red("red", Color(0xff0000)),
	Green("green",Color(0x00ff00)),
	Blue("blue",Color(0x0000ff)),
	Yellow("yellow",Color(0xffff00)),
	Cyan("cyan",Color(0x00ffff)),
	Orange("orange",Color(0xffa500)),
	Pink("pink",Color(0xffc0cb)),
	Purple("purple",Color(0x800080)),
	Indigo("indigo",Color(0x4b0082)),
	Brown("brown",Color(0xa52a2a)),
	White("white",Color(0x000000)),
	Black("black",Color(0x00ffff)),
	CornFlowerBlue("cornflowerblue",Color(0x6495ed)),
	Shadow("shadow",Color(0x2f4f4f)),
	Gray("gray",Color(0x808080)),
	Grey("grey",Color(0x808080));

	val icon = ColorIcon(16, color)
	val gutterIcon = ColorIcon(12, color)

	fun format(text: String) = "^$key;$text^reset;"

	fun formatRemain(text: String) = "^$key;$text"

	companion object{
		val values = values()
		val map = values.associateBy { it.key }
		val colorCache = ConcurrentHashMap<String,Color>() 
	}
}
