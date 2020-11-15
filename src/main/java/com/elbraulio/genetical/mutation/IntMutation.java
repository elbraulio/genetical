package com.elbraulio.genetical.mutation;

import com.elbraulio.genetical.Mutation;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class IntMutation implements Mutation<Integer> {
    private final double threshold;
    private final Random randomness;
    private final int bound;

    public IntMutation(double threshold, Random randomness, int bound) {
        this.threshold = threshold;
        this.randomness = randomness;
        this.bound = bound;
    }

    @Override
    public List<Integer> genes(List<Integer> origin) {
        if (this.threshold >= 1)
            throw new IllegalArgumentException(
                    "mutation threshold must be in range [0, 1)"
            );
        return origin.stream()
                .map(i -> shouldMutate() ? getMutated() : i)
                .collect(Collectors.toList());
    }

    private boolean shouldMutate() {
        return this.threshold > Math.random();
    }

    private Integer getMutated() {
        return this.randomness.nextInt(this.bound);
    }
}
