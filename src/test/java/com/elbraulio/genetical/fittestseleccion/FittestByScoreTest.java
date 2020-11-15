package com.elbraulio.genetical.fittestseleccion;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class FittestByScoreTest {
    @Test
    public void allFittestReturnLast() {
        final List<Character> genesA = new ArrayList<>();
        genesA.add('a');
        genesA.add('b');
        final List<Character> genesB = new ArrayList<>();
        genesB.add('b');
        final Set<Individual<Character>> individuals = new HashSet<>();
        individuals.add(new DefaultIndividual<>(genesA));
        individuals.add(new DefaultIndividual<>(genesB));
        assertEquals(new DefaultIndividual<>(genesA),
                new FittestByScore<Character>((List::size)).fittest(individuals));
    }
}
