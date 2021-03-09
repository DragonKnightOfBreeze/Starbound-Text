@file:Suppress("HasPlatformType")

package com.windea.plugin.idea.sbtext.codeInsight

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.*
import com.intellij.openapi.editor.*
import com.intellij.openapi.util.*
import com.intellij.patterns.PlatformPatterns.*
import com.intellij.util.*
import com.windea.plugin.idea.sbtext.editor.*

class SbTextCompletionContributor : CompletionContributor() {
	companion object{
		private val insertHandler = InsertHandler<LookupElement> { context, _ ->
			//必要时插入后面的分号
			val offset = context.editor.caretModel.offset
			val next =  context.document.getText(TextRange.from(offset,1))
			if(next != ";" ) EditorModificationUtil.insertStringAtCaret(context.editor,";")
		}
		
		private val lookupElements = mutableListOf<LookupElement>().apply{
			for(color in StarboundColor.values) {
				add(LookupElementBuilder.create(color.key).withIcon(color.icon).withInsertHandler(insertHandler))
				add(LookupElementBuilder.create("reset").withBoldness(true).withInsertHandler(insertHandler))
			}
		}
	}
	
	class ColorCodeCompletionProvider : CompletionProvider<CompletionParameters>() {
		override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
			result.addAllElements(lookupElements)
		}
	}

	init {
		extend(CompletionType.BASIC, psiElement().afterLeaf("^"), ColorCodeCompletionProvider())
	}

	override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
		super.fillCompletionVariants(parameters, result)
	}
}

