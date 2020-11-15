package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.FittestSelection;
import com.elbraulio.genetical.Individual;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class SubsetOf<T> implements FittestSelection<T> {

    private final int participants;
    private final FittestSelection<T> origin;

    public SubsetOf(int participants, FittestSelection<T> origin) {

        this.participants = participants;
        this.origin = origin;
    }

    @Override
    public Individual<T> fittest(Set<Individual<T>> individuals) {
        if (this.participants > individuals.size()) {
            throw new IllegalArgumentException("tournament can not be greater than population");
        }
        final Random random = new Random();
        final List<Individual<T>> clone = new LinkedList<>(individuals);
        Set<Individual<T>> subset = IntStream.range(0, this.participants)
                .mapToObj(i -> {
                    int index = random.nextInt(clone.size());
                    Individual<T> individual = clone.get(index);
                    clone.remove(index);
                    return individual;
                })
                .collect(Collectors.toSet());
        return this.origin.fittest(subset);
    }
}
