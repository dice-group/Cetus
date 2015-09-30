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

import java.util.Set;

import org.aksw.gerbil.transfer.nif.data.TypedNamedEntity;

public class ExtendedTypedNamedEntity extends TypedNamedEntity {

    private String label;

    public ExtendedTypedNamedEntity(int startPosition, int length, Set<String> uris, Set<String> types) {
        super(startPosition, length, uris, types);
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, String uri, Set<String> types) {
        super(startPosition, length, uri, types);
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, Set<String> uris, Set<String> types, String label) {
        super(startPosition, length, uris, types);
        this.label = label;
    }

    public ExtendedTypedNamedEntity(int startPosition, int length, String uri, Set<String> types, String label) {
        super(startPosition, length, uri, types);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
