package com.elbraulio.genetical.crosses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
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
        assertEquals(genesB, new RandomCross<Integer>(0d).genes(genesA, genesB));
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
        assertEquals(genesA, new RandomCross<Integer>(0.999d).genes(genesA, genesB));
    }

    @Test
    public void illegalArgument() {
        try {
            new RandomCross<>(1).genes(null, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
