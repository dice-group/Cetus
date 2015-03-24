package org.aksw.simba.cetus.preprocessing;

import org.aksw.simba.cetus.datatypes.DescribedEntity;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.filter.DocumentFilter;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntitiesInText;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntityInText;

public class EntityWasFoundDocumentFilter implements DocumentFilter {

    private Class<? extends DescribedEntity> entityPropertyClass;

    public EntityWasFoundDocumentFilter(Class<? extends DescribedEntity> entityPropertyClass) {
        this.entityPropertyClass = entityPropertyClass;
    }

    @Override
    public boolean isDocumentGood(Document document) {
        NamedEntitiesInText nesInText = document.getProperty(NamedEntitiesInText.class);
        if (nesInText == null) {
            return false;
        }
        DescribedEntity entity = document.getProperty(entityPropertyClass);
        if (entity == null) {
            return false;
        }
        for (NamedEntityInText ne : nesInText) {
            if (ne.getNamedEntityUri().equals(entity.get().getNamedEntityUri())) {
                return true;
            }
        }
        return false;
    }

}
