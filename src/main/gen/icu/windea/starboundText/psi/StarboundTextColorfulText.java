// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import java.awt.Color;

public interface StarboundTextColorfulText extends StarboundTextRichText, StarboundTextNamedElement {

  @NotNull
  StarboundTextColorMarker getColorMarker();

  @Nullable
  StarboundTextResetMarker getResetMarker();

  @Nullable
  StarboundTextString getString();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  int getTextOffset();

  @Nullable
  Color getColor();

  void setColor(@NotNull Color color);

}
