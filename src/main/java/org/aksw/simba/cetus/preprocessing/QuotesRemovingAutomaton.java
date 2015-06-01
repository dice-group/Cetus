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

/**
 * Removes '"' and '\'' from the text. Single quotes (') are only removed if
 * they are not surrounded by letters. Thus, strings like "Peter's" shouldn't be
 * changed.
 * 
 * @author Michael R&ouml;der <roeder@informatik.uni-leipzig.de>
 * 
 */
public class QuotesRemovingAutomaton {

    public String removeQuotes(String text) {
        char chars[] = text.toCharArray();
        StringBuilder builder = new StringBuilder(chars.length);
        int state = 0, startPos = 0;
        char c;
        for (int i = 0; i < chars.length; ++i) {
            c = chars[i];
            switch (state) {
            case 0: // the strings starts or we saw a whitespace before
            {
                if ((c == '"') || (c == '\'')) {
                    builder.append(text.substring(startPos, i));
                    startPos = i + 1;
                } else if (Character.isLetterOrDigit(c)) {
                    state = 1;
                }
                break;
            }
            case 1: // we saw a letter or a digit before.
            {
                if (c == '"') {
                    builder.append(text.substring(startPos, i));
                    startPos = i + 1;
                } else if (c == '\'') {
                    state = 2;
                } else if (!Character.isLetterOrDigit(c)) {
                    state = 0;
                }
                break;
            }
            case 2:// we saw some letters followed by a '\'' before.
            {
                // If this is not followed by a letter or a digit we can remove
                // it
                if (!Character.isLetterOrDigit(c)) {
                    builder.append(text.substring(startPos, i - 1));
                    if ((c == '"') || (c == '\'')) {
                        startPos = i + 1;
                    } else {
                        startPos = i;
                    }
                    state = 0;
                } else {
                    state = 1;
                }
                break;
            }
            default: {
                throw new IllegalStateException("Unkown state=" + state + " for this automaton.");
            }
            }
        }
        builder.append(text.substring(startPos));
        return builder.toString();
    }
}
