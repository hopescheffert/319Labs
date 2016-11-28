lexer grammar xmltokenizer;
//element names must start with a letter or underscore
//element names cannot start with letters XML or xml, etc
fragment OKSTART: [a-zA-Z_]['XML' | 'xml' | 'Xml' | 'XMl' | 'XmL' | 'xML'] ;
//element names can contain letters, digits, hyphens, underscores or periods
//cannot contain spaces
fragment OKNAME: [a-zA-z0-9-_.][^ ] ;

fragment ELEMENTNAME: ^OKSTART+ OKNAME+;

WS: [ \r\n\t]+ {skip();} ;
