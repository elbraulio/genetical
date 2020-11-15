package com.elbraulio.genetical.mutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class IntMutationTest {
    @Test
    public void highThresholdMutateAllGenes() {
        final List<Integer> genesA = new ArrayList<>(4);
        genesA.add(10);
        genesA.add(9);
        genesA.add(8);
        genesA.add(7);
        final List<Integer> genesB = new ArrayList<>(4);
        genesB.add(0);
        genesB.add(0);
        genesB.add(0);
        genesB.add(0);
        List<Integer> genes = new IntMutation(0.99999, new Random(), 1).genes(genesA);
        assertTrue(genesB.containsAll(genes));
    }

    @Test
    public void lowThresholdDoesNotMutateAllGenes() {
        final List<Integer> genesA = new ArrayList<>(4);
        genesA.add(10);
        genesA.add(9);
        genesA.add(8);
        genesA.add(7);
        List<Integer> genes = new IntMutation(0, new Random(), 1).genes(genesA);
        assertTrue(genes.containsAll(genesA));
    }

    @Test
    public void thresholdInRange() {
        try {
            new IntMutation(1.1, null, 0).genes(new ArrayList<>());
        } catch (Exception e) {
            assertEquals("mutation threshold must be in range [0, 1)", e.getMessage());
        }
    }
}
