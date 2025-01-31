package org.apache.atlas.query.antlr4;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AtlasDSLLexer extends Lexer {
    public static final    int
                                                  SINGLE_LINE_COMMENT = 1, MULTILINE_COMMENT = 2, WS = 3, NUMBER = 4, FLOATING_NUMBER = 5,
            BOOL                                                      = 6, K_COMMA = 7, K_PLUS = 8, K_MINUS = 9, K_STAR = 10, K_DIV = 11, K_DOT = 12,
            K_LIKE                                                    = 13, K_AND = 14, K_OR = 15, K_LPAREN = 16, K_LBRACKET = 17, K_RPAREN = 18,
            K_RBRACKET                                                = 19, K_LT = 20, K_LTE = 21, K_EQ = 22, K_NEQ = 23, K_GT = 24, K_GTE = 25,
            K_FROM                                                    = 26, K_WHERE = 27, K_ORDERBY = 28, K_GROUPBY = 29, K_LIMIT = 30, K_SELECT = 31,
            K_MAX                                                     = 32, K_MIN = 33, K_SUM = 34, K_COUNT = 35, K_OFFSET = 36, K_AS = 37, K_ISA = 38,
            K_IS                                                      = 39, K_HAS = 40, K_ASC = 41, K_DESC = 42, K_TRUE = 43, K_FALSE = 44, K_HASTERM = 45,
            KEYWORD                                                   = 46, ID = 47, STRING = 48;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0261\b\1\4\2" +
                    "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
                    "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22" +
                    "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31" +
                    "\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t" +
                    " \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t" +
                    "+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64" +
                    "\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t" +
                    "=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4" +
                    "I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3" +
                    "\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17" +
                    "\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26" +
                    "\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35" +
                    "\3\35\3\36\3\36\3\36\3\36\7\36\u00d8\n\36\f\36\16\36\u00db\13\36\3\36" +
                    "\3\36\3\37\3\37\3\37\3\37\7\37\u00e3\n\37\f\37\16\37\u00e6\13\37\3\37" +
                    "\3\37\3\37\5\37\u00eb\n\37\3\37\3\37\3 \3 \7 \u00f1\n \f \16 \u00f4\13" +
                    " \3 \6 \u00f7\n \r \16 \u00f8\5 \u00fb\n \3 \3 \3!\3!\5!\u0101\n!\3!\3" +
                    "!\7!\u0105\n!\f!\16!\u0108\13!\3!\3!\3!\5!\u010d\n!\3!\3!\7!\u0111\n!" +
                    "\f!\16!\u0114\13!\5!\u0116\n!\3\"\3\"\5\"\u011a\n\"\3\"\6\"\u011d\n\"" +
                    "\r\"\16\"\u011e\3\"\3\"\6\"\u0123\n\"\r\"\16\"\u0124\3\"\3\"\3\"\5\"\u012a" +
                    "\n\"\3\"\3\"\7\"\u012e\n\"\f\"\16\"\u0131\13\"\5\"\u0133\n\"\3#\3#\5#" +
                    "\u0137\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\3+\3+\3" +
                    "+\3+\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\5\61\u015d" +
                    "\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0165\n\62\3\63\3\63\3\63\3\63" +
                    "\5\63\u016b\n\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0173\n\64\3\65\3" +
                    "\65\3\65\3\65\5\65\u0179\n\65\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0181" +
                    "\n\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\39\39" +
                    "\39\3:\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=" +
                    "\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A" +
                    "\3A\3B\3B\3B\3C\3C\3C\3C\3D\3D\3D\3E\3E\3E\3E\3F\3F\3F\3F\3G\3G\3G\3G" +
                    "\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3K\3K\3K" +
                    "\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\3K\5K\u0206" +
                    "\nK\3L\3L\3L\3L\7L\u020c\nL\fL\16L\u020f\13L\3L\3L\3L\7L\u0214\nL\fL\16" +
                    "L\u0217\13L\3L\3L\7L\u021b\nL\fL\16L\u021e\13L\3L\3L\7L\u0222\nL\fL\16" +
                    "L\u0225\13L\3L\3L\3L\7L\u022a\nL\fL\16L\u022d\13L\3L\3L\3L\7L\u0232\n" +
                    "L\fL\16L\u0235\13L\3L\3L\7L\u0239\nL\fL\16L\u023c\13L\3L\3L\3L\7L\u0241" +
                    "\nL\fL\16L\u0244\13L\5L\u0246\nL\3M\3M\7M\u024a\nM\fM\16M\u024d\13M\3" +
                    "M\3M\3M\7M\u0252\nM\fM\16M\u0255\13M\3M\3M\3M\7M\u025a\nM\fM\16M\u025d" +
                    "\13M\3M\5M\u0260\nM\3\u00e4\2N\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2" +
                    "\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2" +
                    "\67\29\2;\3=\4?\5A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21Y\22[\23]\24" +
                    "_\25a\26c\27e\30g\31i\32k\33m\34o\35q\36s\37u w!y\"{#}$\177%\u0081&\u0083" +
                    "\'\u0085(\u0087)\u0089*\u008b+\u008d,\u008f-\u0091.\u0093/\u0095\60\u0097" +
                    "\61\u0099\62\3\2#\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2" +
                    "IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4" +
                    "\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZz" +
                    "z\4\2[[{{\4\2\\\\||\3\2\62;\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"" +
                    "\"\3\2$$\3\2))\3\2bb\2\u028d\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2" +
                    "\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2" +
                    "O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3" +
                    "\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2" +
                    "\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2" +
                    "u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2" +
                    "\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089" +
                    "\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2" +
                    "\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\3\u009b" +
                    "\3\2\2\2\5\u009d\3\2\2\2\7\u009f\3\2\2\2\t\u00a1\3\2\2\2\13\u00a3\3\2" +
                    "\2\2\r\u00a5\3\2\2\2\17\u00a7\3\2\2\2\21\u00a9\3\2\2\2\23\u00ab\3\2\2" +
                    "\2\25\u00ad\3\2\2\2\27\u00af\3\2\2\2\31\u00b1\3\2\2\2\33\u00b3\3\2\2\2" +
                    "\35\u00b5\3\2\2\2\37\u00b7\3\2\2\2!\u00b9\3\2\2\2#\u00bb\3\2\2\2%\u00bd" +
                    "\3\2\2\2\'\u00bf\3\2\2\2)\u00c1\3\2\2\2+\u00c3\3\2\2\2-\u00c5\3\2\2\2" +
                    "/\u00c7\3\2\2\2\61\u00c9\3\2\2\2\63\u00cb\3\2\2\2\65\u00cd\3\2\2\2\67" +
                    "\u00cf\3\2\2\29\u00d1\3\2\2\2;\u00d3\3\2\2\2=\u00de\3\2\2\2?\u00fa\3\2" +
                    "\2\2A\u0100\3\2\2\2C\u0119\3\2\2\2E\u0136\3\2\2\2G\u0138\3\2\2\2I\u013a" +
                    "\3\2\2\2K\u013c\3\2\2\2M\u013e\3\2\2\2O\u0140\3\2\2\2Q\u0142\3\2\2\2S" +
                    "\u0144\3\2\2\2U\u0149\3\2\2\2W\u014d\3\2\2\2Y\u0150\3\2\2\2[\u0152\3\2" +
                    "\2\2]\u0154\3\2\2\2_\u0156\3\2\2\2a\u015c\3\2\2\2c\u0164\3\2\2\2e\u016a" +
                    "\3\2\2\2g\u0172\3\2\2\2i\u0178\3\2\2\2k\u0180\3\2\2\2m\u0182\3\2\2\2o" +
                    "\u0187\3\2\2\2q\u018d\3\2\2\2s\u0195\3\2\2\2u\u019d\3\2\2\2w\u01a3\3\2" +
                    "\2\2y\u01aa\3\2\2\2{\u01ae\3\2\2\2}\u01b2\3\2\2\2\177\u01b6\3\2\2\2\u0081" +
                    "\u01bc\3\2\2\2\u0083\u01c3\3\2\2\2\u0085\u01c6\3\2\2\2\u0087\u01ca\3\2" +
                    "\2\2\u0089\u01cd\3\2\2\2\u008b\u01d1\3\2\2\2\u008d\u01d5\3\2\2\2\u008f" +
                    "\u01da\3\2\2\2\u0091\u01df\3\2\2\2\u0093\u01e5\3\2\2\2\u0095\u0205\3\2" +
                    "\2\2\u0097\u0245\3\2\2\2\u0099\u025f\3\2\2\2\u009b\u009c\t\2\2\2\u009c" +
                    "\4\3\2\2\2\u009d\u009e\t\3\2\2\u009e\6\3\2\2\2\u009f\u00a0\t\4\2\2\u00a0" +
                    "\b\3\2\2\2\u00a1\u00a2\t\5\2\2\u00a2\n\3\2\2\2\u00a3\u00a4\t\6\2\2\u00a4" +
                    "\f\3\2\2\2\u00a5\u00a6\t\7\2\2\u00a6\16\3\2\2\2\u00a7\u00a8\t\b\2\2\u00a8" +
                    "\20\3\2\2\2\u00a9\u00aa\t\t\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\t\n\2\2\u00ac" +
                    "\24\3\2\2\2\u00ad\u00ae\t\13\2\2\u00ae\26\3\2\2\2\u00af\u00b0\t\f\2\2" +
                    "\u00b0\30\3\2\2\2\u00b1\u00b2\t\r\2\2\u00b2\32\3\2\2\2\u00b3\u00b4\t\16" +
                    "\2\2\u00b4\34\3\2\2\2\u00b5\u00b6\t\17\2\2\u00b6\36\3\2\2\2\u00b7\u00b8" +
                    "\t\20\2\2\u00b8 \3\2\2\2\u00b9\u00ba\t\21\2\2\u00ba\"\3\2\2\2\u00bb\u00bc" +
                    "\t\22\2\2\u00bc$\3\2\2\2\u00bd\u00be\t\23\2\2\u00be&\3\2\2\2\u00bf\u00c0" +
                    "\t\24\2\2\u00c0(\3\2\2\2\u00c1\u00c2\t\25\2\2\u00c2*\3\2\2\2\u00c3\u00c4" +
                    "\t\26\2\2\u00c4,\3\2\2\2\u00c5\u00c6\t\27\2\2\u00c6.\3\2\2\2\u00c7\u00c8" +
                    "\t\30\2\2\u00c8\60\3\2\2\2\u00c9\u00ca\t\31\2\2\u00ca\62\3\2\2\2\u00cb" +
                    "\u00cc\t\32\2\2\u00cc\64\3\2\2\2\u00cd\u00ce\t\33\2\2\u00ce\66\3\2\2\2" +
                    "\u00cf\u00d0\t\34\2\2\u00d08\3\2\2\2\u00d1\u00d2\t\35\2\2\u00d2:\3\2\2" +
                    "\2\u00d3\u00d4\7/\2\2\u00d4\u00d5\7/\2\2\u00d5\u00d9\3\2\2\2\u00d6\u00d8" +
                    "\n\36\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2" +
                    "\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd" +
                    "\b\36\2\2\u00dd<\3\2\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\7,\2\2\u00e0" +
                    "\u00e4\3\2\2\2\u00e1\u00e3\13\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3" +
                    "\2\2\2\u00e4\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00ea\3\2\2\2\u00e6" +
                    "\u00e4\3\2\2\2\u00e7\u00e8\7,\2\2\u00e8\u00eb\7\61\2\2\u00e9\u00eb\7\2" +
                    "\2\3\u00ea\u00e7\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec" +
                    "\u00ed\b\37\2\2\u00ed>\3\2\2\2\u00ee\u00f2\7\"\2\2\u00ef\u00f1\7\"\2\2" +
                    "\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3" +
                    "\3\2\2\2\u00f3\u00fb\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\t\37\2\2" +
                    "\u00f6\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9" +
                    "\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00ee\3\2\2\2\u00fa\u00f6\3\2\2\2\u00fb" +
                    "\u00fc\3\2\2\2\u00fc\u00fd\b \2\2\u00fd@\3\2\2\2\u00fe\u0101\5I%\2\u00ff" +
                    "\u0101\5K&\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0100\u0101\3\2\2" +
                    "\2\u0101\u0102\3\2\2\2\u0102\u0106\5\67\34\2\u0103\u0105\5\67\34\2\u0104" +
                    "\u0103\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2" +
                    "\2\2\u0107\u0115\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010c\5\13\6\2\u010a" +
                    "\u010d\5I%\2\u010b\u010d\5K&\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2" +
                    "\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0112\5\67\34\2\u010f\u0111" +
                    "\5\67\34\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2" +
                    "\u0112\u0113\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0109" +
                    "\3\2\2\2\u0115\u0116\3\2\2\2\u0116B\3\2\2\2\u0117\u011a\5I%\2\u0118\u011a" +
                    "\5K&\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a" +
                    "\u011c\3\2\2\2\u011b\u011d\5\67\34\2\u011c\u011b\3\2\2\2\u011d\u011e\3" +
                    "\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120" +
                    "\u0122\5Q)\2\u0121\u0123\5\67\34\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2" +
                    "\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0132\3\2\2\2\u0126" +
                    "\u0129\5\13\6\2\u0127\u012a\5I%\2\u0128\u012a\5K&\2\u0129\u0127\3\2\2" +
                    "\2\u0129\u0128\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012f" +
                    "\5\67\34\2\u012c\u012e\5\67\34\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2" +
                    "\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f" +
                    "\3\2\2\2\u0132\u0126\3\2\2\2\u0132\u0133\3\2\2\2\u0133D\3\2\2\2\u0134" +
                    "\u0137\5\u008fH\2\u0135\u0137\5\u0091I\2\u0136\u0134\3\2\2\2\u0136\u0135" +
                    "\3\2\2\2\u0137F\3\2\2\2\u0138\u0139\7.\2\2\u0139H\3\2\2\2\u013a\u013b" +
                    "\7-\2\2\u013bJ\3\2\2\2\u013c\u013d\7/\2\2\u013dL\3\2\2\2\u013e\u013f\7" +
                    ",\2\2\u013fN\3\2\2\2\u0140\u0141\7\61\2\2\u0141P\3\2\2\2\u0142\u0143\7" +
                    "\60\2\2\u0143R\3\2\2\2\u0144\u0145\5\31\r\2\u0145\u0146\5\23\n\2\u0146" +
                    "\u0147\5\27\f\2\u0147\u0148\5\13\6\2\u0148T\3\2\2\2\u0149\u014a\5\3\2" +
                    "\2\u014a\u014b\5\35\17\2\u014b\u014c\5\t\5\2\u014cV\3\2\2\2\u014d\u014e" +
                    "\5\37\20\2\u014e\u014f\5%\23\2\u014fX\3\2\2\2\u0150\u0151\7*\2\2\u0151" +
                    "Z\3\2\2\2\u0152\u0153\7]\2\2\u0153\\\3\2\2\2\u0154\u0155\7+\2\2\u0155" +
                    "^\3\2\2\2\u0156\u0157\7_\2\2\u0157`\3\2\2\2\u0158\u015d\7>\2\2\u0159\u015a" +
                    "\5\31\r\2\u015a\u015b\5)\25\2\u015b\u015d\3\2\2\2\u015c\u0158\3\2\2\2" +
                    "\u015c\u0159\3\2\2\2\u015db\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0165\7?" +
                    "\2\2\u0160\u0161\5\31\r\2\u0161\u0162\5)\25\2\u0162\u0163\5\13\6\2\u0163" +
                    "\u0165\3\2\2\2\u0164\u015e\3\2\2\2\u0164\u0160\3\2\2\2\u0165d\3\2\2\2" +
                    "\u0166\u016b\7?\2\2\u0167\u0168\5\13\6\2\u0168\u0169\5#\22\2\u0169\u016b" +
                    "\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2\2\u016bf\3\2\2\2\u016c" +
                    "\u016d\7#\2\2\u016d\u0173\7?\2\2\u016e\u016f\5\35\17\2\u016f\u0170\5\13" +
                    "\6\2\u0170\u0171\5#\22\2\u0171\u0173\3\2\2\2\u0172\u016c\3\2\2\2\u0172" +
                    "\u016e\3\2\2\2\u0173h\3\2\2\2\u0174\u0179\7@\2\2\u0175\u0176\5\17\b\2" +
                    "\u0176\u0177\5)\25\2\u0177\u0179\3\2\2\2\u0178\u0174\3\2\2\2\u0178\u0175" +
                    "\3\2\2\2\u0179j\3\2\2\2\u017a\u017b\7@\2\2\u017b\u0181\7?\2\2\u017c\u017d" +
                    "\5\17\b\2\u017d\u017e\5)\25\2\u017e\u017f\5\13\6\2\u017f\u0181\3\2\2\2" +
                    "\u0180\u017a\3\2\2\2\u0180\u017c\3\2\2\2\u0181l\3\2\2\2\u0182\u0183\5" +
                    "\r\7\2\u0183\u0184\5%\23\2\u0184\u0185\5\37\20\2\u0185\u0186\5\33\16\2" +
                    "\u0186n\3\2\2\2\u0187\u0188\5/\30\2\u0188\u0189\5\21\t\2\u0189\u018a\5" +
                    "\13\6\2\u018a\u018b\5%\23\2\u018b\u018c\5\13\6\2\u018cp\3\2\2\2\u018d" +
                    "\u018e\5\37\20\2\u018e\u018f\5%\23\2\u018f\u0190\5\t\5\2\u0190\u0191\5" +
                    "\13\6\2\u0191\u0192\5%\23\2\u0192\u0193\5\5\3\2\u0193\u0194\5\63\32\2" +
                    "\u0194r\3\2\2\2\u0195\u0196\5\17\b\2\u0196\u0197\5%\23\2\u0197\u0198\5" +
                    "\37\20\2\u0198\u0199\5+\26\2\u0199\u019a\5!\21\2\u019a\u019b\5\5\3\2\u019b" +
                    "\u019c\5\63\32\2\u019ct\3\2\2\2\u019d\u019e\5\31\r\2\u019e\u019f\5\23" +
                    "\n\2\u019f\u01a0\5\33\16\2\u01a0\u01a1\5\23\n\2\u01a1\u01a2\5)\25\2\u01a2" +
                    "v\3\2\2\2\u01a3\u01a4\5\'\24\2\u01a4\u01a5\5\13\6\2\u01a5\u01a6\5\31\r" +
                    "\2\u01a6\u01a7\5\13\6\2\u01a7\u01a8\5\7\4\2\u01a8\u01a9\5)\25\2\u01a9" +
                    "x\3\2\2\2\u01aa\u01ab\5\33\16\2\u01ab\u01ac\5\3\2\2\u01ac\u01ad\5\61\31" +
                    "\2\u01adz\3\2\2\2\u01ae\u01af\5\33\16\2\u01af\u01b0\5\23\n\2\u01b0\u01b1" +
                    "\5\35\17\2\u01b1|\3\2\2\2\u01b2\u01b3\5\'\24\2\u01b3\u01b4\5+\26\2\u01b4" +
                    "\u01b5\5\33\16\2\u01b5~\3\2\2\2\u01b6\u01b7\5\7\4\2\u01b7\u01b8\5\37\20" +
                    "\2\u01b8\u01b9\5+\26\2\u01b9\u01ba\5\35\17\2\u01ba\u01bb\5)\25\2\u01bb" +
                    "\u0080\3\2\2\2\u01bc\u01bd\5\37\20\2\u01bd\u01be\5\r\7\2\u01be\u01bf\5" +
                    "\r\7\2\u01bf\u01c0\5\'\24\2\u01c0\u01c1\5\13\6\2\u01c1\u01c2\5)\25\2\u01c2" +
                    "\u0082\3\2\2\2\u01c3\u01c4\5\3\2\2\u01c4\u01c5\5\'\24\2\u01c5\u0084\3" +
                    "\2\2\2\u01c6\u01c7\5\23\n\2\u01c7\u01c8\5\'\24\2\u01c8\u01c9\5\3\2\2\u01c9" +
                    "\u0086\3\2\2\2\u01ca\u01cb\5\23\n\2\u01cb\u01cc\5\'\24\2\u01cc\u0088\3" +
                    "\2\2\2\u01cd\u01ce\5\21\t\2\u01ce\u01cf\5\3\2\2\u01cf\u01d0\5\'\24\2\u01d0" +
                    "\u008a\3\2\2\2\u01d1\u01d2\5\3\2\2\u01d2\u01d3\5\'\24\2\u01d3\u01d4\5" +
                    "\7\4\2\u01d4\u008c\3\2\2\2\u01d5\u01d6\5\t\5\2\u01d6\u01d7\5\13\6\2\u01d7" +
                    "\u01d8\5\'\24\2\u01d8\u01d9\5\7\4\2\u01d9\u008e\3\2\2\2\u01da\u01db\5" +
                    ")\25\2\u01db\u01dc\5%\23\2\u01dc\u01dd\5+\26\2\u01dd\u01de\5\13\6\2\u01de" +
                    "\u0090\3\2\2\2\u01df\u01e0\5\r\7\2\u01e0\u01e1\5\3\2\2\u01e1\u01e2\5\31" +
                    "\r\2\u01e2\u01e3\5\'\24\2\u01e3\u01e4\5\13\6\2\u01e4\u0092\3\2\2\2\u01e5" +
                    "\u01e6\5\21\t\2\u01e6\u01e7\5\3\2\2\u01e7\u01e8\5\'\24\2\u01e8\u01e9\5" +
                    ")\25\2\u01e9\u01ea\5\13\6\2\u01ea\u01eb\5%\23\2\u01eb\u01ec\5\33\16\2" +
                    "\u01ec\u0094\3\2\2\2\u01ed\u0206\5S*\2\u01ee\u0206\5Q)\2\u01ef\u0206\5" +
                    "w<\2\u01f0\u0206\5\u0083B\2\u01f1\u0206\5\u0089E\2\u01f2\u0206\5\u0087" +
                    "D\2\u01f3\u0206\5\u0085C\2\u01f4\u0206\5o8\2\u01f5\u0206\5u;\2\u01f6\u0206" +
                    "\5\u008fH\2\u01f7\u0206\5\u0091I\2\u01f8\u0206\5U+\2\u01f9\u0206\5W,\2" +
                    "\u01fa\u0206\5s:\2\u01fb\u0206\5q9\2\u01fc\u0206\5}?\2\u01fd\u0206\5{" +
                    ">\2\u01fe\u0206\5y=\2\u01ff\u0206\5\u0081A\2\u0200\u0206\5m\67\2\u0201" +
                    "\u0206\5\u008dG\2\u0202\u0206\5\u008bF\2\u0203\u0206\5\177@\2\u0204\u0206" +
                    "\5\u0093J\2\u0205\u01ed\3\2\2\2\u0205\u01ee\3\2\2\2\u0205\u01ef\3\2\2" +
                    "\2\u0205\u01f0\3\2\2\2\u0205\u01f1\3\2\2\2\u0205\u01f2\3\2\2\2\u0205\u01f3" +
                    "\3\2\2\2\u0205\u01f4\3\2\2\2\u0205\u01f5\3\2\2\2\u0205\u01f6\3\2\2\2\u0205" +
                    "\u01f7\3\2\2\2\u0205\u01f8\3\2\2\2\u0205\u01f9\3\2\2\2\u0205\u01fa\3\2" +
                    "\2\2\u0205\u01fb\3\2\2\2\u0205\u01fc\3\2\2\2\u0205\u01fd\3\2\2\2\u0205" +
                    "\u01fe\3\2\2\2\u0205\u01ff\3\2\2\2\u0205\u0200\3\2\2\2\u0205\u0201\3\2" +
                    "\2\2\u0205\u0202\3\2\2\2\u0205\u0203\3\2\2\2\u0205\u0204\3\2\2\2\u0206" +
                    "\u0096\3\2\2\2\u0207\u0246\5\u0099M\2\u0208\u020d\59\35\2\u0209\u020c" +
                    "\59\35\2\u020a\u020c\5\67\34\2\u020b\u0209\3\2\2\2\u020b\u020a\3\2\2\2" +
                    "\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0246" +
                    "\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0215\59\35\2\u0211\u0214\59\35\2\u0212" +
                    "\u0214\5\67\34\2\u0213\u0211\3\2\2\2\u0213\u0212\3\2\2\2\u0214\u0217\3" +
                    "\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217" +
                    "\u0215\3\2\2\2\u0218\u021c\5\u0095K\2\u0219\u021b\5\u0095K\2\u021a\u0219" +
                    "\3\2\2\2\u021b\u021e\3\2\2\2\u021c\u021a\3\2\2\2\u021c\u021d\3\2\2\2\u021d" +
                    "\u0246\3\2\2\2\u021e\u021c\3\2\2\2\u021f\u0223\5\u0095K\2\u0220\u0222" +
                    "\5\u0095K\2\u0221\u0220\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2" +
                    "\2\u0223\u0224\3\2\2\2\u0224\u0226\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u022b" +
                    "\59\35\2\u0227\u022a\59\35\2\u0228\u022a\5\67\34\2\u0229\u0227\3\2\2\2" +
                    "\u0229\u0228\3\2\2\2\u022a\u022d\3\2\2\2\u022b\u0229\3\2\2\2\u022b\u022c" +
                    "\3\2\2\2\u022c\u0246\3\2\2\2\u022d\u022b\3\2\2\2\u022e\u0233\59\35\2\u022f" +
                    "\u0232\59\35\2\u0230\u0232\5\67\34\2\u0231\u022f\3\2\2\2\u0231\u0230\3" +
                    "\2\2\2\u0232\u0235\3\2\2\2\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234" +
                    "\u0236\3\2\2\2\u0235\u0233\3\2\2\2\u0236\u023a\5\u0095K\2\u0237\u0239" +
                    "\5\u0095K\2\u0238\u0237\3\2\2\2\u0239\u023c\3\2\2\2\u023a\u0238\3\2\2" +
                    "\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c\u023a\3\2\2\2\u023d\u0242" +
                    "\59\35\2\u023e\u0241\59\35\2\u023f\u0241\5\67\34\2\u0240\u023e\3\2\2\2" +
                    "\u0240\u023f\3\2\2\2\u0241\u0244\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0243" +
                    "\3\2\2\2\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0245\u0207\3\2\2\2\u0245" +
                    "\u0208\3\2\2\2\u0245\u0210\3\2\2\2\u0245\u021f\3\2\2\2\u0245\u022e\3\2" +
                    "\2\2\u0246\u0098\3\2\2\2\u0247\u024b\7$\2\2\u0248\u024a\n \2\2\u0249\u0248" +
                    "\3\2\2\2\u024a\u024d\3\2\2\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c" +
                    "\u024e\3\2\2\2\u024d\u024b\3\2\2\2\u024e\u0260\7$\2\2\u024f\u0253\7)\2" +
                    "\2\u0250\u0252\n!\2\2\u0251\u0250\3\2\2\2\u0252\u0255\3\2\2\2\u0253\u0251" +
                    "\3\2\2\2\u0253\u0254\3\2\2\2\u0254\u0256\3\2\2\2\u0255\u0253\3\2\2\2\u0256" +
                    "\u0260\7)\2\2\u0257\u025b\7b\2\2\u0258\u025a\n\"\2\2\u0259\u0258\3\2\2" +
                    "\2\u025a\u025d\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025e" +
                    "\3\2\2\2\u025d\u025b\3\2\2\2\u025e\u0260\7b\2\2\u025f\u0247\3\2\2\2\u025f" +
                    "\u024f\3\2\2\2\u025f\u0257\3\2\2\2\u0260\u009a\3\2\2\2.\2\u00d9\u00e4" +
                    "\u00ea\u00f2\u00f8\u00fa\u0100\u0106\u010c\u0112\u0115\u0119\u011e\u0124" +
                    "\u0129\u012f\u0132\u0136\u015c\u0164\u016a\u0172\u0178\u0180\u0205\u020b" +
                    "\u020d\u0213\u0215\u021c\u0223\u0229\u022b\u0231\u0233\u023a\u0240\u0242" +
                    "\u0245\u024b\u0253\u025b\u025f\3\2\3\2";
    public static final ATN    _ATN           =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[]                  _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[]   _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final  Vocabulary VOCABULARY      = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };
    public static String[] modeNames    = { "DEFAULT_MODE" };

    public AtlasDSLLexer(CharStream input) {
        super(input);

        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String[] getRuleNames() {return ruleNames;}

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getSerializedATN() {return _serializedATN;}

    @Override
    public String getGrammarFileName() {return "AtlasDSLLexer.g4";}

    @Override
    public ATN getATN() {return _ATN;}

    @Override
    public String[] getChannelNames() {return channelNames;}

    @Override
    public String[] getModeNames() {return modeNames;}

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    private static String[] makeRuleNames() {
        return new String[] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "DIGIT",
                "LETTER", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "WS", "NUMBER",
                "FLOATING_NUMBER", "BOOL", "K_COMMA", "K_PLUS", "K_MINUS", "K_STAR",
                "K_DIV", "K_DOT", "K_LIKE", "K_AND", "K_OR", "K_LPAREN", "K_LBRACKET",
                "K_RPAREN", "K_RBRACKET", "K_LT", "K_LTE", "K_EQ", "K_NEQ", "K_GT", "K_GTE",
                "K_FROM", "K_WHERE", "K_ORDERBY", "K_GROUPBY", "K_LIMIT", "K_SELECT",
                "K_MAX", "K_MIN", "K_SUM", "K_COUNT", "K_OFFSET", "K_AS", "K_ISA", "K_IS",
                "K_HAS", "K_ASC", "K_DESC", "K_TRUE", "K_FALSE", "K_HASTERM", "KEYWORD",
                "ID", "STRING"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[] {
                null, null, null, null, null, null, null, "','", "'+'", "'-'", "'*'",
                "'/'", "'.'", null, null, null, "'('", "'['", "')'", "']'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[] {
                null, "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "WS", "NUMBER", "FLOATING_NUMBER",
                "BOOL", "K_COMMA", "K_PLUS", "K_MINUS", "K_STAR", "K_DIV", "K_DOT", "K_LIKE",
                "K_AND", "K_OR", "K_LPAREN", "K_LBRACKET", "K_RPAREN", "K_RBRACKET",
                "K_LT", "K_LTE", "K_EQ", "K_NEQ", "K_GT", "K_GTE", "K_FROM", "K_WHERE",
                "K_ORDERBY", "K_GROUPBY", "K_LIMIT", "K_SELECT", "K_MAX", "K_MIN", "K_SUM",
                "K_COUNT", "K_OFFSET", "K_AS", "K_ISA", "K_IS", "K_HAS", "K_ASC", "K_DESC",
                "K_TRUE", "K_FALSE", "K_HASTERM", "KEYWORD", "ID", "STRING"
        };
    }

    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];

        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);

            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];

        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
