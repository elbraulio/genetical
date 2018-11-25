package com.elbraulio.genetical.individual;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class DefaultIndividualTest {
    @Test
    public void immutableIndividual() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        MatcherAssert.assertThat(
                new DefaultIndividual<>(genes).genes(),
                Matchers.contains(genes.toArray(new Integer[3]))
        );
    }

    @Test
    public void allGenesArePartOfTestFitness() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        MatcherAssert.assertThat(
                new DefaultIndividual<>(genes).fitness(
                        (genesList) ->
                                genesList.get(0) * genesList.get(1) *
                                        genesList.get(2)
                ),
                Matchers.is(6)
        );
    }
}