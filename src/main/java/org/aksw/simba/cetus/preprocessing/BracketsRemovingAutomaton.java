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

import com.carrotsearch.hppc.CharArrayList;

public class BracketsRemovingAutomaton {

    public String removeBrackets(String text) {
        char chars[] = text.toCharArray();
        CharArrayList stack = new CharArrayList();
        StringBuilder builder = new StringBuilder(chars.length);
        char c;
        for (int i = 0; i < chars.length; ++i) {
            c = chars[i];
            switch (c) {
            case '(': // falls through
            case '[':
            case '{': {
                stack.add(c);
                break;
            }
            case ')': {
                if ((stack.elementsCount > 0) && (stack.buffer[stack.elementsCount - 1] == '(')) {
                    stack.remove(stack.elementsCount - 1);
                }
                break;
            }
            case ']': {
                if ((stack.elementsCount > 0) && (stack.buffer[stack.elementsCount - 1] == '[')) {
                    stack.remove(stack.elementsCount - 1);
                }
                break;
            }
            case '}': {
                if ((stack.elementsCount > 0) && (stack.buffer[stack.elementsCount - 1] == '{')) {
                    stack.remove(stack.elementsCount - 1);
                }
                break;
            }
            default: {
                if (stack.elementsCount == 0) {
                    builder.append(c);
                }
                break;
            }
            }
        }
        return builder.toString();
    }
}
