/* The following code was generated by JFlex 1.6.1 */

/*----------------------------------------------------------------------------
--------------------- 1ra. Area: Codigo de Usuario
----------------------------------------------------------------------------*/

//-------> Paquete, importaciones

package Analizadores;

import java_cup.runtime.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>src/Analizadores/Lexico.jflex</tt>
 */
public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMENT_SIMPLE = 2;
  public static final int COMENT_MULTI = 4;
  public static final int CADENA = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  9,  8, 10,  9,  9,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     9, 49, 11,  0,  0,  0, 50,  5, 39, 40,  7, 37, 36, 38,  2,  6, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 45, 35, 48, 34, 47, 52, 
     0, 24, 19, 22, 16, 21, 29, 28, 23, 13,  3, 33, 20,  3, 14, 17, 
    30,  3, 25, 27, 15, 18,  3, 31,  3,  3,  3, 41,  0, 42, 46,  4, 
     0, 24, 19, 22, 16, 21, 29, 28, 23, 13,  3, 33, 20,  3, 14, 17, 
    30,  3, 25, 27, 15, 18,  3, 31,  3,  3,  3, 43, 51, 44,  0,  0, 
     0,  0,  0,  0,  0, 10,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  3,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\1\7\4\1\1\4\4\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\2\1\1\32"+
    "\2\33\1\34\1\33\2\35\1\36\1\37\1\0\1\40"+
    "\1\41\1\42\1\43\1\0\1\44\1\4\1\44\10\4"+
    "\1\0\4\4\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\1\57\2\60\4\4\1\0"+
    "\4\4\1\0\2\4\1\0\1\4\1\0\1\4\1\61"+
    "\3\4\2\62\1\4\1\63\1\4\1\0\1\4\1\0"+
    "\1\4\1\0\1\4\1\0\3\4\2\64\1\0\2\4"+
    "\1\0\1\4\2\65\1\0\1\4\2\66\1\67\1\4"+
    "\1\0\1\4\1\70\2\71\1\0\1\4\1\72\1\0"+
    "\1\4\2\73\2\74";

  private static int [] zzUnpackAction() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\65\0\152\0\237\0\324\0\u0109\0\324\0\u013e"+
    "\0\u0173\0\u01a8\0\u01dd\0\324\0\324\0\u0212\0\u0247\0\u027c"+
    "\0\u02b1\0\u02e6\0\u031b\0\u0350\0\u0385\0\u03ba\0\u03ef\0\u0424"+
    "\0\u0459\0\u048e\0\u04c3\0\324\0\324\0\u04f8\0\u052d\0\324"+
    "\0\324\0\324\0\324\0\324\0\324\0\324\0\324\0\u0562"+
    "\0\u0597\0\u05cc\0\u0601\0\u0636\0\324\0\324\0\u066b\0\324"+
    "\0\u06a0\0\324\0\u066b\0\324\0\u06d5\0\u070a\0\324\0\324"+
    "\0\324\0\324\0\u073f\0\324\0\u0774\0\u013e\0\u07a9\0\u07de"+
    "\0\u0813\0\u0848\0\u087d\0\u08b2\0\u08e7\0\u091c\0\u0951\0\u0986"+
    "\0\u09bb\0\u09f0\0\u0a25\0\324\0\324\0\324\0\324\0\324"+
    "\0\324\0\324\0\324\0\324\0\324\0\324\0\324\0\u013e"+
    "\0\u0a5a\0\u0a8f\0\u0ac4\0\u0af9\0\u0b2e\0\u0b63\0\u0b98\0\u0bcd"+
    "\0\u0c02\0\u0c37\0\u0c6c\0\u0ca1\0\u0cd6\0\u0d0b\0\u0d40\0\u0d75"+
    "\0\u013e\0\u0daa\0\u0ddf\0\u0e14\0\324\0\u013e\0\u0e49\0\u013e"+
    "\0\u0e7e\0\u0eb3\0\u0ee8\0\u0f1d\0\u0f52\0\u0f87\0\u0fbc\0\u0ff1"+
    "\0\u1026\0\u105b\0\u1090\0\324\0\u013e\0\u10c5\0\u10fa\0\u112f"+
    "\0\u1164\0\u1199\0\324\0\u013e\0\u11ce\0\u1203\0\324\0\u013e"+
    "\0\u013e\0\u1238\0\u126d\0\u12a2\0\u013e\0\324\0\u013e\0\u12d7"+
    "\0\u130c\0\u013e\0\u1341\0\u1376\0\324\0\u013e\0\324\0\u013e";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\2\10\1\11\1\12\1\13\2\14"+
    "\1\0\1\15\1\16\1\17\1\10\1\20\1\21\2\10"+
    "\1\22\1\10\1\23\1\24\2\10\1\25\1\26\1\27"+
    "\1\10\1\30\1\31\1\32\1\5\1\10\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\6\56\1\57\1\56\1\60\62\56\1\57\1\61"+
    "\2\56\1\0\52\56\6\62\1\63\4\62\1\64\51\62"+
    "\66\0\1\6\1\65\63\0\1\10\1\0\2\10\10\0"+
    "\15\10\1\0\5\10\1\0\1\10\24\0\1\66\1\0"+
    "\1\66\11\0\15\66\1\0\5\66\1\0\1\66\31\0"+
    "\1\67\1\70\32\0\1\71\64\0\1\72\40\0\1\73"+
    "\16\0\1\74\30\0\1\10\1\0\2\10\10\0\1\10"+
    "\1\75\13\10\1\0\2\10\1\76\2\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\14\10\1\77\1\0"+
    "\5\10\1\0\1\10\24\0\1\10\1\0\2\10\10\0"+
    "\4\10\1\100\10\10\1\0\5\10\1\0\1\10\24\0"+
    "\1\10\1\0\2\10\10\0\4\10\1\101\7\10\1\102"+
    "\1\0\5\10\1\0\1\10\24\0\1\10\1\0\2\10"+
    "\10\0\7\10\1\103\5\10\1\0\5\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\4\10\1\104\5\10"+
    "\1\105\2\10\1\0\5\10\1\0\1\10\24\0\1\10"+
    "\1\0\2\10\10\0\10\10\1\106\4\10\1\0\5\10"+
    "\1\0\1\10\42\0\1\107\46\0\1\10\1\0\2\10"+
    "\10\0\2\10\1\110\12\10\1\0\5\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\13\10\1\111\1\10"+
    "\1\0\5\10\1\0\1\10\24\0\1\10\1\0\2\10"+
    "\10\0\14\10\1\112\1\0\5\10\1\0\1\10\24\0"+
    "\1\10\1\0\2\10\10\0\12\10\1\113\2\10\1\0"+
    "\5\10\1\0\1\10\65\0\1\114\64\0\1\115\2\0"+
    "\1\116\61\0\1\117\3\0\1\120\60\0\1\121\64\0"+
    "\1\122\64\0\1\123\104\0\1\124\65\0\1\125\7\0"+
    "\1\67\64\0\1\60\57\0\1\65\70\0\1\126\76\0"+
    "\1\127\46\0\1\10\1\0\2\10\10\0\2\10\1\130"+
    "\12\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\10\0\5\10\1\131\7\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\5\10\1\132"+
    "\7\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\10\0\4\10\1\133\10\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\10\10\1\134"+
    "\4\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\10\0\15\10\1\135\1\136\4\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\1\10\1\137\13\10"+
    "\1\0\5\10\1\0\1\10\24\0\1\10\1\0\2\10"+
    "\10\0\13\10\1\140\1\10\1\0\5\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\2\10\1\141\12\10"+
    "\1\0\5\10\1\0\1\10\54\0\1\142\34\0\1\10"+
    "\1\0\2\10\10\0\14\10\1\143\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\7\10\1\144"+
    "\5\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\7\0\1\145\1\146\14\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\7\0\1\147\1\150"+
    "\14\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\10\0\10\10\1\151\4\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\6\10\1\152"+
    "\6\10\1\0\5\10\1\0\1\10\24\0\1\10\1\0"+
    "\2\10\10\0\7\10\1\153\5\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\13\10\1\154"+
    "\1\10\1\0\5\10\1\0\1\10\50\0\1\155\40\0"+
    "\1\10\1\0\2\10\10\0\10\10\1\156\4\10\1\0"+
    "\5\10\1\0\1\10\24\0\1\10\1\0\2\10\10\0"+
    "\2\10\1\157\12\10\1\0\5\10\1\0\1\10\24\0"+
    "\1\10\1\0\2\10\10\0\14\10\1\160\1\0\5\10"+
    "\1\0\1\10\24\0\1\10\1\0\2\10\10\0\5\10"+
    "\1\161\7\10\1\0\5\10\1\0\1\10\37\0\2\162"+
    "\50\0\1\10\1\0\2\10\7\0\1\162\1\163\14\10"+
    "\1\0\5\10\1\0\1\10\24\0\1\10\1\0\2\10"+
    "\10\0\15\10\1\164\1\165\4\10\1\0\1\10\41\0"+
    "\1\166\47\0\1\10\1\0\2\10\10\0\1\10\1\167"+
    "\13\10\1\0\5\10\1\0\1\10\47\0\1\170\41\0"+
    "\1\10\1\0\2\10\10\0\7\10\1\171\5\10\1\0"+
    "\5\10\1\0\1\10\24\0\1\10\1\0\2\10\10\0"+
    "\7\10\1\172\5\10\1\0\5\10\1\0\1\10\24\0"+
    "\1\10\1\0\2\10\10\0\10\10\1\173\4\10\1\0"+
    "\5\10\1\0\1\10\24\0\1\10\1\0\2\10\10\0"+
    "\15\10\1\0\5\10\1\174\1\175\24\0\1\10\1\0"+
    "\2\10\7\0\1\176\1\177\14\10\1\0\5\10\1\0"+
    "\1\10\24\0\1\10\1\0\2\10\10\0\14\10\1\200"+
    "\1\0\5\10\1\0\1\10\41\0\1\201\47\0\1\10"+
    "\1\0\2\10\10\0\1\10\1\202\13\10\1\0\5\10"+
    "\1\0\1\10\50\0\1\203\40\0\1\10\1\0\2\10"+
    "\10\0\10\10\1\204\4\10\1\0\5\10\1\0\1\10"+
    "\42\0\1\205\46\0\1\10\1\0\2\10\10\0\2\10"+
    "\1\206\12\10\1\0\5\10\1\0\1\10\50\0\1\207"+
    "\40\0\1\10\1\0\2\10\10\0\10\10\1\210\4\10"+
    "\1\0\5\10\1\0\1\10\24\0\1\10\1\0\2\10"+
    "\10\0\10\10\1\211\4\10\1\0\5\10\1\0\1\10"+
    "\24\0\1\10\1\0\2\10\10\0\13\10\1\212\1\10"+
    "\1\0\5\10\1\0\1\10\41\0\1\213\47\0\1\10"+
    "\1\0\2\10\10\0\1\10\1\214\13\10\1\0\5\10"+
    "\1\0\1\10\24\0\1\10\1\0\2\10\10\0\1\10"+
    "\1\215\13\10\1\0\5\10\1\0\1\10\57\0\1\216"+
    "\31\0\1\10\1\0\2\10\10\0\15\10\1\0\1\10"+
    "\1\217\3\10\1\0\1\10\47\0\1\220\41\0\1\10"+
    "\1\0\2\10\10\0\7\10\1\221\5\10\1\0\5\10"+
    "\1\0\1\10\24\0\1\10\1\0\2\10\10\0\1\10"+
    "\1\222\13\10\1\0\5\10\1\0\1\10\45\0\1\223"+
    "\43\0\1\10\1\0\2\10\10\0\5\10\1\224\7\10"+
    "\1\0\5\10\1\0\1\10\41\0\1\225\47\0\1\10"+
    "\1\0\2\10\10\0\1\10\1\226\13\10\1\0\5\10"+
    "\1\0\1\10\50\0\1\227\40\0\1\10\1\0\2\10"+
    "\10\0\10\10\1\230\4\10\1\0\5\10\1\0\1\10"+
    "\23\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5035];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\1\11\1\1\1\11\4\1\2\11\16\1\2\11"+
    "\2\1\10\11\5\1\2\11\1\1\1\11\1\1\1\11"+
    "\1\1\1\11\1\1\1\0\4\11\1\0\1\11\12\1"+
    "\1\0\4\1\14\11\5\1\1\0\4\1\1\0\2\1"+
    "\1\0\1\1\1\0\5\1\1\11\4\1\1\0\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\3\1\1\11\1\1"+
    "\1\0\2\1\1\0\1\1\1\11\1\1\1\0\1\1"+
    "\1\11\3\1\1\0\2\1\1\11\1\1\1\0\2\1"+
    "\1\0\1\1\1\11\1\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[152];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    String cadena="";


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }



  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(Simbolos.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");
            }
          case 61: break;
          case 2: 
            { return new Symbol(Simbolos.numero, yycolumn, yyline, yytext());
            }
          case 62: break;
          case 3: 
            { return new Symbol(Simbolos.punto, yycolumn, yyline, yytext());
            }
          case 63: break;
          case 4: 
            { return new Symbol(Simbolos.id, yycolumn, yyline, yytext());
            }
          case 64: break;
          case 5: 
            { return new Symbol(Simbolos.comilla, yycolumn, yyline, yytext());
            }
          case 65: break;
          case 6: 
            { return new Symbol(Simbolos.div, yycolumn, yyline, yytext());
            }
          case 66: break;
          case 7: 
            { return new Symbol(Simbolos.por, yycolumn, yyline, yytext());
            }
          case 67: break;
          case 8: 
            { /* ignore white space. */
            }
          case 68: break;
          case 9: 
            { yybegin(CADENA);
            }
          case 69: break;
          case 10: 
            { return new Symbol(Simbolos.igual, yycolumn, yyline, yytext());
            }
          case 70: break;
          case 11: 
            { return new Symbol(Simbolos.ptocoma, yycolumn, yyline, yytext());
            }
          case 71: break;
          case 12: 
            { return new Symbol(Simbolos.coma, yycolumn, yyline, yytext());
            }
          case 72: break;
          case 13: 
            { return new Symbol(Simbolos.mas, yycolumn, yyline, yytext());
            }
          case 73: break;
          case 14: 
            { return new Symbol(Simbolos.menos, yycolumn, yyline, yytext());
            }
          case 74: break;
          case 15: 
            { return new Symbol(Simbolos.parizq, yycolumn, yyline, yytext());
            }
          case 75: break;
          case 16: 
            { return new Symbol(Simbolos.parder, yycolumn, yyline, yytext());
            }
          case 76: break;
          case 17: 
            { return new Symbol(Simbolos.corizq, yycolumn, yyline, yytext());
            }
          case 77: break;
          case 18: 
            { return new Symbol(Simbolos.corder, yycolumn, yyline, yytext());
            }
          case 78: break;
          case 19: 
            { return new Symbol(Simbolos.llavizq, yycolumn, yyline, yytext());
            }
          case 79: break;
          case 20: 
            { return new Symbol(Simbolos.llavder, yycolumn, yyline, yytext());
            }
          case 80: break;
          case 21: 
            { return new Symbol(Simbolos.dosptos, yycolumn, yyline, yytext());
            }
          case 81: break;
          case 22: 
            { return new Symbol(Simbolos.potencia, yycolumn, yyline, yytext());
            }
          case 82: break;
          case 23: 
            { return new Symbol(Simbolos.mayque, yycolumn, yyline, yytext());
            }
          case 83: break;
          case 24: 
            { return new Symbol(Simbolos.menque, yycolumn, yyline, yytext());
            }
          case 84: break;
          case 25: 
            { return new Symbol(Simbolos.not, yycolumn, yyline, yytext());
            }
          case 85: break;
          case 26: 
            { return new Symbol(Simbolos.pregunta, yycolumn, yyline, yytext());
            }
          case 86: break;
          case 27: 
            { 
            }
          case 87: break;
          case 28: 
            { yybegin(YYINITIAL);
            }
          case 88: break;
          case 29: 
            { cadena += yytext();
            }
          case 89: break;
          case 30: 
            { String temp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(Simbolos.cadena, yycolumn, yyline, temp);
            }
          case 90: break;
          case 31: 
            { return new Symbol(Simbolos.decimal, yycolumn, yyline, yytext());
            }
          case 91: break;
          case 32: 
            { yybegin(COMENT_SIMPLE);
            }
          case 92: break;
          case 33: 
            { yybegin(COMENT_MULTI);
            }
          case 93: break;
          case 34: 
            { return new Symbol(Simbolos.divigual, yycolumn, yyline, yytext());
            }
          case 94: break;
          case 35: 
            { return new Symbol(Simbolos.porigual, yycolumn, yyline, yytext());
            }
          case 95: break;
          case 36: 
            { return new Symbol(Simbolos.rif, yycolumn, yyline, yytext());
            }
          case 96: break;
          case 37: 
            { return new Symbol(Simbolos.igualque, yycolumn, yyline, yytext());
            }
          case 97: break;
          case 38: 
            { return new Symbol(Simbolos.masigual, yycolumn, yyline, yytext());
            }
          case 98: break;
          case 39: 
            { return new Symbol(Simbolos.masmas, yycolumn, yyline, yytext());
            }
          case 99: break;
          case 40: 
            { return new Symbol(Simbolos.menosigual, yycolumn, yyline, yytext());
            }
          case 100: break;
          case 41: 
            { return new Symbol(Simbolos.menosmenos, yycolumn, yyline, yytext());
            }
          case 101: break;
          case 42: 
            { return new Symbol(Simbolos.mayigualque, yycolumn, yyline, yytext());
            }
          case 102: break;
          case 43: 
            { return new Symbol(Simbolos.menigualque, yycolumn, yyline, yytext());
            }
          case 103: break;
          case 44: 
            { return new Symbol(Simbolos.difque, yycolumn, yyline, yytext());
            }
          case 104: break;
          case 45: 
            { return new Symbol(Simbolos.and, yycolumn, yyline, yytext());
            }
          case 105: break;
          case 46: 
            { return new Symbol(Simbolos.or, yycolumn, yyline, yytext());
            }
          case 106: break;
          case 47: 
            { return new Symbol(Simbolos.caracter, yycolumn, yyline, yytext());
            }
          case 107: break;
          case 48: 
            { return new Symbol(Simbolos.rint, yycolumn, yyline, yytext());
            }
          case 108: break;
          case 49: 
            { return new Symbol(Simbolos.rtrue, yycolumn, yyline, yytext());
            }
          case 109: break;
          case 50: 
            { return new Symbol(Simbolos.relse, yycolumn, yyline, yytext());
            }
          case 110: break;
          case 51: 
            { return new Symbol(Simbolos.rchar, yycolumn, yyline, yytext());
            }
          case 111: break;
          case 52: 
            { return new Symbol(Simbolos.rbreak, yycolumn, yyline, yytext());
            }
          case 112: break;
          case 53: 
            { return new Symbol(Simbolos.rfalse, yycolumn, yyline, yytext());
            }
          case 113: break;
          case 54: 
            { return new Symbol(Simbolos.rwhile, yycolumn, yyline, yytext());
            }
          case 114: break;
          case 55: 
            { return new Symbol(Simbolos.rdouble, yycolumn, yyline, yytext());
            }
          case 115: break;
          case 56: 
            { return new Symbol(Simbolos.rreturn, yycolumn, yyline, yytext());
            }
          case 116: break;
          case 57: 
            { return new Symbol(Simbolos.rstring, yycolumn, yyline, yytext());
            }
          case 117: break;
          case 58: 
            { return new Symbol(Simbolos.rboolean, yycolumn, yyline, yytext());
            }
          case 118: break;
          case 59: 
            { return new Symbol(Simbolos.rprintln, yycolumn, yyline, yytext());
            }
          case 119: break;
          case 60: 
            { return new Symbol(Simbolos.rcontinue, yycolumn, yyline, yytext());
            }
          case 120: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
