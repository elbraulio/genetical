package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface Mutation<T> {
    List<T> genes(List<T> origin);
}
