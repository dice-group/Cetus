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

import org.aksw.simba.topicmodeling.utils.doc.AbstractSimpleDocumentProperty;
import org.aksw.simba.topicmodeling.utils.doc.ParseableDocumentProperty;
import org.aksw.simba.topicmodeling.utils.doc.ner.NamedEntityInText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DescribedEntity extends AbstractSimpleDocumentProperty<NamedEntityInText> implements
        ParseableDocumentProperty {

    private static final Logger LOGGER = LoggerFactory.getLogger(DescribedEntity.class);

    private static final long serialVersionUID = 1L;

    public DescribedEntity(String label, String uri) {
        super(new NamedEntityInText(0, 0, uri, label));
    }

    @Override
    public void parseValue(String value) {
        // URI starts with "(\"" and ends with "\", \""
        int start = 2;
        int end = value.indexOf("\", \"");
        if (end < start) {
            LOGGER.error("Error while parsing the named entity. Couldn't find end of the URI. Setting the value to null.");
            set(null);
            return;
        }
        String uri = new String(value.substring(start, end));
        // label starts with "\", \"" and ends with "\", "
        start = end + 4;
        end = value.indexOf("\", ", start);
        if (end < start) {
            LOGGER.error("Error while parsing the named entity. Couldn't find end of the Label. Setting the value to null.");
            set(null);
            return;
        }
        String label = new String(value.substring(start, end));
        // startPos starts with "\", " and ends with ", "
        start = end + 3;
        end = value.indexOf("\", ", start);
        if (end < start) {
            LOGGER.error("Error while parsing the named entity. Couldn't find end of the startPos. Setting the value to null.");
            set(null);
            return;
        }
        int startPos, length;
        try {
            startPos = Integer.parseInt(value.substring(start, end));
        } catch (NumberFormatException e) {
            LOGGER.error("Error while parsing the named entity. Couldn't parse the startPos. Setting the value to null.");
            set(null);
            return;
        }
        // endPos starts with ", " and ends with ")"
        start = end + 2;
        end = value.indexOf(")", start);
        if (end < start) {
            LOGGER.error("Error while parsing the named entity. Couldn't find end of the length. Setting the value to null.");
            set(null);
            return;
        }
        try {
            length = Integer.parseInt(value.substring(start, end));
        } catch (NumberFormatException e) {
            LOGGER.error("Error while parsing the named entity. Couldn't parse the length. Setting the value to null.");
            set(null);
            return;
        }
        set(new NamedEntityInText(startPos, length, uri, label));
    }

    @Override
    public String toString() {
        return "DescribedEntity=" + get().toString();
    }
}
