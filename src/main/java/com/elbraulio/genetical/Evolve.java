package com.elbraulio.genetical;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public interface Evolve {
    Population newPopulation(List<Individual> individuals);
}
