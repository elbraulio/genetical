package example.nqueen;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.FittestSelection;
import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.Population;
import com.elbraulio.genetical.crosses.RandomCross;
import com.elbraulio.genetical.evolution.FittestEvolve;
import com.elbraulio.genetical.fittestseleccion.FittestByScore;
import com.elbraulio.genetical.fittestseleccion.SubsetOf;
import com.elbraulio.genetical.genoseed.IntSeed;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.mutation.IntMutation;
import com.elbraulio.genetical.population.DefaultPopulation;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class Launcher {

    private static final Logger logger = Logger.getLogger(Launcher.class);

    public static void main(String[] args) {
        final int populationSize = 1000;
        final int tournamentSize = 10;
        final int n = 4;
        final Random randomness = new Random();
        final CheckSolution<Integer> boardSolution = new BoardSolution();
        final FittestSelection<Integer> fittestSelection =
                new FittestByScore<>(boardSolution);
        final List<Population<Integer>> offspring = new LinkedList<>();
        final List<Individual<Integer>> individuals =
                new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            individuals.add(
                    new DefaultIndividual<>(
                            new IntSeed(n, randomness).genes()
                    )
            );
        }
        offspring.add(new DefaultPopulation<>(individuals));
        while (
                boardSolution.score(offspring.get(offspring.size() - 1).fittest(
                        fittestSelection
                ).genes()) != n
        ) {
            offspring.add(
                    offspring.get(offspring.size() - 1).evolve(
                            new FittestEvolve<>(
                                    new SubsetOf<>(
                                            tournamentSize,
                                            fittestSelection
                                    ),
                                    new RandomCross<>(0d),
                                    new IntMutation(
                                            0.2, randomness, n
                                    )
                            )
                    )
            );
            logger.info(
                    "Fittest individual from offspring " + offspring.size()
            );
            printBoard(
                    n,
                    offspring.get(offspring.size() - 1).fittest(fittestSelection)
            );
        }
        logger.info(
                "Solution found after " + offspring.size() + " " + "offspring"
        );
        printBoard(
                n,
                offspring.get(offspring.size() - 1).fittest(fittestSelection)
        );
    }

    private static void printBoard(int boardSize,
                                   Individual<Integer> individual
    ) {
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            board[individual.genes().get(i)][i] = 1;
        }
        logger.info("------------");
        for (int[] row : board) {
            logger.info(Arrays.toString(row));
        }
        logger.info("------------");
    }
}
