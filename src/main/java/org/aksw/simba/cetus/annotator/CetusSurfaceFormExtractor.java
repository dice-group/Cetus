package org.aksw.simba.cetus.annotator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;
import org.aksw.simba.cetus.parser.TypeExtractor;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hp.hpl.jena.vocabulary.RDFS;

import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetBeginAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.CharacterOffsetEndAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class CetusSurfaceFormExtractor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CetusSurfaceFormExtractor.class);

    public static final String BASE_URI = "http://cetus.aksw.org/cetus#";

    // public CetusSurfaceFormExtractor(PosTagger tagger, TypeExtractor
    // extractor) {
    // preprocessor = new SingleDocumentPreprocessor();
    // // remove quotes
    // DocumentSupplier supplier = new
    // QuotesRemovingSupplierDecorator(preprocessor);
    // // remove brackets
    // supplier = new BracketsRemovingSupplierDecorator(supplier);
    // // TODO replace pronouns
    // // PronounReplacingSupplierDecorator
    //
    // // With the current implementation of the sentence splitter, pos
    // tagger
    // // and named entities, it is much easier to pos tag before splitting.
    // // Even if this does not make that much sense.
    // // POS tagging
    // supplier = new NerPropagatingSupplierDecorator(supplier,
    // PosTaggerFactory.getPosTaggingStep(Language.ENG));
    // // // split sentences
    // // supplier = new SentenceBasedDocumentTextSplitter(supplier,
    // // SentenceSplitterFactory.createSentenceSplitter(Language.ENG));
    // }

    private static final String STANFORD_NLP_PROPERTIES_FILE = "stanfordNLP.properties";

    public static CetusSurfaceFormExtractor create() {
        Properties props = new Properties();
        InputStream is;
        is = CetusSurfaceFormExtractor.class.getClassLoader().getResourceAsStream(STANFORD_NLP_PROPERTIES_FILE);
        if (is == null) {
            LOGGER.error("Couldn't load stanford properties file (\"" + STANFORD_NLP_PROPERTIES_FILE
                    + "\") from class path. Returning null.");
            return null;
        }
        try {
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("Couldn't load stanford properties file. Returning null.", e);
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
        return new CetusSurfaceFormExtractor(new StanfordCoreNLP(props));
    }

    private StanfordCoreNLP pipeline;
    private TypeExtractor extractor = new TypeExtractor();

    protected CetusSurfaceFormExtractor(StanfordCoreNLP pipeline) {
        this.pipeline = pipeline;
    }

    /**
     * 
     * 
     * @param document
     * @return
     */
    public synchronized Map<NamedEntity, List<ExtendedTypedNamedEntity>> extractTypeSurfaceForms(Document nifDocument) {
        // Document tmDocument = createDocument(nifDocument);
        // tmDocument = preprocessor.processDocument(tmDocument);
        // return tmDocument.getProperty(TypeSurfaceForms.class).get();
        Annotation document = new Annotation(nifDocument.getText());
        preprocessDocument(document);
        return getTypeSurfaceForms(document, nifDocument.getMarkings(NamedEntity.class));
    }

    private void preprocessDocument(Annotation document) {
        pipeline.annotate(document);
    }

    private Map<NamedEntity, List<ExtendedTypedNamedEntity>> getTypeSurfaceForms(Annotation document,
            List<NamedEntity> list) {
        Map<NamedEntity, List<ExtendedTypedNamedEntity>> results = new HashMap<NamedEntity, List<ExtendedTypedNamedEntity>>();
        for (NamedEntity ne : list) {
            results.put(ne, getTypeSurfaceForms(document, ne));
        }
        return results;
    }

    private List<ExtendedTypedNamedEntity> getTypeSurfaceForms(Annotation document, NamedEntity ne) {
        // FIXME here, we should try to replace pronouns with their meaning
        List<ExtendedTypedNamedEntity> results = new ArrayList<ExtendedTypedNamedEntity>();
        // call for the ne and every pronoun
        getTypeSurfaceForms(document, ne.getStartPosition(), ne.getStartPosition() + ne.getLength(), results);
        return results;
    }

    private static final int ORIG_TEXT_START = 0;
    private static final int ORIG_TEXT_END = 1;
    private static final int GEN_TEXT_START = 2;
    private static final int GEN_TEXT_END = 3;

    private void getTypeSurfaceForms(Annotation document, int neStartPos, int neEndPos,
            List<ExtendedTypedNamedEntity> results) {
        boolean entityFound = false;
        StringBuilder parseableTextBuilder = new StringBuilder();
        List<CoreLabel> tokens = document.get(TokensAnnotation.class);
        int tokenPositions[][] = new int[tokens.size()][4];
        int id = 0;
        for (CoreLabel token : tokens) {
            tokenPositions[id][ORIG_TEXT_START] = token.get(CharacterOffsetBeginAnnotation.class);
            tokenPositions[id][ORIG_TEXT_END] = token.get(CharacterOffsetEndAnnotation.class);
            if ((tokenPositions[id][ORIG_TEXT_END] <= neStartPos) || (tokenPositions[id][ORIG_TEXT_START] >= neEndPos)) {
                if (parseableTextBuilder.length() > 0) {
                    parseableTextBuilder.append(' ');
                }
                tokenPositions[id][GEN_TEXT_START] = parseableTextBuilder.length();
                parseableTextBuilder.append(token.getString(TextAnnotation.class));
                parseableTextBuilder.append('_');
                parseableTextBuilder.append(token.getString(LemmaAnnotation.class));
                parseableTextBuilder.append('_');
                parseableTextBuilder.append(token.getString(PartOfSpeechAnnotation.class));
                tokenPositions[id][GEN_TEXT_END] = parseableTextBuilder.length();
            } else {
                if (!entityFound) {
                    if (parseableTextBuilder.length() > 0) {
                        parseableTextBuilder.append(' ');
                    }
                    tokenPositions[id][GEN_TEXT_START] = parseableTextBuilder.length();
                    parseableTextBuilder.append(TypeExtractor.ENTITY_MARKING);
                    entityFound = true;
                } else {
                    tokenPositions[id][GEN_TEXT_START] = parseableTextBuilder.length();
                }
                tokenPositions[id][GEN_TEXT_END] = parseableTextBuilder.length();
            }
            ++id;
        }
        if (!entityFound) {
            LOGGER.error("Couldn't find the named entity (" + neStartPos + ", " + neEndPos + ") inside the document \""
                    + document.toString() + "\".");
            return;
        }
        String parseableText = parseableTextBuilder.toString();
        List<String> types = extractor.extractTypeStrings(parseableText);
        if (types != null) {
            if(LOGGER.isInfoEnabled()) {
                LOGGER.info("Found types " + Arrays.toString(types.toArray()) + " inside the sentence \"" + parseableText + "\".");
            }
            generateNEsForTypes(document.get(TokensAnnotation.class), tokenPositions, parseableText, types, results);
        } else {
            LOGGER.warn("Extractor was not able to process the text \"" + parseableText + "\".");
        }
    }

    private void generateNEsForTypes(List<CoreLabel> tokens, int[][] tokenPositions, String parseableText,
            List<String> types, List<ExtendedTypedNamedEntity> results) {
        for (String type : types) {
            generateNEsForType(tokens, tokenPositions, parseableText, type, results);
        }
    }

    private void generateNEsForType(List<CoreLabel> tokens, int[][] tokenPositions, String parseableText, String type,
            List<ExtendedTypedNamedEntity> results) {
        int pos = parseableText.indexOf(type);
        if (pos < 0) {
            LOGGER.error("Couldn't find type string \"" + type + "\" inside the text \"" + parseableText + "\".");
            return;
        }
        int endPos = pos + type.length();
        // search the tokens that are part of the type string
        int startTokenId = -1, numberOfTokens = -1;
        for (int i = 0; (i < tokenPositions.length) && (numberOfTokens == -1); ++i) {
            if ((startTokenId == -1) && (pos < tokenPositions[i][GEN_TEXT_END])) {
                startTokenId = i;
            }
            if (endPos <= tokenPositions[i][GEN_TEXT_START]) {
                numberOfTokens = i - startTokenId;
            }
        }
        // If the last token was still part of the type
        if (numberOfTokens == -1) {
            numberOfTokens = tokenPositions.length - startTokenId;
        }
        generateNEsForType(tokens, tokenPositions, startTokenId, numberOfTokens, results);
    }

    private void generateNEsForType(List<CoreLabel> tokens, int[][] tokenPositions, int startTokenId,
            int numberOfTokens, List<ExtendedTypedNamedEntity> results) {
        if (numberOfTokens == 0) {
            LOGGER.warn("got a type without tokens.");
            return;
        }
        // FIXME here, we need a way to add the type hierarchy!!!
        String labels[] = new String[numberOfTokens];
        String uppercaseLabels[] = new String[numberOfTokens];
        for (int i = 0; i < numberOfTokens; ++i) {
            labels[i] = tokens.get(i + startTokenId).getString(TextAnnotation.class);
        }
        StringBuilder uriBuilder = new StringBuilder();
        StringBuilder labelBuilder = new StringBuilder();
        int startPosition;
        int endPosition = tokenPositions[startTokenId + numberOfTokens - 1][ORIG_TEXT_END];
        for (int i = numberOfTokens - 1; i >= 0; --i) {
            startPosition = tokenPositions[startTokenId + i][ORIG_TEXT_START];
            uriBuilder.delete(0, uriBuilder.length());
            labelBuilder.delete(0, labelBuilder.length());
            uriBuilder.append(BASE_URI);
            uriBuilder.append(labels[i]);
            labelBuilder.append(labels[i]);
            for (int j = i + 1; j < numberOfTokens; ++j) {
                uriBuilder.append(uppercaseLabels[j]);
                labelBuilder.append(' ');
                labelBuilder.append(labels[j]);
            }
            results.add(new ExtendedTypedNamedEntity(startPosition, endPosition - startPosition, uriBuilder.toString(),
                    new HashSet<String>(Arrays.asList(RDFS.Class.getURI())), labelBuilder.toString()));
            if (i > 0) {
                uppercaseLabels[i] = Character.toUpperCase(labels[i].charAt(0)) + labels[i].substring(1);
            }
        }
    }
    // private Document createDocument(org.aksw.gerbil.transfer.nif.Document
    // nifDocument) {
    // List<NamedEntity> entities = nifDocument.getMarkings(NamedEntity.class);
    // Document document = new Document();
    // document.addProperty(new DocumentText(nifDocument.getText()));
    // document.addProperty(createNesInText(entities));
    // return null;
    // }

    // @SuppressWarnings("deprecation")
    // private NamedEntitiesInText createNesInText(List<NamedEntity> entities) {
    // NamedEntityInText nes[] = new NamedEntityInText[entities.size()];
    // NamedEntity entity;
    // for (int i = 0; i < nes.length; ++i) {
    // entity = entities.get(i);
    // nes[i] = new NamedEntityInText(entity.getStartPosition(),
    // entity.getLength(), entity.getUri());
    // }
    // return new NamedEntitiesInText(nes);
    // }
}
