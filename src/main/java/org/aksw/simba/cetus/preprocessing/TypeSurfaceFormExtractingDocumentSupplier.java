package org.aksw.simba.cetus.preprocessing;

import java.util.List;

import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.cetus.datatypes.TypeSurfaceForms;
import org.aksw.simba.cetus.parser.TypeExtractor;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyAppendingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;

public class TypeSurfaceFormExtractingDocumentSupplier extends
        AbstractPropertyAppendingDocumentSupplierDecorator<TypeSurfaceForms> {

    private TypeExtractor extractor;

    public TypeSurfaceFormExtractingDocumentSupplier(TypeExtractor extractor, DocumentSupplier documentSource) {
        super(documentSource);
        this.extractor = extractor;
    }

    @Override
    protected TypeSurfaceForms createPropertyForDocument(Document document) {
        DocumentText text = document.getProperty(DocumentText.class);
        // TODO for every ne
        // replace the ne with the $ENTITY$ String
        // extract surface forms for this ne
        // List<List<NamedEntity>> surfaceForms =
        // extractor.extractTypeStrings(text.getText());
        return null;
    }

}
