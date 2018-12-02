package com.elbraulio.genetical;

import com.elbraulio.genetical.Individual;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface PrintSolution<T> {
    void print(Individual<T> individual);
}
