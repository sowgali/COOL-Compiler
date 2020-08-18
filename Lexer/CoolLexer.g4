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
		if(text.indexOf('\0') != -1)
		{
			reportError("String contains null character");
			return;
		}
		for(int j = 0; j < text.length()-1; j++)
		{
			if(text.charAt(j) == '\\')
			{
				switch(text.charAt(j+1))
				{
					case 'b' 	: myBuff.append('\b');
										 	break;
					case 't' 	: myBuff.append('\t');
										 	break;
					case 'n' 	: myBuff.append('\n');
										 	break;
					case 'f' 	: myBuff.append('\f');
										 	break;
					case '\\' : myBuff.append('\\');
										 	break;
					case '\"' : myBuff.append('\"');
										 	break;
					case '\'' : myBuff.append('\'');
										 	break;
					default  	: myBuff.append(text.charAt(j+1));
										 	break;
				}
				j++;
			}
			else
				myBuff.append(text.charAt(j));
		}
		ouText = myBuff.toString();
		if(ouText.length() > 1024)
			reportError("String constant too long");
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
SELF				: 'self';
SELF_TYPE		: 'SELF_TYPE';
BOOL_CONST	: [t][rR][uU][eE] | [f][aA][lL][sS][eE];
TYPEID			: [A-Z]+[a-zA-Z0-9_]*;
OBJECTID		: [a-z][a-zA-Z0-9_]+;
INT_CONST		: [0-9]+;
STR_CONST 	: '"' -> skip,pushMode(STR_MODE);/

/**All valid lexical symbols of COOL*/
LPAREN			: '{';
RPAREN			: '}';
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
LBRACE			: '(';
RBRACE			: ')';
DOT					: '.';
SEMICOLON   : ';';
DARROW      : '=>';
LE					: '<=';
ASSIGN			: '<-';

// Takes care of whitespaces
WHITESPACE			: [ \n\f\r\t\v]+	-> skip;

// For inline comments
INLINE_COMMENT  : '--' .*? '\n' 	-> skip;

// Goes to cooment mode to check for nesting and errors
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
STR_END			: '"' {processString();} -> popMode;																								// Detects end of string
NL_IN_STR		: '\n' {reportError("Unescaped newline");} -> pushMode(DEFAULT_MODE);								// Reports any unescaped newline
EOF_IN_STR	: .(EOF) {reportError("EOF in string constant");} -> pushMode(DEFAULT_MODE);				// Reports any EOF in string
BODY				: ((~('\n'|[EOF]|'\u0000'|'"'))('\\''\n')?('\\''\"')?)+ -> more//{processString();}
;																																																// Continues fetching tokens if terminating characters are present in strings as members
