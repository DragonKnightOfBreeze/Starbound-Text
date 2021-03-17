// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.sbtext.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SbTextVisitor extends PsiElementVisitor {

  public void visitColorMarker(@NotNull SbTextColorMarker o) {
    visitPsiElement(o);
  }

  public void visitColorfulText(@NotNull SbTextColorfulText o) {
    visitRichText(o);
    // visitNamedElement(o);
  }

  public void visitEscape(@NotNull SbTextEscape o) {
    visitRichText(o);
  }

  public void visitResetMarker(@NotNull SbTextResetMarker o) {
    visitPsiElement(o);
  }

  public void visitRichText(@NotNull SbTextRichText o) {
    visitPsiElement(o);
  }

  public void visitString(@NotNull SbTextString o) {
    visitRichText(o);
  }

  public void visitTruncateMarker(@NotNull SbTextTruncateMarker o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
