package com.elbraulio.genetical.crosses;

import com.elbraulio.genetical.Crosses;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class RandomCross<T> implements Crosses<T> {
    private final double threshold;

    public RandomCross(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public List<T> genes(List<T> genesA, List<T> genesB) {
        if (this.threshold >= 1 || this.threshold < 0)
            throw new IllegalArgumentException(
                    "mutation threshold must be in range [0, 1)"
            );
        return IntStream.range(0, genesA.size())
                .mapToObj(i -> Math.random() < this.threshold ? genesA.get(i) : genesB.get(i))
                .collect(Collectors.toList());
    }
}
