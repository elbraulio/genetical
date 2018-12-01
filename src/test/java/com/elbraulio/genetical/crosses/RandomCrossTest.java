package com.elbraulio.genetical.crosses;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class RandomCrossTest {
    @Test
    public void oneSidedCrossRight() {
        final List<Integer> genesA = new ArrayList<>(3);
        genesA.add(1);
        genesA.add(2);
        genesA.add(3);
        final List<Integer> genesB = new ArrayList<>(3);
        genesB.add(4);
        genesB.add(5);
        genesB.add(6);
        MatcherAssert.assertThat(
                new RandomCross<Integer>(0d).genes(genesA, genesB),
                Matchers.contains(genesB.toArray(new Integer[3]))
        );
    }

    @Test
    public void oneSidedCrossLeft() {
        final List<Integer> genesA = new ArrayList<>(3);
        genesA.add(1);
        genesA.add(2);
        genesA.add(3);
        final List<Integer> genesB = new ArrayList<>(3);
        genesB.add(4);
        genesB.add(5);
        genesB.add(6);
        MatcherAssert.assertThat(
                new RandomCross<Integer>(0.99d).genes(genesA, genesB),
                Matchers.contains(genesA.toArray(new Integer[3]))
        );
    }

    @Test
    public void illegalArgument() {
        try {
            new RandomCross<>(1).genes(null, null);
            assertTrue(false);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}