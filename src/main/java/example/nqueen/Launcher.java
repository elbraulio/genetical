package example.nqueen;

import com.elbraulio.genetical.*;
import com.elbraulio.genetical.crosses.RandomCross;
import com.elbraulio.genetical.evolution.FittestEvolve;
import com.elbraulio.genetical.fittestseleccion.FittestByScore;
import com.elbraulio.genetical.fittestseleccion.SubsetOf;
import com.elbraulio.genetical.genoseed.IntSeed;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.mutation.IntMutation;
import com.elbraulio.genetical.population.DefaultPopulation;

import java.util.*;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class Launcher {
    public static void main(String[] args) {
        final int populationSize = 1000;
        final int tournamentSize = 10;
        final int n = 20;
        if(!existSolution(n)) {
            System.out.println("Solution does not exist for N = " + n);
            System.exit(0);
        }
        final Random randomness = new Random();
        final Crosses<Integer> crosses = new RandomCross<>(0d);
        final Mutation<Integer> mutation = new IntMutation(
                0.2, randomness, n
        );
        final GenotypeSeed<Integer> boardSeed = new IntSeed(n, randomness);
        final CheckSolution<Integer> boardSolution = new BoardSolution();
        final FittestSelection<Integer> fittestSelection =
                new FittestByScore<>(boardSolution);
        final FittestSelection<Integer> tournament = new SubsetOf<>(
                tournamentSize,
                fittestSelection
        );
        final List<Population<Integer>> offspring = new LinkedList<>();
        final List<Individual<Integer>> individuals =
                new ArrayList<>(populationSize);
        for (int i = 0; i < populationSize; i++) {
            individuals.add(
                    new DefaultIndividual<>(
                            boardSeed.genes()
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
                                    tournament,
                                    crosses,
                                    mutation
                            )
                    )
            );
            System.out.println(
                    "Fittest individual from offspring " + offspring.size()
            );
            printBoard(
                    n,
                    offspring.get(offspring.size() - 1).fittest(fittestSelection)
            );
        }
        System.out.println(
                "Solution found after " + offspring.size() + " " + "offspring"
        );
        printBoard(
                n,
                offspring.get(offspring.size() - 1).fittest(fittestSelection)
        );
    }

    private static boolean existSolution(int n) {
        return new NQueenProblem(n).solveNQ();
    }

    private static void printBoard(int boardSize,
                                   Individual<Integer> individual
    ) {
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            board[individual.genes().get(i)][i] = 1;
        }
        System.out.println("------------");
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------");
    }
}
