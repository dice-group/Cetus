// Grammar for the CETUS patterns

grammar CetusPatterns;

sentence : entity_type_part POINT
| type_in_front_of_entity ENTITY; 

entity_type_part: ENTITY COMMA? type_after_entity_pattern COMMA? (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB|FORM_OF_BE|VERB)*
| ENTITY COMMA (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB|VERB)+ COMMA type_after_entity_pattern COMMA? (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB|FORM_OF_BE|VERB)*
| ENTITY cc_word (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB)* type_after_entity_pattern COMMA? (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB|FORM_OF_BE|VERB)*
| ENTITY cc_word (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB)* COMMA (WORD|cc_word|OF|FORM_OF_BE|ADJECTIVE|DETERMINER|NUMBER|NOUN|VERB|FOREIGN|ADVERB)+ COMMA type_after_entity_pattern COMMA? (WORD|cc_word|OF|ADJECTIVE|DETERMINER|NUMBER|NOUN|FOREIGN|ADVERB|FORM_OF_BE|VERB)*;

type_after_entity_pattern : is_a_type_of_type_pattern
| is_a_type_of_both_types_pattern
| is_a_type_of_pattern
| is_a_pattern cc_word is_a_pattern
| is_a_pattern
| type_with_dt;
//| direct_following_type_pattern ;

//direct_following_type_pattern : type_with_dt;
is_a_pattern : FORM_OF_BE ADVERB* type_with_dt (((COMMA AND)|AND|COMMA) type_with_dt)*;
is_a_type_of_pattern : FORM_OF_BE ADVERB* nr? OF type_with_dt;
is_a_type_of_type_pattern : FORM_OF_BE ADVERB* type_with_dt OF type_with_dt;
is_a_type_of_both_types_pattern : FORM_OF_BE ADVERB* type_with_dt OF BOTH type_with_dt AND type_with_dt;

type_in_front_of_entity : type_with_dt (OF|COMMA|COLON)?;

type_with_dt : DETERMINER? nr? type;
type : (ADJECTIVE|VERB|ADVERB)* FOREIGN? NOUN+ (ADJECTIVE NOUN)+
| (ADJECTIVE|VERB|ADVERB)* FOREIGN? NOUN+
| ADJECTIVE;
nr : NUMBER;
cc_word : AND|OR|BOTH|CC;

// Lexer rules

ENTITY : '$ENTITY$';
AND : 'and_and_CC';
OR : 'or_or_CC';
BOTH : 'both_both_CC';
CC : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_CC';
OF : 'of_of_IN';
FORM_OF_BE : ~[ \t\r\n]+ '_be_VB' ~[ \t\r\n]?;
ADJECTIVE : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_JJ' [RS]?;
DETERMINER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_DT';
NUMBER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_CD';
NOUN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_NN' ~[ \t\r\n]*;
VERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_VB' ~[ \t\r\n]?;
ADVERB : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_RB' ~[ \t\r\n]?;
// special latin or greek words, e.g., 'sub'
FOREIGN : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_FW';

POINT : '._._.';
COMMA : ',_,_,';
COLON : ':_:_:';
// brackets and the words between them are removed
BRACKETS : '-LRB-_-lrb-_-LRB-' ~[-]* '-RRB-_-rrb-_-RRB-' -> skip;

WORD : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' ~[ \t\r\n]+;
//OTHER : ~[ \t\r\n]+ '_' ~[ \t\r\n]+ '_' [vnjdco] ~[ \t\r\n]*;
WHITESPACE : [ \t\r\n]+ -> skip;