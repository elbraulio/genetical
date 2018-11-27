package com.elbraulio.genetical.genoseed;

import com.elbraulio.genetical.GenotypeSeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class IntSeed implements GenotypeSeed<Integer> {
    private final int n;
    private final Random randomness;

    public IntSeed(int n, Random randomness) {

        this.n = n;
        this.randomness = randomness;
    }

    @Override
    public List<Integer> genes() {
        final List<Integer> genes = new ArrayList<>(this.n);
        for (int i = 0; i < this.n; i++) {
            genes.add(this.randomness.nextInt(this.n));
        }
        return genes;
    }
}
