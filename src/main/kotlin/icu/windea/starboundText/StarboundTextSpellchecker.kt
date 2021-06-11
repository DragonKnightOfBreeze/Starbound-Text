package icu.windea.starboundText

import com.intellij.psi.*
import com.intellij.psi.util.*
import com.intellij.spellchecker.tokenizer.*
import icu.windea.starboundText.psi.StarboundTextTypes.*

class StarboundTextSpellchecker: SpellcheckingStrategy(){
	override fun getTokenizer(element: PsiElement?): Tokenizer<*> {
		return when(element.elementType){
			TEXT_TOKEN -> TEXT_TOKENIZER
			else -> EMPTY_TOKENIZER
		}
	}
}
