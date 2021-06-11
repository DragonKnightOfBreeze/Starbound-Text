// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static icu.windea.starboundText.psi.StarboundTextTypes.*;
import icu.windea.starboundText.psi.*;
import java.awt.Color;

public class StarboundTextColorfulTextImpl extends StarboundTextNamedElementImpl implements StarboundTextColorfulText {

  public StarboundTextColorfulTextImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull StarboundTextVisitor visitor) {
    visitor.visitColorfulText(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StarboundTextVisitor) accept((StarboundTextVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public StarboundTextColorMarker getColorMarker() {
    return findNotNullChildByClass(StarboundTextColorMarker.class);
  }

  @Override
  @Nullable
  public StarboundTextResetMarker getResetMarker() {
    return findChildByClass(StarboundTextResetMarker.class);
  }

  @Override
  @Nullable
  public StarboundTextString getString() {
    return findChildByClass(StarboundTextString.class);
  }

  @Override
  @Nullable
  public String getName() {
    return StarboundTextPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public PsiElement setName(@NotNull String name) {
    return StarboundTextPsiImplUtil.setName(this, name);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return StarboundTextPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public int getTextOffset() {
    return StarboundTextPsiImplUtil.getTextOffset(this);
  }

  @Override
  @Nullable
  public Color getColor() {
    return StarboundTextPsiImplUtil.getColor(this);
  }

  @Override
  public void setColor(@NotNull Color color) {
    StarboundTextPsiImplUtil.setColor(this, color);
  }

}
