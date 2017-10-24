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
