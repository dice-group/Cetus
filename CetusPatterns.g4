// Grammar for the CETUS patterns

grammar CetusPatterns;

sentence : WORD* ENTITY (COMMA (WORD|AND|OF|FORM_OF_BE|ADJECTIVE|DETERMINER|NUMBER|NOUN|VERB|FOREIGN|ADVERB)+ COMMA)? type_after_entity_pattern (WORD|POINT|COMMA|COLON)*
| WORD* type_in_front_of_entity ENTITY WORD*;

type_after_entity_pattern : is_a_type_of_pattern
| is_a_pattern
| type_with_dt ;
//| direct_following_type_pattern ;

//direct_following_type_pattern : type_with_dt;
is_a_pattern : COMMA? FORM_OF_BE type_with_dt (((COMMA? AND) | COMMA) type_with_dt)*;
is_a_type_of_pattern : COMMA? FORM_OF_BE type_with_dt OF type_with_dt;

type_in_front_of_entity : type_with_dt (OF|COMMA|COLON)?;

type_with_dt : DETERMINER? nr? type;
type : (ADJECTIVE|VERB|ADVERB)* FOREIGN? NOUN+;
nr : NUMBER;

// Lexer rules

ENTITY : '$ENTITY$';
AND : 'and_and_CC';
OF : 'of_of_IN';
FORM_OF_BE : ~[ \t\r\n]+ '_be_VB' ~[ \t\r\n]?;
ADJECTIVE : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_JJ' [RS]?;
DETERMINER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_DT';
NUMBER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_CD';
NOUN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_NN' ~[ \t\r\n]*;
VERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_VB' ~[ \t\r\n]?;
ADVERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_RB' ~[ \t\r\n]?;
// special latin or greek words, e.g., 'sub'
FOREIGN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_FW'
| ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_FW';

POINT : '._._.';
COMMA : ',_,_,';
COLON : ':_:_:';

WORD : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' ~[ \t\r\n]+;
//OTHER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' [vnjdco] ~[ \t\r\n]*;
WHITESPACE : [ \t\r\n]+ -> skip;