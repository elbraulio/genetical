package example.nqueen;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.GenotypeSeed;
import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.crosses.RandomCross;
import com.elbraulio.genetical.fittestseleccion.FittestByScore;
import com.elbraulio.genetical.genoseed.IntSeed;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.mutation.IntMutation;
import com.elbraulio.genetical.population.DefaultPopulation;
import com.elbraulio.genetical.experiment.DefaultExperiment;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class Launcher {

    private static final Logger logger = Logger.getLogger(Launcher.class);

    public static void main(String... args) {
        // ##################################
        // ############CONFIGURATION#########
        // ##################################
        // population size
        final int popSize = 1000;
        // tournament size
        final int tournamentSize = 10;
        // queens to place on board (board size)
        final int queens = 4;
        // probability for an individual to leave inheritance by gene
        final double crossThreshold = 0.5;
        // probability to have a mutation by gene
        final double mutationThreshold = 0.2;
        // ##################################
        // ##################################
        if (queens <= 3) {
            logger.error("Not supported for queens = " + queens);
            System.exit(1);
        }
        // seed to build first population
        final GenotypeSeed<Integer> seed = new IntSeed(queens, new Random());
        // build first population with a seed
        final List<Individual<Integer>> individuals = new ArrayList<>(popSize);
        for (int i = 0; i < popSize; i++) {
            individuals.add(new DefaultIndividual<>(seed.genes(queens)));
        }
        // check solution
        final CheckSolution<Integer> boardSolution = new BoardSolution();
        // run experiment
        new DefaultExperiment<>(
                boardSolution,
                new FittestByScore<>(boardSolution),
                new RandomCross<>(crossThreshold),
                new IntMutation(mutationThreshold, new Random(), queens),
                new PrintBoard(queens)
        ).run(
                tournamentSize, queens, new DefaultPopulation<>(individuals)
        );
    }
}
