package com.elbraulio.genetical.evolution;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.Mutation;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class FittestEvolveTest {
    @Test
    public void noChanges() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        Set<Individual<Integer>> ancestors = new HashSet<>();
        ancestors.add(new DefaultIndividual<>(genes));
        ancestors.add(new DefaultIndividual<>(genes));
        ancestors.add(new DefaultIndividual<>(genes));
        Set<Individual<Integer>> nextGen = new FittestEvolve<>(
                individuals -> individuals.stream().findFirst().orElse(null),
                (genesA, genesB) -> genesA,
                (Mutation<Integer>) origin -> origin
        ).nextGeneration(ancestors).individuals();
        assertEquals(ancestors, nextGen);
    }
}
