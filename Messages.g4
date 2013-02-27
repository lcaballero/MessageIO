grammar Messages;

@header {
package messageio.parsing;
}

// A file 
file
    : version? message*
    ;

version
    : 'version' Triple
    ;
   
/* A message */
message
    : attributes* 'message' Id '{' setup? property* '}'
    ;

setup
    : 'setup' '{' pair? (',' pair)* ','? '}'
    ;

pair
    : Id '=' constantParam
    ;

constantParam
    : (Int|Id|StringLiteral)
    ;

property
    : attributes* Type Id ';'
    ;

attributes
    : '[' Id ']'
    ;

Triple
    : Int '.' Int '.' Int
    ;
   
Type
    : 'int'
    | 'int?'
    | 'double'
    | 'double?'
    | 'bool'
    | 'bool?'
    | 'DateTime'
    | 'DateTime?'
    | 'DateTimeOffset'
    | 'DateTimeOffset?'
    | 'string'
    ;

StringLiteral
    :   '"' (EscapeSequence | ~[\\\"\r\n])* '"'
    ;

Id : [a-zA-Z_][a-zA-Z0-9_]*
   ;
   
Ws : [ \t\r\n]+ -> skip
   ;

Int
    : [1-9][0-9]*
    | '0'
    | HexPrefix HexDigit+
    ;

fragment
EscapeSequence
    : '\\' EscapeChar
    ;

fragment
EscapeChar
    : [btnfr]
    | '"'
    ;

fragment
HexPrefix
    : '0' [xX]
    ;

fragment
HexDigit
    : [0-9a-fA-F]
    ;

fragment
LongSuffix
    : [lL]
    ;

fragment
NonIntegerNumber
    : [0-9]+ '.' [0-9]* Exponent?
    | '.' [0-9]+ Exponent?
    | [0-9]+ Exponent
    | [0-9]+
    ;

fragment
Exponent
    : [eE][+-]?[0-9]+
    ;
