// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.sbtext.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import java.awt.Color;

public interface SbTextColorfulText extends SbTextRichText, SbTextNamedElement {

  @NotNull
  SbTextColorMarker getColorMarker();

  @Nullable
  SbTextResetMarker getResetMarker();

  @Nullable
  SbTextString getString();

  @Nullable
  String getName();

  @NotNull
  PsiElement setName(@NotNull String name);

  @Nullable
  PsiElement getNameIdentifier();

  int getTextOffset();

  @Nullable
  Color getColor();

  //WARNING: setColor(...) is skipped
  //matching setColor(SbTextColorfulText, ...)
  //methods are not found in SbTextPsiImplUtil

}
