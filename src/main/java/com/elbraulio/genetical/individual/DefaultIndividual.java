package com.elbraulio.genetical.individual;

import com.elbraulio.genetical.FitnessTest;
import com.elbraulio.genetical.Individual;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class DefaultIndividual<T> implements Individual<T> {
    private final T[] genes;

    public DefaultIndividual(T[] genes) {
        this.genes = genes;
    }

    @Override
    public T[] genes() {
        return this.genes;
    }

    @Override
    public Number fitness(FitnessTest<T> test) {
        return test.score(this.genes());
    }
}
