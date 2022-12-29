package icu.windea.starboundText.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import icu.windea.starboundText.StarboundTextFileType
import icu.windea.starboundText.StarboundTextLanguage

class StarboundTextFile(
	viewProvider: FileViewProvider
): PsiFileBase(viewProvider, StarboundTextLanguage){
	override fun getFileType() = StarboundTextFileType
}
