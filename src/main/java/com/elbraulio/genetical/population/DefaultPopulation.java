package com.elbraulio.genetical.population;

import com.elbraulio.genetical.*;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class DefaultPopulation<T> implements Population<T> {
    private final Set<Individual<T>> individuals;

    public DefaultPopulation(Set<Individual<T>> individuals) {
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
    public Set<Individual<T>> individuals() {
        return this.individuals;
    }

    @Override
    public Map<String, Number> scores(CheckSolution<T> solution) {
        return this.individuals.stream()
                .collect(Collectors.toMap(Individual::id, i -> solution.score(i.genes())));
    }
}
