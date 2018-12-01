package example.nqueen;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class BoardSolutionTest {
    @Test
    public void fourSquareSolution(){
        final List<Integer> genes = new ArrayList<>(4);
        genes.add(1);
        genes.add(3);
        genes.add(0);
        genes.add(2);
        MatcherAssert.assertThat(
                new BoardSolution().score(genes), Matchers.is(4)
        );
    }

    @Test
    public void oneSquareTwoScore(){
        final List<Integer> genes = new ArrayList<>(4);
        genes.add(1);
        genes.add(3);
        genes.add(2);
        genes.add(2);
        MatcherAssert.assertThat(
                new BoardSolution().score(genes), Matchers.is(1)
        );
    }
}