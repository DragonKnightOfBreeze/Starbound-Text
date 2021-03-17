// This is a generated file. Not intended for manual editing.
package com.windea.plugin.idea.sbtext.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.windea.plugin.idea.sbtext.psi.SbTextTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SbTextParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(COLORFUL_TEXT, ESCAPE, RICH_TEXT, STRING),
  };

  /* ********************************************************** */
  // COLOR_MARKER_START COLOR_CODE COLOR_MARKER_END
  public static boolean color_marker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "color_marker")) return false;
    if (!nextTokenIs(b, COLOR_MARKER_START)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COLOR_MARKER, null);
    r = consumeTokens(b, 1, COLOR_MARKER_START, COLOR_CODE, COLOR_MARKER_END);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // color_marker string? reset_marker?
  public static boolean colorful_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colorful_text")) return false;
    if (!nextTokenIs(b, COLOR_MARKER_START)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COLORFUL_TEXT, null);
    r = color_marker(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, colorful_text_1(b, l + 1));
    r = p && colorful_text_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // string?
  private static boolean colorful_text_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colorful_text_1")) return false;
    string(b, l + 1);
    return true;
  }

  // reset_marker?
  private static boolean colorful_text_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colorful_text_2")) return false;
    reset_marker(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // VALID_ESCAPE_TOKEN | INVALID_ESCAPE_TOKEN
  public static boolean escape(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escape")) return false;
    if (!nextTokenIs(b, "<escape>", INVALID_ESCAPE_TOKEN, VALID_ESCAPE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ESCAPE, "<escape>");
    r = consumeToken(b, VALID_ESCAPE_TOKEN);
    if (!r) r = consumeToken(b, INVALID_ESCAPE_TOKEN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RESET_MARKER_TOKEN
  public static boolean reset_marker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reset_marker")) return false;
    if (!nextTokenIs(b, RESET_MARKER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RESET_MARKER_TOKEN);
    exit_section_(b, m, RESET_MARKER, r);
    return r;
  }

  /* ********************************************************** */
  // colorful_text | escape | string
  public static boolean rich_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rich_text")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, RICH_TEXT, "<rich text>");
    r = colorful_text(b, l + 1);
    if (!r) r = escape(b, l + 1);
    if (!r) r = string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (rich_text | reset_marker | truncate_marker) *
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  // rich_text | reset_marker | truncate_marker
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = rich_text(b, l + 1);
    if (!r) r = reset_marker(b, l + 1);
    if (!r) r = truncate_marker(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TEXT_TOKEN
  public static boolean string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string")) return false;
    if (!nextTokenIs(b, TEXT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXT_TOKEN);
    exit_section_(b, m, STRING, r);
    return r;
  }

  /* ********************************************************** */
  // TRUNCATE_MARKER_TOKEN
  public static boolean truncate_marker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "truncate_marker")) return false;
    if (!nextTokenIs(b, TRUNCATE_MARKER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRUNCATE_MARKER_TOKEN);
    exit_section_(b, m, TRUNCATE_MARKER, r);
    return r;
  }

}
