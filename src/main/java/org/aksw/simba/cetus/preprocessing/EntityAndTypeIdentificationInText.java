package org.aksw.simba.cetus.preprocessing;

import org.aksw.simba.cetus.datatypes.DescribedEntity;
import org.aksw.simba.cetus.datatypes.DescribedEntityType;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyAppendingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.DocumentText;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntitiesInText;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntityInText;

public class EntityAndTypeIdentificationInText extends
        AbstractPropertyAppendingDocumentSupplierDecorator<NamedEntitiesInText> {

    public EntityAndTypeIdentificationInText(DocumentSupplier documentSource) {
        super(documentSource);
    }

    @Override
    protected NamedEntitiesInText createPropertyForDocument(Document document) {
        NamedEntitiesInText nesInText = new NamedEntitiesInText();
        document.addProperty(nesInText);
        DocumentText text = document.getProperty(DocumentText.class);
        DescribedEntity entity = document.getProperty(DescribedEntity.class);
        if ((entity != null) && (text != null)) {
            findOccurrencesInText(text.getText(), entity.get(), nesInText);
        }
        entity = document.getProperty(DescribedEntityType.class);
        if ((entity != null) && (text != null)) {
            findOccurrencesInText(text.getText(), entity.get(), nesInText);
        }
        return nesInText;
    }

    private void findOccurrencesInText(String text, NamedEntityInText namedEntity, NamedEntitiesInText nesInText) {
        String label = namedEntity.getLabel().toLowerCase();
        text = text.toLowerCase();
        int pos = text.indexOf(label);
        while (pos >= 0) {
            nesInText
                    .addNamedEntity(new NamedEntityInText(pos, label.length(), namedEntity.getNamedEntityUri(), label));
            pos = text.indexOf(label, pos + label.length());
        }
    }

}
