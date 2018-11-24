package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface FitnessTest<T> {
    Number score(List<T> genes);
}
