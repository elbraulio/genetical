package com.elbraulio.genetical;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface FitnessTest<T> {
    Number score(T[] genes);
}
