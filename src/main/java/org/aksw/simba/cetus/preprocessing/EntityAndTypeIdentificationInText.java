/**
 * Cetus - Cetus performs Entity Typing Using patternS
 * Copyright © 2015 Data Science Group (DICE) (michael.roeder@uni-paderborn.de)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
