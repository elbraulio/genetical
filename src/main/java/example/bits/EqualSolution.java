package example.bits;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.Individual;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class EqualSolution<T> implements CheckSolution<T> {
    private final Individual<T> goal;

    public EqualSolution(Individual<T> goal) {

        this.goal = goal;
    }

    @Override
    public int score(List<T> genes) {
        int score = 0;
        for (int i = 0; i < genes.size(); i++) {
            if (genes.get(i).equals(this.goal.genes().get(i)))
                score++;
        }
        return score;
    }
}
