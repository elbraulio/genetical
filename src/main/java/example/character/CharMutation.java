package example.character;

import com.elbraulio.genetical.Mutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class CharMutation implements Mutation<Character> {
    private final double threshold;
    private final Random random;
    private final String alphabet;

    public CharMutation(double threshold, Random random, String alphabet) {
        this.threshold = threshold;
        this.random = random;
        this.alphabet = alphabet;
    }

    @Override
    public List<Character> genes(List<Character> origin) {
        if (this.threshold >= 1)
            throw new IllegalArgumentException(
                    "mutation threshold must be in range [0, 1)"
            );
        final List<Character> mutation = new ArrayList<>(origin.size());
        for (Character gene : origin) {
            if (this.threshold < Math.random()) {
                mutation.add(
                        this.alphabet.charAt(
                                this.random.nextInt(this.alphabet.length())
                        )
                );
            } else {
                mutation.add(gene);
            }
        }
        return mutation;
    }
}
