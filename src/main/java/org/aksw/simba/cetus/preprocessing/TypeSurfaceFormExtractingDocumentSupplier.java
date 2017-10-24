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
