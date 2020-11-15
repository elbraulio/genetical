package com.elbraulio.genetical.genoseed;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class IntSeedTest {
    @Test
    public void size() {
        assertEquals(10, new IntSeed(10, new Random()).genes(10).size());
    }
}
