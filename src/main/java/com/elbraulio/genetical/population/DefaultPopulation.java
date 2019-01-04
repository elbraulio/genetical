package com.elbraulio.genetical.population;

import com.elbraulio.genetical.*;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class DefaultPopulation<T> implements Population<T> {
    private final List<Individual<T>> individuals;

    public DefaultPopulation(List<Individual<T>> individuals) {
        this.individuals = individuals;
    }

    @Override
    public Population<T> evolve(Evolution<T> evolution) {
        return evolution.nextGeneration(this.individuals);
    }

    @Override
    public Individual<T> fittest(FittestSelection<T> selection) {
        return selection.fittest(this.individuals);
    }

    @Override
    public List<Individual<T>> individuals() {
        return this.individuals;
    }

    @Override
    public Number[] scores(CheckSolution<T> solution) {
        final Number[] scores = new Number[this.individuals.size()];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = solution.score(this.individuals.get(i).genes());
        }
        return scores;
    }
}
