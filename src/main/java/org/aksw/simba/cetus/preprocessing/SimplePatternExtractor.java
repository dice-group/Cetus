/**
 * The MIT License
 * Copyright (c) 2015 Agile Knowledge Engineering and Semantic Web (AKSW) (usbeck@informatik.uni-leipzig.de)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
