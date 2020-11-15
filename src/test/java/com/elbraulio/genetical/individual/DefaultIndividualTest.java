package com.elbraulio.genetical.individual;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class DefaultIndividualTest {
    @Test
    public void immutableIndividual() {
        final List<Integer> genes = new ArrayList<>(3);
        genes.add(1);
        genes.add(2);
        genes.add(3);
        assertEquals(genes, new DefaultIndividual<>(genes).genes());
    }
}
