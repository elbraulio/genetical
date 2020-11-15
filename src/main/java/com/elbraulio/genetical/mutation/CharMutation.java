package com.elbraulio.genetical.mutation;

import com.elbraulio.genetical.Mutation;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class CharMutation implements Mutation<Character> {
    private final double threshold;
    private final Random random;
    private final String alphabet;

    public CharMutation(double threshold, Random random, String alphabet) {
        this.threshold = threshold;
        this.random = random;
        this.alphabet = alphabet;
    }

    @Override
    public List<Character> genes(List<Character> origin) {
        if (this.threshold >= 1)
            throw new IllegalArgumentException(
                    "mutation threshold must be in range [0, 1)"
            );
        return origin.stream()
                .map(c -> shouldMutate() ? getMutatedChar() : c)
                .collect(Collectors.toList());
    }

    private boolean shouldMutate() {
        return this.threshold > Math.random();
    }

    private Character getMutatedChar() {
        return this.alphabet.charAt(this.random.nextInt(this.alphabet.length()));
    }
}
