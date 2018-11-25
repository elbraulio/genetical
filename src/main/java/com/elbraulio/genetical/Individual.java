package com.elbraulio.genetical;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface Individual<T> {
    T[] genes();

    Number fitness(FitnessTest<T> test);
}
