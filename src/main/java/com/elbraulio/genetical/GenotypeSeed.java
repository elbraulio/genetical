package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface GenotypeSeed<T> {
    List<T> genes(Integer size);
}
