package org.aksw.simba.cetus.annotator;

import java.util.List;
import java.util.Map;

import org.aksw.gerbil.transfer.nif.Document;
import org.aksw.gerbil.transfer.nif.data.DocumentImpl;
import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.datatypes.ExtendedTypedNamedEntity;

public class CetusAnnotator {

    private CetusSurfaceFormExtractor surfaceFormExtractor;
    private CetusTypeSearcher typeSearcher;

    public CetusAnnotator(CetusSurfaceFormExtractor surfaceFormExtractor, CetusTypeSearcher typeSearcher) {
        this.surfaceFormExtractor = surfaceFormExtractor;
        this.typeSearcher = typeSearcher;
    }

    public Document performTypeExtraction(Document document) {
        // extract the surface forms
        // List<List<NamedEntity>> types =
        // surfaceFormExtractor.extractTypeSurfaceForms(document);
        // TypingInfoImpl typingInfo = new TypingInfoImpl();
        // // TODO find a type for every type surface form that has been found
        // List<NamedEntity> typesFound = linkTypes(types, typingInfo);
        // return new TypeExtractionResult(typesFound, typingInfo);
        Map<NamedEntity, List<ExtendedTypedNamedEntity>> extractedTypes = surfaceFormExtractor
                .extractTypeSurfaceForms(document);
        Document resultDoc = new DocumentImpl(document.getText(), document.getDocumentURI());
        List<ExtendedTypedNamedEntity> surfaceForms;
        for (NamedEntity ne : extractedTypes.keySet()) {
            surfaceForms = extractedTypes.get(ne);
            resultDoc.addMarking(typeSearcher.getAllTypes(document, ne, surfaceForms));
            resultDoc.getMarkings().addAll(surfaceForms);
        }
        return resultDoc;
    }
}
