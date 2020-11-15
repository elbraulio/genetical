package com.elbraulio.genetical;

import java.util.Map;
import java.util.Set;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface Population<T> {
    Population<T> evolve(Evolution<T> evolution);

    Individual<T> fittest(FittestSelection<T> selection);

    Set<Individual<T>> individuals();

    Map<String, Number> scores(CheckSolution<T> solution);
}
