package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.FittestSelection;
import com.elbraulio.genetical.Individual;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class FittestByScore<T> implements FittestSelection<T> {

    private final CheckSolution<T> check;

    public FittestByScore(CheckSolution<T> check) {
        this.check = check;
    }

    @Override
    public Individual<T> fittest(Set<Individual<T>> individuals) {
        final String fittest = individuals.stream()
                .collect(Collectors.toMap(Individual::id, i -> this.check.score(i.genes())))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(e -> e.getValue().doubleValue()))
                .map(Map.Entry::getKey)
                .orElse("");
        return individuals.stream()
                .filter(i -> i.id().equals(fittest))
                .limit(1)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Individual should have been found"));
    }
}
