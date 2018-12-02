package com.elbraulio.genetical.genoseed;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class IntSeedTest {
    @Test
    public void size() {
        MatcherAssert.assertThat(
                new IntSeed(10, new Random()).genes(10).size(),
                Matchers.is(10)
        );
    }

}