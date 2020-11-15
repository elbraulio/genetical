package com.elbraulio.genetical.genoseed;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class CharSeedTest {
    @Test
    public void size() {
        assertEquals(10, new CharSeed(new Random(), "a").genes(10).size());
    }
}
