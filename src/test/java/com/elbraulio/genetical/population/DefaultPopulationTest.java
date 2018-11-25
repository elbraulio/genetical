package com.elbraulio.genetical.population;

import com.elbraulio.genetical.FittestSelection;
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
public class DefaultPopulationTest {
    @Test
    public void fittest() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        final List<Individual<Integer>> individuals = new ArrayList<>(3);
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        MatcherAssert.assertThat(
                new DefaultPopulation<>(individuals).fittest(
                        new FittestSelection<Integer>() {
                            @Override
                            public Individual<Integer> fittest(
                                    List<Individual<Integer>> individuals
                            ) {
                                return individuals.get(0);
                            }
                        }
                ),
                Matchers.equalTo(new DefaultIndividual<>(genes))
        );
    }
}