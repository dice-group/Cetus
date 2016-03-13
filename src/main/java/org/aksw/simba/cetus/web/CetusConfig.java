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
package org.aksw.simba.cetus.web;

import org.aksw.simba.cetus.annotator.CetusSurfaceFormExtractor;
import org.aksw.simba.cetus.fox.FoxBasedTypeSearcher;
import org.aksw.simba.cetus.yago.YagoBasedTypeSearcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.aksw.simba.cetus.web")
// @PropertySource("cetus.properties")
public class CetusConfig {

    @Bean
    public static CetusSurfaceFormExtractor createExtractor() {
        return CetusSurfaceFormExtractor.create();
    }

    @Bean
    public static YagoBasedTypeSearcher createYagoBasedSearcher() {
        return YagoBasedTypeSearcher.create();
    }

    @Bean
    public static FoxBasedTypeSearcher createFoxBasedTypeSearcher() {
        return new FoxBasedTypeSearcher();
    }

}
