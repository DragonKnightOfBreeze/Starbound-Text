package icu.windea.starboundText.psi

import com.intellij.openapi.project.*
import com.intellij.psi.*
import icu.windea.starboundText.*

object SbTextElementFactory {
	@JvmStatic
	fun createDummyFile(project: Project, text: String): SbTextFile {
		return PsiFileFactory.getInstance(project).createFileFromText(SbTextLanguage, text) as SbTextFile
	}
	
	fun createRichText(project:Project,text: String):SbTextRichText{
		return createDummyFile(project, text).firstChild as SbTextRichText
	}
	
	fun createColorMarker(project: Project,name:String):SbTextColorMarker{
		return createDummyFile(project,"^$name;").firstChild?.firstChild as SbTextColorMarker
	}
}

