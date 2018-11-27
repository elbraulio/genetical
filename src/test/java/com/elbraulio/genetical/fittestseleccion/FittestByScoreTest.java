package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class FittestByScoreTest {
    @Test
    public void allFittestReturnLast() {
        final List<Character> genesA = new ArrayList<>(3);
        genesA.add('a');
        final List<Character> genesB = new ArrayList<>(3);
        genesB.add('b');
        final List<Individual<Character>> individuals = new ArrayList<>(3);
        individuals.add(new DefaultIndividual<>(genesA));
        individuals.add(new DefaultIndividual<>(genesB));
        MatcherAssert.assertThat(
                new FittestByScore<Character>(
                        (genes -> 1)
                ).fittest(individuals),
                Matchers.equalTo(new DefaultIndividual<>(genesB))
        );
    }
}