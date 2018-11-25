package com.elbraulio.genetical.individual;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class DefaultIndividualTest {
    @Test
    public void immutableIndividual() {
        final Integer[] genes = new Integer[]{1, 2, 3};
        MatcherAssert.assertThat(
                new DefaultIndividual<>(genes).genes(),
                Matchers.arrayContaining(genes)
        );
    }

    @Test
    public void allGenesArePartOfTestFitness() {
        final Integer[] genes = new Integer[]{1, 2, 3};
        MatcherAssert.assertThat(
                new DefaultIndividual<>(genes).fitness(
                        (genesArray) ->
                                genesArray[0] * genesArray[1] * genesArray[2]
                ),
                Matchers.is(6)
        );
    }
}