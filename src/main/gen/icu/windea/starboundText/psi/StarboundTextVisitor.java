// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class StarboundTextVisitor extends PsiElementVisitor {

  public void visitColorMarker(@NotNull StarboundTextColorMarker o) {
    visitPsiElement(o);
  }

  public void visitColorfulText(@NotNull StarboundTextColorfulText o) {
    visitRichText(o);
    // visitNamedElement(o);
  }

  public void visitEscape(@NotNull StarboundTextEscape o) {
    visitRichText(o);
  }

  public void visitResetMarker(@NotNull StarboundTextResetMarker o) {
    visitPsiElement(o);
  }

  public void visitRichText(@NotNull StarboundTextRichText o) {
    visitPsiElement(o);
  }

  public void visitString(@NotNull StarboundTextString o) {
    visitRichText(o);
  }

  public void visitTruncateMarker(@NotNull StarboundTextTruncateMarker o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
