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
