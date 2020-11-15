package com.elbraulio.genetical.checksolution;

import com.elbraulio.genetical.individual.DefaultIndividual;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public class EqualSolutionTest {
    @Test
    public void maxScore() {
        final List<Integer> goal = new ArrayList<>(3);
        goal.add(1);
        goal.add(2);
        goal.add(3);
        assertEquals(3L, new EqualSolution<>(new DefaultIndividual<>(goal)).score(goal));
    }
}
