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
/**
 * This file is part of Cetus.
 *
 * Cetus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cetus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Cetus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.aksw.simba.cetus.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TypeExtractorTest {

    @Parameters
    public static Collection<Object[]> data() {
        List<Object[]> testConfigs = new ArrayList<Object[]>();

        testConfigs.add(new Object[] { "$ENTITY$ device_device_NN ._._.", new String[] { "device_device_NN" } });
        testConfigs.add(new Object[] { "$ENTITY$ was_be_VBD a_a_DT German_german_JJ philosopher_philosopher_NN ._._.",
                new String[] { "German_german_JJ philosopher_philosopher_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ was_be_VBD an_an_DT American_american_JJ novelist_novelist_NN ,_,_, philosopher_philosopher_NN ,_,_, playwright_playwright_NN ,_,_, and_and_CC screen_screen_NN writer_writer_NN ._._.",
                new String[] { "American_american_JJ novelist_novelist_NN", "philosopher_philosopher_NN",
                        "playwright_playwright_NN", "screen_screen_NN writer_writer_NN" } });
        testConfigs.add(
                new Object[] { "$ENTITY$ is_be_VBZ the_the_DT tenth-largest_tenth-large_JJ country_country_NN ._._.",
                        new String[] { "tenth-largest_tenth-large_JJ country_country_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ ,_,_, officially_official_RB The_the_DT People's_people_ng1 Democratic_democratic_JJ Republic_Republic_NN of_of_IN Algeria_Algeria_NN ,_,_, is_be_VBZ a_a_DT country_country_NN ._._.",
                new String[] { "country_country_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ is_be_VBZ an_an_DT extinct_extinct_JJ genus_genus_NN of_of_IN sauropterygian_sauropterygian_JJ type_type_NN",
                new String[] { "extinct_extinct_JJ genus_genus_NN",
                        "sauropterygian_sauropterygian_JJ type_type_NN" } });
        testConfigs.add(new Object[] { "$ENTITY$ is_be_VBZ a_a_DT sub_sub_FW type_type_NN",
                new String[] { "sub_sub_FW type_type_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ is_be_VBZ a_a_DT quarterly_quarter_RB peer-reviewed_peer-review_VBN type_type_NN",
                new String[] { "quarterly_quarter_RB peer-reviewed_peer-review_VBN type_type_NN" } });
        testConfigs.add(new Object[] {
                "Born_bear_VBN on_on_IN December_December_NNP ,_,_, 1629_1629_CD and_and_CC died_die_VBD on_on_IN 19_19_CD August_August_NNP 1686_1686_CD ,_,_, $ENTITY$ or_or_CC Cotelerius_Cotelerius_NNP was_be_VBD a_a_DT Patristic_patristic_JJ scholar_scholar_NN and_and_CC Catholic_catholic_JJ theologian_theologian_NN ._._.",
                new String[] { "Patristic_patristic_JJ scholar_scholar_NN",
                        "Catholic_catholic_JJ theologian_theologian_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ is_be_VBZ a_a_DT fictional_fictional_JJ villain_villain_NN from_from_IN the_the_DT Marvel_Marvel_NNP Comics_Comics_NNPS Universe_Universe_NNP created_create_VBN by_by_IN Bill_Bill_NNP Mantlo_Mantlo_NNP and_and_CC Mike_Mike_NNP Mignola_Mignola_NNP and_and_CC first_first_JJ appearing_appear_VBG in_in_IN print_print_NN in_in_IN late_late_JJ 1985_1985_CD ._._.",
                new String[] { "fictional_fictional_JJ villain_villain_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ -LRB-_-lrb-_-LRB- born_bear_VBN 1949_1949_CD -RRB-_-rrb-_-RRB- is_be_VBZ a_a_DT percussionist_percussionist_NN ,_,_, vocalist_vocalist_NN ,_,_, and_and_CC composer_composer_NN ,_,_, specializing_specialize_VBG in_in_IN frame_frame_NN drums_drum_NNS from_from_IN around_around_IN the_the_DT world_world_NN ._._. He_he_PRP is_be_VBZ largely_largely_RB responsible_responsible_JJ for_for_IN the_the_DT increasing_increase_VBG popularity_popularity_NN of_of_IN frame_frame_NN drums_drum_NNS in_in_IN the_the_DT United_United_NNP States_States_NNPS and_and_CC around_around_IN the_the_DT world_world_NN ._._. Velez_Velez_NNP is_be_VBZ married_marry_VBN to_to_TO Loire_Loire_NNP -LRB-_-lrb-_-LRB- Lori_Lori_NNP Cotler_Cotler_NNP -RRB-_-rrb-_-RRB- ._._.",
                new String[] { "percussionist_percussionist_NN", "vocalist_vocalist_NN", "composer_composer_NN" } });
        testConfigs.add(new Object[] {
                "$ENTITY$ -LRB-_-lrb-_-LRB- born_bear_VBN 1949_1949_CD -RRB-_-rrb-_-RRB- is_be_VBZ a_a_DT percussionist_percussionist_NN ,_,_, vocalist_vocalist_NN ,_,_, and_and_CC composer_composer_NN ._._.",
                new String[] { "percussionist_percussionist_NN", "vocalist_vocalist_NN", "composer_composer_NN" } });
        return testConfigs;
    }

    private String text;
    private Set<String> expectedTypes;

    public TypeExtractorTest(String text, String expectedTypes[]) {
        this.text = text;
        this.expectedTypes = new HashSet<String>(expectedTypes.length);
        for (int i = 0; i < expectedTypes.length; ++i) {
            this.expectedTypes.add(expectedTypes[i]);
        }
    }

    @Test
    public void test() {
        TypeExtractor extractor = new TypeExtractor();
        List<String> types = extractor.extractTypeStrings(text);

        if (expectedTypes == null) {
            Assert.assertNull(types);
            return;
        } else {
            Assert.assertNotNull(types);
        }

        Assert.assertEquals("expected " + expectedTypes.toString() + " but got " + types.toString(),
                expectedTypes.size(), types.size());
        for (String type : types) {
            Assert.assertTrue(
                    "Couldn't find \"" + type + "\" in the list of expected types (" + expectedTypes.toString() + ").",
                    expectedTypes.contains(type));
        }
    }
}
