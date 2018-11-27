package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class SubsetOfTest {
    @Test
    public void exceptionExpected() {
        final List<Character> genesA = new ArrayList<>(1);
        genesA.add('a');
        final List<Individual<Character>> individuals = new ArrayList<>(2);
        individuals.add(new DefaultIndividual<>(genesA));
        individuals.add(new DefaultIndividual<>(genesA));
        try {
            new SubsetOf<Character>(
                    1,
                    (individuals1 -> individuals1.get(1))
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
                    (individuals1 -> individuals1.get(1))
            ).fittest(new LinkedList<>());
        } catch (Exception e) {
            assertEquals(
                    "tournament can not be greater than population",
                    e.getMessage()
            );
        }
    }
}