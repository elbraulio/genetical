package com.elbraulio.genetical.population;

import com.elbraulio.genetical.Individual;
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
public class DefaultPopulationTest {
    @Test
    public void fittest() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        final Set<Individual<Integer>> individuals = new HashSet<>();
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        Individual<Integer> fittest = new DefaultPopulation<>(individuals).fittest(
                individuals1 -> individuals1.stream().findFirst().orElse(null));
        assertEquals(new DefaultIndividual<>(genes), fittest);
    }

    @Test
    public void evolveSize() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        final Set<Individual<Integer>> individuals = new HashSet<>();
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        individuals.add(new DefaultIndividual<>(genes));
        int size = new DefaultPopulation<>(individuals).evolve(DefaultPopulation::new).individuals().size();
        assertEquals(individuals.size(), size);
    }
}
