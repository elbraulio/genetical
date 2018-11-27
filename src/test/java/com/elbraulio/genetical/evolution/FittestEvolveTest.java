package com.elbraulio.genetical.evolution;

import com.elbraulio.genetical.Crosses;
import com.elbraulio.genetical.FittestSelection;
import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.Mutation;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class FittestEvolveTest {
    @Test
    public void noChanges() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        final List<Individual<Integer>> ancestors = new ArrayList<>(3);
        ancestors.add(new DefaultIndividual<>(genes));
        ancestors.add(new DefaultIndividual<>(genes));
        ancestors.add(new DefaultIndividual<>(genes));
        MatcherAssert.assertThat(
                new FittestEvolve<>(
                        new FittestSelection<Integer>() {
                            @Override
                            public Individual<Integer> fittest(
                                    List<Individual<Integer>> individuals
                            ) {
                                return individuals.get(0);
                            }
                        },
                        new Crosses<Integer>() {
                            @Override
                            public List<Integer> genes(
                                    List<Integer> genesA, List<Integer> genesB
                            ) {
                                return genesA;
                            }
                        },
                        new Mutation<Integer>() {
                            @Override
                            public List<Integer> genes(
                                    List<Integer> origin
                            ) {
                                return origin;
                            }
                        }
                ).nextGeneration(ancestors).individuals(),
                Matchers.contains(ancestors.toArray(new Individual[3]))
        );
    }
}