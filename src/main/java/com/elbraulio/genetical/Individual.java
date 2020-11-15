package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public interface Individual<T> {

    String id();

    List<T> genes();
}
