package icu.windea.starboundText.psi.impl

import com.intellij.psi.*
import com.intellij.refactoring.suggested.*
import icu.windea.starboundText.*
import icu.windea.starboundText.editor.*
import icu.windea.starboundText.editor.StarboundColor.Companion.colorCache
import icu.windea.starboundText.psi.*
import java.awt.*

object StarboundTextPsiImplUtil {
	@JvmStatic
	fun getName(element: StarboundTextColorfulText):String?{
		return element.colorMarker.colorCode?.text
	}

	@JvmStatic
	fun setName(element: StarboundTextColorfulText,name:String):PsiElement{
		try {
			val newColorMarker = StarboundTextElementFactory.createColorMarker(element.project,name)
			return element.colorMarker.replace(newColorMarker)
		}catch(e:Exception){
			return element
		}
	}

	@JvmStatic
	fun getNameIdentifier(element: StarboundTextColorfulText):PsiElement?{
		return element.colorMarker.colorCode
	}

	@JvmStatic
	fun getTextOffset(element: StarboundTextColorfulText):Int{
		return element.colorMarker.colorCode?.startOffset?:element.colorMarker.startOffset + 1
	}

	@JvmStatic
	fun getColor(element: StarboundTextColorfulText): Color? {
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
	fun setColor(element: StarboundTextColorfulText,color:Color){
		element.setName(color.toRgbString())
	}
	
	@JvmStatic
	fun getColor(element: StarboundTextColorMarker): Color? {
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

