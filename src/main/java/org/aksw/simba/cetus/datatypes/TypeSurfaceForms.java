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
package org.aksw.simba.cetus.datatypes;

import java.util.List;

import org.aksw.gerbil.transfer.nif.data.NamedEntity;
import org.aksw.simba.topicmodeling.utils.doc.AbstractSimpleDocumentProperty;

public class TypeSurfaceForms extends AbstractSimpleDocumentProperty<List<List<NamedEntity>>> {

    private static final long serialVersionUID = 1L;

    public TypeSurfaceForms(List<List<NamedEntity>> value) {
        super(value);
    }

}
