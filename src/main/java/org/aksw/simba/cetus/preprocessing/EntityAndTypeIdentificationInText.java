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
