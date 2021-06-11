package icu.windea.starboundText.psi.impl

import com.intellij.psi.*
import com.intellij.refactoring.suggested.*
import icu.windea.starboundText.*
import icu.windea.starboundText.editor.*
import icu.windea.starboundText.editor.StarboundColor.Companion.colorCache
import icu.windea.starboundText.psi.*
import java.awt.*

object SbTextPsiImplUtil {
	@JvmStatic
	fun getName(element:SbTextColorfulText):String?{
		return element.colorMarker.colorCode?.text
	}

	@JvmStatic
	fun setName(element:SbTextColorfulText,name:String):PsiElement{
		try {
			val newColorMarker = SbTextElementFactory.createColorMarker(element.project,name)
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

