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
