package com.elbraulio.genetical;

import java.util.Set;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface FittestSelection<T> {
    Individual<T> fittest(Set<Individual<T>> individuals);
}
