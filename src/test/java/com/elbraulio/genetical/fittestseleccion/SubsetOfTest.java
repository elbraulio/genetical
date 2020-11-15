package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class SubsetOfTest {
    @Test
    public void exceptionExpected() {
        final List<Character> genesA = new ArrayList<>(1);
        genesA.add('a');
        final Set<Individual<Character>> individuals = new HashSet<>();
        individuals.add(new DefaultIndividual<>(genesA));
        individuals.add(new DefaultIndividual<>(genesA));
        try {
            new SubsetOf<Character>(
                    1,
                    (individuals1 -> individuals1.stream().findFirst().orElse(null))
            ).fittest(individuals);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void subsetInRange() {
        try {
            new SubsetOf<Character>(
                    1,
                    (individuals1 -> individuals1.stream().findFirst().orElse(null))
            ).fittest(new HashSet<>());
        } catch (Exception e) {
            assertEquals("tournament can not be greater than population", e.getMessage());
        }
    }
}
