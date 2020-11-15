package com.elbraulio.genetical.mutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;


/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class CharMutationTest {
    @Test
    public void fullMutation() {
        final List<Character> genes = new ArrayList<>(3);
        genes.add('1');
        genes.add('2');
        genes.add('3');
        List<Character> abcs = new CharMutation(0.999, new Random(), "abc")
                .genes(genes);
        assertTrue(Arrays.stream(new Character[]{'a', 'b', 'c'}).collect(Collectors.toList()).containsAll(abcs));
    }
}
