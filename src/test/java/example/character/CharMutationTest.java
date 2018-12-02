package example.character;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public class CharMutationTest {
    @Test
    public void fullMutation() {
        final List<Character> genes = new ArrayList<>(3);
        genes.add('1');
        genes.add('2');
        genes.add('3');
        MatcherAssert.assertThat(
                new CharMutation(
                        0.99, new Random(), "abc"
                ).genes(genes).toArray(new Character[3]),
                Matchers.not(new Character[]{'a', 'b', 'c'})
        );
    }
}