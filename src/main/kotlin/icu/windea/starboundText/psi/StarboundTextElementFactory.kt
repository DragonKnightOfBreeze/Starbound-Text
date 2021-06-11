package icu.windea.starboundText.psi

import com.intellij.openapi.project.*
import com.intellij.psi.*
import icu.windea.starboundText.*

object StarboundTextElementFactory {
	@JvmStatic
	fun createDummyFile(project: Project, text: String): StarboundTextFile {
		return PsiFileFactory.getInstance(project).createFileFromText(StarboundTextLanguage, text) as StarboundTextFile
	}
	
	fun createRichText(project:Project,text: String): StarboundTextRichText {
		return createDummyFile(project, text).firstChild as StarboundTextRichText
	}
	
	fun createColorMarker(project: Project,name:String): StarboundTextColorMarker {
		return createDummyFile(project,"^$name;").firstChild?.firstChild as StarboundTextColorMarker
	}
}

