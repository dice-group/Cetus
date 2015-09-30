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

import org.aksw.simba.topicmodeling.utils.doc.AbstractDocumentProperty;

public class SimplePatternInTokenizedText extends AbstractDocumentProperty {

    private static final long serialVersionUID = 1L;

    private int start;
    private int end;
    private boolean startsWithEntity = true;

    public SimplePatternInTokenizedText(int start, int end, boolean startsWithEntity) {
        this.start = start;
        this.end = end;
        this.startsWithEntity = startsWithEntity;
    }

    public SimplePatternInTokenizedText(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Object getValue() {
        return new int[] { start, end };
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public boolean startsWithEntity() {
        return startsWithEntity;
    }

    public void setStartsWithEntity(boolean startsWithEntity) {
        this.startsWithEntity = startsWithEntity;
    }
}
