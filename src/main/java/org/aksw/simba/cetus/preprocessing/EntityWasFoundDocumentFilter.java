/**
 * This file is part of Cetus.
 *
 * Cetus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cetus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Cetus.  If not, see <http://www.gnu.org/licenses/>.
 */
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
