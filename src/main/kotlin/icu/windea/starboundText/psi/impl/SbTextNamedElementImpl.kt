package icu.windea.starboundText.psi.impl

import com.intellij.extapi.psi.*
import com.intellij.lang.*
import icu.windea.starboundText.psi.*

abstract class SbTextNamedElementImpl(node: ASTNode): ASTWrapperPsiElement(node), SbTextNamedElement
