grammar Messages;

@header {
package messageio.parsing;
}

io : message*
   ;
   
message : 'message' ID '{' property* '}'
   ;
   
property : TYPE ID ';'
   ;
   
TYPE : 'int'
   | 'double'
   | 'string'
   ;

ID : [a-zA-Z_]+
   ;
   

WS : [ \t\r\n]+ -> skip
   ;
