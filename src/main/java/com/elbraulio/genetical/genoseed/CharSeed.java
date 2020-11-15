package com.elbraulio.genetical.genoseed;

import com.elbraulio.genetical.GenotypeSeed;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class CharSeed implements GenotypeSeed<Character> {
    private final Random random;
    private final String alphabet;

    public CharSeed(Random random, String alphabet) {
        this.random = random;
        this.alphabet = alphabet;
    }

    @Override
    public List<Character> genes(Integer size) {
        return IntStream.range(0, size)
                .boxed()
                .map(i -> this.alphabet.charAt(this.random.nextInt(this.alphabet.length())))
                .collect(Collectors.toList());
    }
}
