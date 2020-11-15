package com.elbraulio.genetical.checksolution;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.Individual;

import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class EqualSolution<T> implements CheckSolution<T> {
    private final Individual<T> goal;

    public EqualSolution(Individual<T> goal) {
        this.goal = goal;
    }

    @Override
    public Number score(List<T> genes) {
        return IntStream.range(0, genes.size())
                .filter(i -> genes.get(i).equals(this.goal.genes().get(i)))
                .count();
    }
}
