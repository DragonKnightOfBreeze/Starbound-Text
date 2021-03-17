package com.windea.plugin.idea.sbtext.psi.impl

import com.intellij.psi.*
import com.intellij.psi.util.*
import com.intellij.refactoring.suggested.*
import com.windea.plugin.idea.sbtext.*
import com.windea.plugin.idea.sbtext.editor.*
import com.windea.plugin.idea.sbtext.editor.StarboundColor.Companion.colorCache
import com.windea.plugin.idea.sbtext.psi.*
import java.awt.*

object SbTextPsiImplUtil {
	@JvmStatic
	fun getName(element:SbTextColorfulText):String?{
		return element.colorMarker.colorCode?.text
	}

	@JvmStatic
	fun setName(element:SbTextColorfulText,name:String):PsiElement{
		try {
			val newColorMarker = SbTextElementFactory.createDummyFile(element.project,"^$name;")
				.findDescendantOfType<SbTextColorMarker>()?:return element
			return element.colorMarker.replace(newColorMarker)
		}catch(e:Exception){
			return element
		}
	}

	@JvmStatic
	fun getNameIdentifier(element: SbTextColorfulText):PsiElement?{
		return element.colorMarker.colorCode
	}

	@JvmStatic
	fun getTextOffset(element:SbTextColorfulText):Int{
		return element.colorMarker.colorCode?.startOffset?:element.colorMarker.startOffset + 1
	}

	@JvmStatic
	fun getColor(element:SbTextColorfulText): Color? {
		try {
			val colorCode = element.name
			return when{
				colorCode == null ->  null
				colorCode.startsWith("#") -> colorCache.getOrPut(colorCode){
					colorCode.toColorOrNull()
				}
				else -> StarboundColor.map[colorCode]?.color
			}
		} catch(e: Exception) {
			return null
		}
	}
	
	@JvmStatic
	fun setColor(element:SbTextColorfulText,color:Color){
		element.setName(color.toRgbString())
	}
	
	@JvmStatic
	fun getColor(element:SbTextColorMarker): Color? {
		try {
			val colorCode = element.colorCode?.text
			return when{
				colorCode == null ->  null
				colorCode.startsWith("#") -> colorCache.getOrPut(colorCode){
					colorCode.toColorOrNull()
				}
				else -> StarboundColor.map[colorCode]?.color
			}
		} catch(e: Exception) {
			return null
		}
	}
}

