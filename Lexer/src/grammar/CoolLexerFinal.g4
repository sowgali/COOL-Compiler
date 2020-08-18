lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

/* Author : Sowrya Gali - CS18BTECH11012*/

@members{

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

		// Flags to keep track of errors
		boolean unesc_nl = false;
		boolean null_str = false;
		boolean esc_null = false;
		boolean eof = false;
		boolean backslash = false;
		boolean flag = true;
		boolean max_len = false;

		// Checking string end to set flags
		if(text.charAt(text.length()-1) != '\"')
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
		// Loop to process string contents
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
												// If newline is found at it is actually escaped
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
												// If backslash is found it is actually escaped
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
					case '\u0000'	: esc_null = true; // Escaped null character is found in string
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
					case '\u0000'	: null_str = true; // Null charactr is found in the string
													flag = false;
													break;
					default				: myBuff.append(text.charAt(j));
													break;
				}
			}
			i++;
			if(i>1024)
				max_len = true; // If string exceeds maximum length
		}
		// The final string is copied to ouText
		ouText = myBuff.toString();

		//Reporting errors as per coolc precedence
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
		// If error is encountered
		else
		{
			setText(ouText);
			setType(STR_CONST);
		}
		return;
	}
}

/*
	WRITE ALL LEXER RULES BELOW
*/

/** Keywords of cool language
 *  They are case-insensitive*/
SEMICOLON   : ';';
DARROW      : '=>';
CLASS				: [cC][lL][aA][sS][sS];
ELSE				: [eE][lL][sS][eE];
FI					: [fF][iI];
IF					: [iI][fF];
IN					: [iI][nN];
INHERITS		: [iI][nN][hH][eE][rR][iI][tT][sS];
LET					:	[lL][eE][tT];
LOOP				:	[lL][oO][oO][pP];
POOL				: [pP][oO][oO][lL];
THEN				: [tT][hH][eE][nN];
WHILE				: [wW][hH][iI][lL][eE];
CASE				: [cC][aA][sS][eE];
ESAC				: [eE][sS][aA][cC];
OF					: [oO][fF];
NEW					: [nN][eE][wW];
ISVOID			: [iI][sS][vV][oO][iI][dD];
NOT					: [nN][oO][tT];


/** Basic constants and some special names*/
//fragment SELF				: [s][e][l][f];
//fragment SELF_TYPE	: [S][E][L][F][_][T][Y][P][E];
BOOL_CONST	: [t][rR][uU][eE] | [f][aA][lL][sS][eE];
TYPEID			: [A-Z][a-zA-Z0-9_]*;
OBJECTID		: [a-z][a-zA-Z0-9_]*;
INT_CONST		: [0-9]+;
STR_CONST 	: '"' -> skip,pushMode(STR_MODE);

/**All valid lexical symbols of COOL*/
LPAREN			: '(';
RPAREN			: ')';
COLON				: ':';
ATSYM				:	'@';
COMMA				: ',';
PLUS				: '+';
MINUS				: '-';
STAR				: '*';
SLASH				: '/';
TILDE				: '~';
LT					: '<';
EQUALS			: '=';
LBRACE			: '{';
RBRACE			: '}';
DOT					: '.';
LE					: '<=';
ASSIGN			: '<-';

// Takes care of whitespaces
WHITESPACE			: [ \n\f\r\t\v]+	-> skip;

// For inline comments
INLINE_COMMENT  : '--' (~('\n'))*? ('\n' | EOF) 	-> skip;

// Goes to comment mode to check for nesting and errors
COMMENT					: '(*' -> pushMode(NEST_COMMENT), skip;
FILEND_COMMENT  : '*)' EOF  {reportError("Unmatched *)");};
END_COMMENT		  : '*)'			{reportError("Unmatched *)");};

// Reports any other tokens that breaks the lexical rules of COOL
EVERYOTHERTHING	: .	{processOthers();};

// Checks for errors and initializes recursion, in case of nesting
mode NEST_COMMENT;
END_ERROR		: .(EOF) {reportError("EOF in comment");};													// Reports of any EOF in comments
NESTING			: '(*'  -> pushMode(RECURSE) , skip;																// Initiates Recursive NESTING
BYE_V1			:  '*)' -> popMode , skip;																					// Terminates comment mode
JUST_GO_V1	: .			-> skip;																										// Ignores content of comments

// The recursive routine and sanity checks
mode RECURSE;
END_ERROR_1	: .(EOF) {reportError("EOF in comment");};													// Reports of any EOF in comments
NEW_ERROR		: '*)' EOF {reportError("EOF in comment");};												// Reports of any EOF in comments
R_NESTING		: '(*'  -> pushMode(RECURSE) , skip;																// Maintains recursion
BYE_V2			:  '*)' -> popMode , skip;																					// Terminate from recursion
JUST_GO_V2	: .			-> skip;																										// Ignores content of comments

// Processes string constants
mode STR_MODE;
BODY				: (((~('\n'|'"'|'\\'))|'\\'(.)) ('\\''\n')?('\\''\"')?)* ('\n'|'"'|('\\'? EOF)) {processString();} -> popMode;
