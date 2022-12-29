package icu.windea.starboundText

import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.spellchecker.tokenizer.SpellcheckingStrategy
import com.intellij.spellchecker.tokenizer.Tokenizer
import icu.windea.starboundText.psi.StarboundTextTypes.TEXT_TOKEN

class StarboundTextSpellchecker: SpellcheckingStrategy(){
	override fun getTokenizer(element: PsiElement?): Tokenizer<*> {
		return when(element.elementType){
			TEXT_TOKEN -> TEXT_TOKENIZER
			else -> EMPTY_TOKENIZER
		}
	}
}
