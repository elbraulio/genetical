package com.elbraulio.genetical.individual;

import com.elbraulio.genetical.FitnessTest;
import com.elbraulio.genetical.Individual;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class DefaultIndividual<T> implements Individual<T> {
    private final List<T> genes;

    public DefaultIndividual(List<T> genes) {
        this.genes = genes;
    }

    @Override
    public List<T> genes() {
        return this.genes;
    }

    @Override
    public Number fitness(FitnessTest<T> test) {
        return test.score(this.genes());
    }
}