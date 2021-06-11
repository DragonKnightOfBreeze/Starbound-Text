// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static icu.windea.starboundText.psi.SbTextTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import icu.windea.starboundText.psi.*;
import java.awt.Color;

public class SbTextColorMarkerImpl extends ASTWrapperPsiElement implements SbTextColorMarker {

  public SbTextColorMarkerImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SbTextVisitor visitor) {
    visitor.visitColorMarker(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SbTextVisitor) accept((SbTextVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getColorCode() {
    return findChildByType(COLOR_CODE);
  }

  @Override
  @Nullable
  public Color getColor() {
    return SbTextPsiImplUtil.getColor(this);
  }

}
