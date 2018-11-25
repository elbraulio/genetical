package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface Tournament<T> {
    Individual <T> compete(List<Individual<T>> individuals);
}
