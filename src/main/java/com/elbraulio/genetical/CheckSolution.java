package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface CheckSolution<T> {
    Number score(List<T> genes);
}
