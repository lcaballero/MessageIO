grammar Messages;

@header {
package messageio.parsing;
}

io : message*
   ;
   
message
    : 'message' ID '{' inputs? outputs? '}'
    ;

inputs
    : 'inputs' ID '{' property* '}'
    ;

outputs
    : 'outputs' ID '{' property* '}'
    ;
  
property
    : TYPE ID ';'
    ;
   
TYPE
    : 'int'
    | 'int?'
    | 'double'
    | 'double?'
    | 'bool'
    | 'bool?'
    | 'DateTime'
    | 'DateTime?'
    | 'string'
    ;

ID : [a-zA-Z_]+
   ;
   

WS : [ \t\r\n]+ -> skip
   ;
