package icu.windea.starboundText.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import icu.windea.starboundText.psi.StarboundTextNamedElement

abstract class StarboundTextNamedElementImpl(node: ASTNode): ASTWrapperPsiElement(node), StarboundTextNamedElement
