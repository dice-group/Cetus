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
public class BracketsRemovingAutomatonTest {

    @Parameters
    public static Collection<Object[]> data() {
        List<Object[]> testConfigs = new ArrayList<Object[]>();
        testConfigs.add(new Object[] { "", "" });
        testConfigs.add(new Object[] { "=", "=" });
        testConfigs.add(new Object[] { "Dies ist ein Testtext.", "Dies ist ein Testtext." });
        testConfigs.add(new Object[] { "The Peru national football team has represented Peru in international football since 1927. Organised by the Peruvian Football Federation (FPF), it is one of the 10 members of FIFA's South American Football Confederation (CONMEBOL).", "The Peru national football team has represented Peru in international football since 1927. Organised by the Peruvian Football Federation , it is one of the 10 members of FIFA's South American Football Confederation ." });
        testConfigs.add(new Object[] { "Lima /ˈliːmə/ is the capital and the largest city of Peru.", "Lima /ˈliːmə/ is the capital and the largest city of Peru." });
        testConfigs.add(new Object[] { "El Callao (/kɑːˈjaʊ/; Spanish pronunciation: [kaˈʎa.o] or [kaˈʝa.o]) is the chief seaport of Peru.", "El Callao  is the chief seaport of Peru." });
        return testConfigs;
    }

    private String inputText;
    private String expectedText;

    public BracketsRemovingAutomatonTest(String inputText, String expectedText) {
        this.inputText = inputText;
        this.expectedText = expectedText;
    }

    @Test
    public void test() {
        BracketsRemovingAutomaton automaton = new BracketsRemovingAutomaton();
        Assert.assertEquals(expectedText, automaton.removeBrackets(inputText));
    }

}
