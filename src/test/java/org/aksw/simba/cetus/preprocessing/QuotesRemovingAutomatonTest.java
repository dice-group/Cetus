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
