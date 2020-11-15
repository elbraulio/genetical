package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.FittestSelection;
import com.elbraulio.genetical.Individual;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class FittestTwin<T> implements FittestSelection<T> {
    private final List<T> genes;

    public FittestTwin(List<T> genes) {
        this.genes = genes;
    }

    @Override
    public Individual<T> fittest(Set<Individual<T>> individuals) {
        final String fittest = individuals.stream()
                .collect(Collectors.toMap(Individual::id, this::getScore))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
        return individuals.stream()
                .filter(i -> i.id().equals(fittest))
                .limit(1)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Individual must been found"));
    }

    private long getScore(Individual<T> individual) {
        return IntStream.range(0, individual.genes().size())
                .filter(i -> individual.genes().get(i).equals(this.genes.get(i)))
                .count();
    }
}
