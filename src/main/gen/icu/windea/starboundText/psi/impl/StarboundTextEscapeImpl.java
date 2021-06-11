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

public class StarboundTextEscapeImpl extends StarboundTextRichTextImpl implements StarboundTextEscape {

  public StarboundTextEscapeImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull StarboundTextVisitor visitor) {
    visitor.visitEscape(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof StarboundTextVisitor) accept((StarboundTextVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getInvalidEscapeToken() {
    return findChildByType(INVALID_ESCAPE_TOKEN);
  }

  @Override
  @Nullable
  public PsiElement getValidEscapeToken() {
    return findChildByType(VALID_ESCAPE_TOKEN);
  }

}
