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
