// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WHITESPACE=43, INLINE_COMMENT=44, 
		COMMENT=45, FILEND_COMMENT=46, END_COMMENT=47, EVERYOTHERTHING=48, END_ERROR=49, 
		NESTING=50, BYE_V1=51, JUST_GO_V1=52, END_ERROR_1=53, NEW_ERROR=54, R_NESTING=55, 
		BYE_V2=56, JUST_GO_V2=57, BODY=58;
	public static final int NEST_COMMENT = 1;
	public static final int RECURSE = 2;
	public static final int STR_MODE = 3;
	public static String[] modeNames = {
		"DEFAULT_MODE", "NEST_COMMENT", "RECURSE", "STR_MODE"
	};

	public static final String[] ruleNames = {
		"SEMICOLON", "DARROW", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", 
		"LET", "LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "BOOL_CONST", "TYPEID", "OBJECTID", "INT_CONST", "STR_CONST", "LPAREN", 
		"RPAREN", "COLON", "ATSYM", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", 
		"TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "LE", "ASSIGN", "WHITESPACE", 
		"INLINE_COMMENT", "COMMENT", "FILEND_COMMENT", "END_COMMENT", "EVERYOTHERTHING", 
		"END_ERROR", "NESTING", "BYE_V1", "JUST_GO_V1", "END_ERROR_1", "NEW_ERROR", 
		"R_NESTING", "BYE_V2", "JUST_GO_V2", "BODY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'\"'", "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WHITESPACE", "INLINE_COMMENT", "COMMENT", "FILEND_COMMENT", "END_COMMENT", 
		"EVERYOTHERTHING", "END_ERROR", "NESTING", "BYE_V1", "JUST_GO_V1", "END_ERROR_1", 
		"NEW_ERROR", "R_NESTING", "BYE_V2", "JUST_GO_V2", "BODY"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){
			setText(errorString);
			setType(ERROR);
		}

		/** Routine that processes any other token than
			*	those specified by COOL */
		public void processOthers(){
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			setText(text);
			setType(ERROR);
		}

		/** Routine to process strings*/
		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();

			//write your code to test strings here
			StringBuilder myBuff = new StringBuilder(0);
			String ouText;
			int i = 0;
			boolean unesc_nl = false;
			boolean null_str = false;
			boolean esc_null = false;
			boolean eof = false;
			boolean backslash = false;
			boolean flag = true;
			boolean max_len = false;
			/*if(text.length()==1)
				eof = true;*/
			/*else*/ if(text.charAt(text.length()-1) != '\"')
			{
				switch(text.charAt(text.length()-1))
				{
					case '\n' : unesc_nl = true;
											break;
					case '\\' : backslash = true;
											break;
					default		: eof = true;
											break;
				}
			}
			//else ;
			for(int j = 0; flag&&(i<=1025)&&(j < text.length()-1); j++)
			{
				if(text.charAt(j)=='\\')
				{
					switch(text.charAt(j+1))
					{
						case 'b' 	: myBuff.append('\b');
											 	break;
						case 't' 	: myBuff.append('\t');
											 	break;
						case 'n' 	: myBuff.append('\n');
												if(j+2 == text.length())
													eof = true;
											 	break;
						case '\n'	: myBuff.append('\n');
												if(j+2 == text.length())
												{
													eof = true;
													if(unesc_nl)
														unesc_nl = false;
												}
												break;
						case 'f' 	: myBuff.append('\f');
											 	break;
						case '\\' : myBuff.append('\\');
												if(j+2 == text.length())
												{
													eof = true;
													if(backslash)
														backslash = false;
												}
											 	break;
						case '\"' : myBuff.append('\"');
												if(j+2 == text.length())
													eof = true;
											 	break;
						case '\'' : myBuff.append('\'');
											 	break;
						case '\u0000'	: esc_null = true;
														flag = false;
														break;
						default  	: myBuff.append(text.charAt(j+1));
											 	break;
					}
					j++;
				}
				else
				{
					switch(text.charAt(j))
					{
						case '\u0000'	: null_str = true;
														flag = false;
														break;
						default				: myBuff.append(text.charAt(j));
														break;
					}
				}
				i++;
				if(i>1024)
					max_len = true;
			}

			ouText = myBuff.toString();
			if(null_str)
				reportError("String contains null character");
			else if(esc_null)
				reportError("String contains escaped null character");
			else if(i<1026 && backslash)
				reportError("backslash at the end of file");
			else if(i<1026 && unesc_nl)
				reportError("Unterminated string constant");
			else if(max_len)
				reportError("String constant too long");
			else if(eof)
				reportError("EOF in string constant");
			else
			{
				setText(ouText);
				setType(STR_CONST);
			}
			return;
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44:
			FILEND_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			END_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			EVERYOTHERTHING_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			END_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			END_ERROR_1_action((RuleContext)_localctx, actionIndex);
			break;
		case 52:
			NEW_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 56:
			BODY_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void FILEND_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			reportError("Unmatched *)");
			break;
		}
	}
	private void END_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError("Unmatched *)");
			break;
		}
	}
	private void EVERYOTHERTHING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			processOthers();
			break;
		}
	}
	private void END_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			reportError("EOF in comment");
			break;
		}
	}
	private void END_ERROR_1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			reportError("EOF in comment");
			break;
		}
	}
	private void NEW_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			reportError("EOF in comment");
			break;
		}
	}
	private void BODY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			processString();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u018a\b\1\b\1\b"+
		"\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t"+
		"\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\5\25\u00d9\n\25\3\26\3\26\7\26\u00dd\n\26\f\26\16\26\u00e0\13"+
		"\26\3\27\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7\13\27\3\30\6\30\u00ea\n"+
		"\30\r\30\16\30\u00eb\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\3+\6+\u0118\n+\r+\16+\u0119"+
		"\3+\3+\3,\3,\3,\3,\7,\u0122\n,\f,\16,\u0125\13,\3,\5,\u0128\n,\3,\3,\3"+
		"-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\3:\3"+
		":\3:\5:\u0171\n:\3:\3:\5:\u0175\n:\3:\3:\5:\u0179\n:\7:\u017b\n:\f:\16"+
		":\u017e\13:\3:\3:\5:\u0182\n:\3:\5:\u0185\n:\3:\3:\3:\3:\3\u0123\2;\6"+
		"\r\b\31\n\34\f\35\16\36\20\37\22 \24!\26\"\30#\32$\34%\36& \'\"($)&*("+
		"+*,,\6.\4\60\5\62\7\64\b\66\t8\n:\13<\f>\16@\17B\20D\21F\22H\23J\24L\25"+
		"N\26P\27R\30T\32V\33X-Z.\\/^\60`\61b\62d\63f\64h\65j\66l\67n8p9r:t;v<"+
		"\6\2\3\4\5\36\4\2EEee\4\2NNnn\4\2CCcc\4\2UUuu\4\2GGgg\4\2HHhh\4\2KKkk"+
		"\4\2PPpp\4\2JJjj\4\2TTtt\4\2VVvv\4\2QQqq\4\2RRrr\4\2YYyy\4\2XXxx\4\2F"+
		"Fff\3\2vv\4\2WWww\3\2hh\3\2C\\\6\2\62;C\\aac|\3\2c|\3\2\62;\7\2\13\f\16"+
		"\17\"\"^^xx\3\2\f\f\3\3\f\f\5\2\f\f$$^^\4\2\f\f$$\u0192\2\6\3\2\2\2\2"+
		"\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2"+
		"\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2"+
		"\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2"+
		"\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2"+
		"\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2"+
		"\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N"+
		"\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3\2\2\2\2Z\3\2"+
		"\2\2\2\\\3\2\2\2\2^\3\2\2\2\2`\3\2\2\2\2b\3\2\2\2\3d\3\2\2\2\3f\3\2\2"+
		"\2\3h\3\2\2\2\3j\3\2\2\2\4l\3\2\2\2\4n\3\2\2\2\4p\3\2\2\2\4r\3\2\2\2\4"+
		"t\3\2\2\2\5v\3\2\2\2\6x\3\2\2\2\bz\3\2\2\2\n}\3\2\2\2\f\u0083\3\2\2\2"+
		"\16\u0088\3\2\2\2\20\u008b\3\2\2\2\22\u008e\3\2\2\2\24\u0091\3\2\2\2\26"+
		"\u009a\3\2\2\2\30\u009e\3\2\2\2\32\u00a3\3\2\2\2\34\u00a8\3\2\2\2\36\u00ad"+
		"\3\2\2\2 \u00b3\3\2\2\2\"\u00b8\3\2\2\2$\u00bd\3\2\2\2&\u00c0\3\2\2\2"+
		"(\u00c4\3\2\2\2*\u00cb\3\2\2\2,\u00d8\3\2\2\2.\u00da\3\2\2\2\60\u00e1"+
		"\3\2\2\2\62\u00e9\3\2\2\2\64\u00ed\3\2\2\2\66\u00f2\3\2\2\28\u00f4\3\2"+
		"\2\2:\u00f6\3\2\2\2<\u00f8\3\2\2\2>\u00fa\3\2\2\2@\u00fc\3\2\2\2B\u00fe"+
		"\3\2\2\2D\u0100\3\2\2\2F\u0102\3\2\2\2H\u0104\3\2\2\2J\u0106\3\2\2\2L"+
		"\u0108\3\2\2\2N\u010a\3\2\2\2P\u010c\3\2\2\2R\u010e\3\2\2\2T\u0110\3\2"+
		"\2\2V\u0113\3\2\2\2X\u0117\3\2\2\2Z\u011d\3\2\2\2\\\u012b\3\2\2\2^\u0131"+
		"\3\2\2\2`\u0137\3\2\2\2b\u013c\3\2\2\2d\u013f\3\2\2\2f\u0143\3\2\2\2h"+
		"\u0149\3\2\2\2j\u014f\3\2\2\2l\u0153\3\2\2\2n\u0157\3\2\2\2p\u015d\3\2"+
		"\2\2r\u0163\3\2\2\2t\u0169\3\2\2\2v\u017c\3\2\2\2xy\7=\2\2y\7\3\2\2\2"+
		"z{\7?\2\2{|\7@\2\2|\t\3\2\2\2}~\t\2\2\2~\177\t\3\2\2\177\u0080\t\4\2\2"+
		"\u0080\u0081\t\5\2\2\u0081\u0082\t\5\2\2\u0082\13\3\2\2\2\u0083\u0084"+
		"\t\6\2\2\u0084\u0085\t\3\2\2\u0085\u0086\t\5\2\2\u0086\u0087\t\6\2\2\u0087"+
		"\r\3\2\2\2\u0088\u0089\t\7\2\2\u0089\u008a\t\b\2\2\u008a\17\3\2\2\2\u008b"+
		"\u008c\t\b\2\2\u008c\u008d\t\7\2\2\u008d\21\3\2\2\2\u008e\u008f\t\b\2"+
		"\2\u008f\u0090\t\t\2\2\u0090\23\3\2\2\2\u0091\u0092\t\b\2\2\u0092\u0093"+
		"\t\t\2\2\u0093\u0094\t\n\2\2\u0094\u0095\t\6\2\2\u0095\u0096\t\13\2\2"+
		"\u0096\u0097\t\b\2\2\u0097\u0098\t\f\2\2\u0098\u0099\t\5\2\2\u0099\25"+
		"\3\2\2\2\u009a\u009b\t\3\2\2\u009b\u009c\t\6\2\2\u009c\u009d\t\f\2\2\u009d"+
		"\27\3\2\2\2\u009e\u009f\t\3\2\2\u009f\u00a0\t\r\2\2\u00a0\u00a1\t\r\2"+
		"\2\u00a1\u00a2\t\16\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\t\16\2\2\u00a4\u00a5"+
		"\t\r\2\2\u00a5\u00a6\t\r\2\2\u00a6\u00a7\t\3\2\2\u00a7\33\3\2\2\2\u00a8"+
		"\u00a9\t\f\2\2\u00a9\u00aa\t\n\2\2\u00aa\u00ab\t\6\2\2\u00ab\u00ac\t\t"+
		"\2\2\u00ac\35\3\2\2\2\u00ad\u00ae\t\17\2\2\u00ae\u00af\t\n\2\2\u00af\u00b0"+
		"\t\b\2\2\u00b0\u00b1\t\3\2\2\u00b1\u00b2\t\6\2\2\u00b2\37\3\2\2\2\u00b3"+
		"\u00b4\t\2\2\2\u00b4\u00b5\t\4\2\2\u00b5\u00b6\t\5\2\2\u00b6\u00b7\t\6"+
		"\2\2\u00b7!\3\2\2\2\u00b8\u00b9\t\6\2\2\u00b9\u00ba\t\5\2\2\u00ba\u00bb"+
		"\t\4\2\2\u00bb\u00bc\t\2\2\2\u00bc#\3\2\2\2\u00bd\u00be\t\r\2\2\u00be"+
		"\u00bf\t\7\2\2\u00bf%\3\2\2\2\u00c0\u00c1\t\t\2\2\u00c1\u00c2\t\6\2\2"+
		"\u00c2\u00c3\t\17\2\2\u00c3\'\3\2\2\2\u00c4\u00c5\t\b\2\2\u00c5\u00c6"+
		"\t\5\2\2\u00c6\u00c7\t\20\2\2\u00c7\u00c8\t\r\2\2\u00c8\u00c9\t\b\2\2"+
		"\u00c9\u00ca\t\21\2\2\u00ca)\3\2\2\2\u00cb\u00cc\t\t\2\2\u00cc\u00cd\t"+
		"\r\2\2\u00cd\u00ce\t\f\2\2\u00ce+\3\2\2\2\u00cf\u00d0\t\22\2\2\u00d0\u00d1"+
		"\t\13\2\2\u00d1\u00d2\t\23\2\2\u00d2\u00d9\t\6\2\2\u00d3\u00d4\t\24\2"+
		"\2\u00d4\u00d5\t\4\2\2\u00d5\u00d6\t\3\2\2\u00d6\u00d7\t\5\2\2\u00d7\u00d9"+
		"\t\6\2\2\u00d8\u00cf\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d9-\3\2\2\2\u00da"+
		"\u00de\t\25\2\2\u00db\u00dd\t\26\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3"+
		"\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df/\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00e5\t\27\2\2\u00e2\u00e4\t\26\2\2\u00e3\u00e2\3\2\2\2"+
		"\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\61"+
		"\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00ea\t\30\2\2\u00e9\u00e8\3\2\2\2"+
		"\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\63"+
		"\3\2\2\2\u00ed\u00ee\7$\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\31\2\2\u00f0"+
		"\u00f1\b\31\3\2\u00f1\65\3\2\2\2\u00f2\u00f3\7*\2\2\u00f3\67\3\2\2\2\u00f4"+
		"\u00f5\7+\2\2\u00f59\3\2\2\2\u00f6\u00f7\7<\2\2\u00f7;\3\2\2\2\u00f8\u00f9"+
		"\7B\2\2\u00f9=\3\2\2\2\u00fa\u00fb\7.\2\2\u00fb?\3\2\2\2\u00fc\u00fd\7"+
		"-\2\2\u00fdA\3\2\2\2\u00fe\u00ff\7/\2\2\u00ffC\3\2\2\2\u0100\u0101\7,"+
		"\2\2\u0101E\3\2\2\2\u0102\u0103\7\61\2\2\u0103G\3\2\2\2\u0104\u0105\7"+
		"\u0080\2\2\u0105I\3\2\2\2\u0106\u0107\7>\2\2\u0107K\3\2\2\2\u0108\u0109"+
		"\7?\2\2\u0109M\3\2\2\2\u010a\u010b\7}\2\2\u010bO\3\2\2\2\u010c\u010d\7"+
		"\177\2\2\u010dQ\3\2\2\2\u010e\u010f\7\60\2\2\u010fS\3\2\2\2\u0110\u0111"+
		"\7>\2\2\u0111\u0112\7?\2\2\u0112U\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115"+
		"\7/\2\2\u0115W\3\2\2\2\u0116\u0118\t\31\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u011c\b+\2\2\u011cY\3\2\2\2\u011d\u011e\7/\2\2\u011e\u011f"+
		"\7/\2\2\u011f\u0123\3\2\2\2\u0120\u0122\n\32\2\2\u0121\u0120\3\2\2\2\u0122"+
		"\u0125\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0127\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0126\u0128\t\33\2\2\u0127\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\b,\2\2\u012a[\3\2\2\2\u012b\u012c\7*\2\2\u012c"+
		"\u012d\7,\2\2\u012d\u012e\3\2\2\2\u012e\u012f\b-\4\2\u012f\u0130\b-\2"+
		"\2\u0130]\3\2\2\2\u0131\u0132\7,\2\2\u0132\u0133\7+\2\2\u0133\u0134\3"+
		"\2\2\2\u0134\u0135\7\2\2\3\u0135\u0136\b.\5\2\u0136_\3\2\2\2\u0137\u0138"+
		"\7,\2\2\u0138\u0139\7+\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b/\6\2\u013b"+
		"a\3\2\2\2\u013c\u013d\13\2\2\2\u013d\u013e\b\60\7\2\u013ec\3\2\2\2\u013f"+
		"\u0140\13\2\2\2\u0140\u0141\7\2\2\3\u0141\u0142\b\61\b\2\u0142e\3\2\2"+
		"\2\u0143\u0144\7*\2\2\u0144\u0145\7,\2\2\u0145\u0146\3\2\2\2\u0146\u0147"+
		"\b\62\t\2\u0147\u0148\b\62\2\2\u0148g\3\2\2\2\u0149\u014a\7,\2\2\u014a"+
		"\u014b\7+\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b\63\n\2\u014d\u014e\b\63"+
		"\2\2\u014ei\3\2\2\2\u014f\u0150\13\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152"+
		"\b\64\2\2\u0152k\3\2\2\2\u0153\u0154\13\2\2\2\u0154\u0155\7\2\2\3\u0155"+
		"\u0156\b\65\13\2\u0156m\3\2\2\2\u0157\u0158\7,\2\2\u0158\u0159\7+\2\2"+
		"\u0159\u015a\3\2\2\2\u015a\u015b\7\2\2\3\u015b\u015c\b\66\f\2\u015co\3"+
		"\2\2\2\u015d\u015e\7*\2\2\u015e\u015f\7,\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u0161\b\67\t\2\u0161\u0162\b\67\2\2\u0162q\3\2\2\2\u0163\u0164\7,\2\2"+
		"\u0164\u0165\7+\2\2\u0165\u0166\3\2\2\2\u0166\u0167\b8\n\2\u0167\u0168"+
		"\b8\2\2\u0168s\3\2\2\2\u0169\u016a\13\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u016c\b9\2\2\u016cu\3\2\2\2\u016d\u0171\n\34\2\2\u016e\u016f\7^\2\2\u016f"+
		"\u0171\13\2\2\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0174\3"+
		"\2\2\2\u0172\u0173\7^\2\2\u0173\u0175\7\f\2\2\u0174\u0172\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0177\7^\2\2\u0177\u0179\7$\2"+
		"\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0170"+
		"\3\2\2\2\u017b\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d"+
		"\u0184\3\2\2\2\u017e\u017c\3\2\2\2\u017f\u0185\t\35\2\2\u0180\u0182\7"+
		"^\2\2\u0181\u0180\3\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183"+
		"\u0185\7\2\2\3\u0184\u017f\3\2\2\2\u0184\u0181\3\2\2\2\u0185\u0186\3\2"+
		"\2\2\u0186\u0187\b:\r\2\u0187\u0188\3\2\2\2\u0188\u0189\b:\n\2\u0189w"+
		"\3\2\2\2\23\2\3\4\5\u00d8\u00de\u00e5\u00eb\u0119\u0123\u0127\u0170\u0174"+
		"\u0178\u017c\u0181\u0184\16\b\2\2\7\5\2\7\3\2\3.\2\3/\3\3\60\4\3\61\5"+
		"\7\4\2\6\2\2\3\65\6\3\66\7\3:\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}