// Grammar for the CETUS patterns

grammar CetusPatterns;

sentence : WORD* ENTITY (COMMA (WORD|AND|OF|FORM_OF_BE|ADJECTIVE|DETERMINER|NUMBER|CARDINAL_NUMBER|NOUN|VERB|FOREIGN|ADVERB)+ COMMA)? type_after_entity_pattern (WORD|POINT|COMMA|COLON)*
| WORD* type_in_front_of_entity ENTITY WORD*;

type_after_entity_pattern : is_a_type_of_pattern
| is_a_pattern
| direct_following_type_pattern ;

direct_following_type_pattern : type_with_dt;
is_a_pattern : FORM_OF_BE type_with_dt (((COMMA? AND) | COMMA) type_with_dt)*;
is_a_type_of_pattern : FORM_OF_BE type_with_dt OF type_with_dt;

type_in_front_of_entity : type_with_dt (OF|COMMA|COLON)?;

type_with_dt : DETERMINER? nr_or_crd? type;
type : (ADJECTIVE|VERB|ADVERB)* FOREIGN? NOUN+;
nr_or_crd : NUMBER | CARDINAL_NUMBER;

// Lexer rules

ENTITY : '$ENTITY$';
AND : 'and_and_cc';
OF : 'of_of_pp-f';
FORM_OF_BE : ~[ \t\r\n]+ '_be_v' ~[ \t\r\n]*;
ADJECTIVE : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_j' ~[ \t\r\n]*;
DETERMINER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_d' ~[ \t\r\n]*;
NUMBER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_crd';
CARDINAL_NUMBER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_ord';
NOUN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_n' ~[ \t\r\n]*;
VERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_v' ~[ \t\r\n]*;
ADVERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_av' ~[ \t\r\n]*;
// special latin or greek words, e.g., 'sub'
FOREIGN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_fw-la'
| ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_fw-gr';

POINT : '._._.';
COMMA : ',_,_,';
COLON : ':_:_:';

WORD : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' ~[ \t\r\n]+;
//OTHER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' [vnjdco] ~[ \t\r\n]*;
WHITESPACE : [ \t\r\n]+ -> skip;