package com.elbraulio.genetical.genoseed;

import com.elbraulio.genetical.GenotypeSeed;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class IntSeed implements GenotypeSeed<Integer> {
    private final int bound;
    private final Random randomness;

    public IntSeed(int bound, Random randomness) {
        this.bound = bound;
        this.randomness = randomness;
    }

    @Override
    public List<Integer> genes(Integer size) {
        return IntStream.range(0, size)
                .boxed()
                .map(i -> this.randomness.nextInt(this.bound))
                .collect(Collectors.toList());
    }
}
