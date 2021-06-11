package icu.windea.starboundText.psi.impl

import com.intellij.extapi.psi.*
import com.intellij.lang.*
import icu.windea.starboundText.psi.*

abstract class StarboundTextNamedElementImpl(node: ASTNode): ASTWrapperPsiElement(node), StarboundTextNamedElement
