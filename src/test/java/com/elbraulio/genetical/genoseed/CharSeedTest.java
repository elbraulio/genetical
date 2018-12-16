package com.elbraulio.genetical.genoseed;

import com.elbraulio.genetical.genoseed.CharSeed;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class CharSeedTest {
    @Test
    public void size() {
        MatcherAssert.assertThat(
                new CharSeed(new Random(), "a").genes(10).size(),
                Matchers.is(10)
        );
    }
}