package icu.windea.starboundText.psi

import com.intellij.extapi.psi.*
import com.intellij.psi.*
import icu.windea.starboundText.*

class StarboundTextFile(
	viewProvider: FileViewProvider
): PsiFileBase(viewProvider, StarboundTextLanguage){
	override fun getFileType() = StarboundTextFileType
}
