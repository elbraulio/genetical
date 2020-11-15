package com.elbraulio.genetical.evolution;

import com.elbraulio.genetical.*;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.population.DefaultPopulation;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class FittestEvolve<T> implements Evolution<T> {

    private final FittestSelection<T> tournament;
    private final Crosses<T> crosses;
    private final Mutation<T> mutation;

    public FittestEvolve(FittestSelection<T> tournament, Crosses<T> crosses, Mutation<T> mutation) {
        this.tournament = tournament;
        this.crosses = crosses;
        this.mutation = mutation;
    }

    @Override
    public Population<T> nextGeneration(Set<Individual<T>> individuals) {
        return new DefaultPopulation<>(individuals.stream()
                .map(i -> new DefaultIndividual<>(
                        this.mutation.genes(
                                this.crosses.genes(
                                        this.tournament.fittest(
                                                individuals).genes(),
                                        this.tournament.fittest(
                                                individuals).genes()))))
                .collect(Collectors.toSet()));
    }
}
