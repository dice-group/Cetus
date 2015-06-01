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
