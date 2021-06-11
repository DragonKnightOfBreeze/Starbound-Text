// This is a generated file. Not intended for manual editing.
package icu.windea.starboundText.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import icu.windea.starboundText.psi.impl.*;

public interface StarboundTextTypes {

  IElementType COLORFUL_TEXT = new StarboundTextElementType("COLORFUL_TEXT");
  IElementType COLOR_MARKER = new StarboundTextElementType("COLOR_MARKER");
  IElementType ESCAPE = new StarboundTextElementType("ESCAPE");
  IElementType RESET_MARKER = new StarboundTextElementType("RESET_MARKER");
  IElementType RICH_TEXT = new StarboundTextElementType("RICH_TEXT");
  IElementType STRING = new StarboundTextElementType("STRING");
  IElementType TRUNCATE_MARKER = new StarboundTextElementType("TRUNCATE_MARKER");

  IElementType COLOR_CODE = new StarboundTextTokenType("COLOR_CODE");
  IElementType COLOR_MARKER_END = new StarboundTextTokenType(";");
  IElementType COLOR_MARKER_START = new StarboundTextTokenType("^");
  IElementType INVALID_ESCAPE_TOKEN = new StarboundTextTokenType("INVALID_ESCAPE_TOKEN");
  IElementType RESET_MARKER_TOKEN = new StarboundTextTokenType("^reset;");
  IElementType TEXT_TOKEN = new StarboundTextTokenType("TEXT_TOKEN");
  IElementType TRUNCATE_MARKER_TOKEN = new StarboundTextTokenType("^truncate;");
  IElementType VALID_ESCAPE_TOKEN = new StarboundTextTokenType("VALID_ESCAPE_TOKEN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COLORFUL_TEXT) {
        return new StarboundTextColorfulTextImpl(node);
      }
      else if (type == COLOR_MARKER) {
        return new StarboundTextColorMarkerImpl(node);
      }
      else if (type == ESCAPE) {
        return new StarboundTextEscapeImpl(node);
      }
      else if (type == RESET_MARKER) {
        return new StarboundTextResetMarkerImpl(node);
      }
      else if (type == STRING) {
        return new StarboundTextStringImpl(node);
      }
      else if (type == TRUNCATE_MARKER) {
        return new StarboundTextTruncateMarkerImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
