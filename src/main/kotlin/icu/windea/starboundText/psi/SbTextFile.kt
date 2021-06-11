package icu.windea.starboundText.psi

import com.intellij.extapi.psi.*
import com.intellij.openapi.fileTypes.*
import com.intellij.psi.*
import icu.windea.starboundText.*

class SbTextFile(
	viewProvider: FileViewProvider
): PsiFileBase(viewProvider, SbTextLanguage){
	override fun getFileType(): FileType {
		return SbTextFileType
	}
}
