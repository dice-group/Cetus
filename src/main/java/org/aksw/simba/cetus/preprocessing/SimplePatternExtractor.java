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
import org.aksw.simba.cetus.datatypes.SimplePatternInTokenizedText;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyAppendingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.Document;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntitiesInTokenizedText;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntityInText;

public class SimplePatternExtractor extends
        AbstractPropertyAppendingDocumentSupplierDecorator<SimplePatternInTokenizedText> {

    public SimplePatternExtractor(DocumentSupplier documentSource) {
        super(documentSource);
    }

    @Override
    protected SimplePatternInTokenizedText createPropertyForDocument(Document document) {
        NamedEntitiesInTokenizedText nesInText = document.getProperty(NamedEntitiesInTokenizedText.class);
        if (nesInText == null) {
            return null;
        }
        DescribedEntity entity = document.getProperty(DescribedEntity.class);
        if (entity == null) {
            return null;
        }
        DescribedEntityType type = document.getProperty(DescribedEntityType.class);
        if (type == null) {
            return null;
        }
        NamedEntityInText firstEntity = null;
        NamedEntityInText firstType = null;
        for (NamedEntityInText ne : nesInText) {
            if (ne.getNamedEntityUri().equals(entity.get().getNamedEntityUri())) {
                if ((firstEntity == null) || (ne.getStartPos() < firstEntity.getStartPos())) {
                    firstEntity = ne;
                }
            } else if (ne.getNamedEntityUri().equals(type.get().getNamedEntityUri())) {
                if ((firstType == null) || (ne.getStartPos() < firstType.getStartPos())) {
                    firstType = ne;
                }
            }
        }
        if ((firstEntity == null) || (firstType == null)) {
            return null;
        }
        // for (NamedEntityInText ne : nesInText) {
        // if (ne.getNamedEntityUri().equals(type.get().getNamedEntityUri())) {
        // if ((ne.getStartPos() > firstEntity.getStartPos())
        // && ((firstType == null) || (ne.getStartPos() <
        // firstType.getStartPos()))) {
        // firstType = ne;
        // }
        // }
        // }
        // if (firstType == null) {
        // return null;
        // }
        if (firstEntity.getEndPos() <= firstType.getStartPos()) {
            return new SimplePatternInTokenizedText(firstEntity.getEndPos(), firstType.getStartPos(), true);
        } else if (firstType.getEndPos() <= firstEntity.getStartPos()) {
            return new SimplePatternInTokenizedText(firstType.getEndPos(), firstEntity.getStartPos(), false);
        } else {
            return null;
        }
    }
}
