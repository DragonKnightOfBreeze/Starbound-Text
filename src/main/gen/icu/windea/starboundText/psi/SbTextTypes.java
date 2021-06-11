// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import icu.windea.starboundText.psi.impl.*;

public interface SbTextTypes {

  IElementType COLORFUL_TEXT = new SbTextElementType("COLORFUL_TEXT");
  IElementType COLOR_MARKER = new SbTextElementType("COLOR_MARKER");
  IElementType ESCAPE = new SbTextElementType("ESCAPE");
  IElementType RESET_MARKER = new SbTextElementType("RESET_MARKER");
  IElementType RICH_TEXT = new SbTextElementType("RICH_TEXT");
  IElementType STRING = new SbTextElementType("STRING");
  IElementType TRUNCATE_MARKER = new SbTextElementType("TRUNCATE_MARKER");

  IElementType COLOR_CODE = new SbTextTokenType("COLOR_CODE");
  IElementType COLOR_MARKER_END = new SbTextTokenType(";");
  IElementType COLOR_MARKER_START = new SbTextTokenType("^");
  IElementType INVALID_ESCAPE_TOKEN = new SbTextTokenType("INVALID_ESCAPE_TOKEN");
  IElementType RESET_MARKER_TOKEN = new SbTextTokenType("^reset;");
  IElementType TEXT_TOKEN = new SbTextTokenType("TEXT_TOKEN");
  IElementType TRUNCATE_MARKER_TOKEN = new SbTextTokenType("^truncate;");
  IElementType VALID_ESCAPE_TOKEN = new SbTextTokenType("VALID_ESCAPE_TOKEN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COLORFUL_TEXT) {
        return new SbTextColorfulTextImpl(node);
      }
      else if (type == COLOR_MARKER) {
        return new SbTextColorMarkerImpl(node);
      }
      else if (type == ESCAPE) {
        return new SbTextEscapeImpl(node);
      }
      else if (type == RESET_MARKER) {
        return new SbTextResetMarkerImpl(node);
      }
      else if (type == STRING) {
        return new SbTextStringImpl(node);
      }
      else if (type == TRUNCATE_MARKER) {
        return new SbTextTruncateMarkerImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
