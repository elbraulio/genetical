package com.elbraulio.genetical;

import java.util.Set;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface Evolution<T> {
    Population<T> nextGeneration(Set<Individual<T>> individuals);
}
