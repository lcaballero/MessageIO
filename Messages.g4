grammar Messages;

@header {
package messageio.parsing;
}

// A file 
file
    : version? service
    ;

version
    : 'version' Triple
    ;
   
/* A message */
service
    : 'service' Id '{' setup? inputs? outputs? '}'
    ;

inputs
    : 'inputs' Id '{' setup? property* '}'
    ;

outputs
    : 'outputs' Id '{' setup? property* '}'
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
    : attributes? Type Id ';'
    ;

attributes
    : '[' Id (',' Id)* ','? ']'
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
    :   '0'
    |   [1-9][0-9]*
    |   '0' [0-7]+
    |   HexPrefix HexDigit+
    ;

fragment
EscapeSequence
    :   '\\' EscapeChar
    ;

fragment
EscapeChar
    : [btnfr]
    | '"'
    ;

fragment
HexPrefix
    :   '0x' | '0X'
    ;

fragment
HexDigit
    :   ('0'..'9'|'a'..'f'|'A'..'F')
    ;

fragment
LongSuffix
    :   'l' | 'L'
    ;

fragment
NonIntegerNumber
    :   ('0' .. '9')+ '.' ('0' .. '9')* Exponent?
    |   '.' ( '0' .. '9' )+ Exponent?
    |   ('0' .. '9')+ Exponent
    |   ('0' .. '9')+
    |
        HexPrefix (HexDigit )*
        (    ()
        |    ('.' (HexDigit )* )
        )
        ( 'p' | 'P' )
        ( '+' | '-' )?
        ( '0' .. '9' )+
        ;

fragment
Exponent
    :   [eE][+-]?[0-9]+
    ;
