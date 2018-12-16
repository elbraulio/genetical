package com.elbraulio.genetical.checksolution;

import com.elbraulio.genetical.checksolution.EqualSolution;
import com.elbraulio.genetical.individual.DefaultIndividual;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class EqualSolutionTest {
    @Test
    public void maxScore(){
        final List<Integer> goal = new ArrayList<>(3);
        goal.add(1);
        goal.add(2);
        goal.add(3);
        MatcherAssert.assertThat(
                new EqualSolution<>(new DefaultIndividual<>(goal)).score(goal),
                Matchers.is(3)
        );
    }
}