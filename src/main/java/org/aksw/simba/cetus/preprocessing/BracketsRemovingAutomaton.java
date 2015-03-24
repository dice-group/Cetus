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
