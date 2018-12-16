package com.elbraulio.genetical.genoseed;

import com.elbraulio.genetical.GenotypeSeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class CharSeed implements GenotypeSeed<Character> {
    private final Random random;
    private final String alphabet;

    public CharSeed(Random random, String alphabet) {
        this.random = random;
        this.alphabet = alphabet;
    }

    @Override
    public List<Character> genes(int size) {
        final List<Character> genes = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            genes.add(
                    this.alphabet.charAt(
                            this.random.nextInt(this.alphabet.length())
                    )
            );
        }
        return genes;
    }
}
