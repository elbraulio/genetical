package com.elbraulio.genetical.mutation;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
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
        MatcherAssert.assertThat(
                new IntMutation(0.99, new Random(), 1).genes(
                        genesA
                ),
                Matchers.contains(genesB.toArray(new Integer[4]))
        );
    }

    @Test
    public void lowThresholdDoesNotMutateAllGenes() {
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
        MatcherAssert.assertThat(
                new IntMutation(0, new Random(), 1).genes(
                        genesA
                ),
                Matchers.contains(genesA.toArray(new Integer[4]))
        );
    }

    @Test
    public void thresholdInRange() {
        try {
            new IntMutation(
                    1.1, null, 0
            ).genes(null);
        } catch (Exception e) {
            assertEquals(
                    "mutation threshold must be in range [0, 1)",
                    e.getMessage()
            );
        }
    }
}