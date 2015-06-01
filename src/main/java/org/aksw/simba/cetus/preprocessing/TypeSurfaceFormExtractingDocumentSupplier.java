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

import org.aksw.simba.cetus.datatypes.TypeSurfaceForms;
import org.aksw.simba.cetus.parser.TypeExtractor;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.DocumentSupplier;
import org.aksw.simba.topicmodeling.preprocessing.docsupplier.decorator.AbstractPropertyAppendingDocumentSupplierDecorator;
import org.aksw.simba.topicmodeling.utils.doc.Document;

@Deprecated
public class TypeSurfaceFormExtractingDocumentSupplier extends
        AbstractPropertyAppendingDocumentSupplierDecorator<TypeSurfaceForms> {

    @SuppressWarnings("unused")
    private TypeExtractor extractor;

    public TypeSurfaceFormExtractingDocumentSupplier(TypeExtractor extractor, DocumentSupplier documentSource) {
        super(documentSource);
        this.extractor = extractor;
    }

    @Override
    protected TypeSurfaceForms createPropertyForDocument(Document document) {
        // DocumentText text = document.getProperty(DocumentText.class);
        // TODO for every ne
        // replace the ne with the $ENTITY$ String
        // extract surface forms for this ne
        // List<List<NamedEntity>> surfaceForms =
        // extractor.extractTypeStrings(text.getText());
        return null;
    }

}
