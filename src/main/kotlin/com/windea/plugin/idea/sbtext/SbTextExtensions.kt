package com.windea.plugin.idea.sbtext

import org.jetbrains.annotations.*
import java.awt.*

fun Boolean.toInt() = if(this) 1 else 0

fun String.toColorOrNull(): Color? {
	//this.startsWith("#") 
	val rgbString = this.drop(1)
	val fqRgbString = when(rgbString.length) {
		6 -> rgbString
		3 -> buildString { rgbString.forEach { append(it).append(it) } }
		else -> return null
	}
	val rgb = fqRgbString.toIntOrNull(16) ?: return null
	return Color(rgb)
}

fun Color.toRgbString():String{
	return buildString{
		append("#")
		append(red.toString(16).padStart(2,'0'))
		append(green.toString(16).padStart(2,'0'))
		append(blue.toString(16).padStart(2,'0'))
	}
} 

fun message(@PropertyKey(resourceBundle = sbTextBundleName) key: String, vararg params: Any): String {
	return SbTextBundle.message(key,*params)
}