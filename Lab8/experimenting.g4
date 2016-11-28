//element names must start with a letter or underscore
//element names cannot start with letters XML or xml, etc
//ELEMENTSTART: [a-zA-Z_]+ [^(XML | xmL | Xml | XMl | XmL | xML | xMl)]
//{
//    System.out.println("found ELEMENTSTART " + getText());
//};

//element names can contain letters, digits, hyphens, underscores or periods
//element names cannot contain spaces?
//names cannot contain spaces?
//fragment ENAMERULES: [a-zA-z0-9-_.][^ ];
//ELEMENTNAME: ENAMERULES+
//{
//    System.out.println("found ELEMENTNAME " + getText());
//};

//element in between "<" ">"
//ELEMENT: '<' ELEMENTSTART+ ELEMENTNAME+  '>'
//{
//    System.out.println("found element : " + getText());
//};

//skip whitespace?
//WS: [ \r\n\t]+ {skip();} ;
