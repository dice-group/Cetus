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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class QuotesRemovingAutomatonTest {

    @Parameters
    public static Collection<Object[]> data() {
        List<Object[]> testConfigs = new ArrayList<Object[]>();
        testConfigs.add(new Object[] { "", "" });
        testConfigs.add(new Object[] { "=", "=" });
        testConfigs.add(new Object[] { "''", "" });
        testConfigs.add(new Object[] { "This is a text.", "This is a text." });
        testConfigs
                .add(new Object[] {
                        "The 'Peru national football team has represented' Peru in international football since 1927. Organised by the \"Peruvian Football Federation\" (FPF), it is one of the 10 members of FIFA's South American Football Confederation (CONMEBOL).",
                        "The Peru national football team has represented Peru in international football since 1927. Organised by the Peruvian Football Federation (FPF), it is one of the 10 members of FIFA's South American Football Confederation (CONMEBOL)." });
        testConfigs.add(new Object[] { "Lima /ˈliːmə/ is the capital and the largest city of Peru.",
                "Lima /ˈliːmə/ is the capital and the largest city of Peru." });
        testConfigs.add(new Object[] { "This is \"\" another '' test.", "This is  another  test." });
        return testConfigs;
    }

    private String inputText;
    private String expectedText;

    public QuotesRemovingAutomatonTest(String inputText, String expectedText) {
        this.inputText = inputText;
        this.expectedText = expectedText;
    }

    @Test
    public void test() {
        QuotesRemovingAutomaton automaton = new QuotesRemovingAutomaton();
        Assert.assertEquals(expectedText, automaton.removeQuotes(inputText));
    }

}
