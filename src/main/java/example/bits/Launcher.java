package example.bits;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.GenotypeSeed;
import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.crosses.RandomCross;
import com.elbraulio.genetical.experiment.DefaultExperiment;
import com.elbraulio.genetical.fittestseleccion.FittestTwin;
import com.elbraulio.genetical.genoseed.IntSeed;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.mutation.IntMutation;
import com.elbraulio.genetical.population.DefaultPopulation;
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
        final int popSize = 10;
        // tournament size
        final int tournamentSize = 10;
        // bit chain size
        final int bits = 7;
        // probability for an individual to leave inheritance by gene
        final double crossThreshold = 0.5;
        // probability to have a mutation by gene
        final double mutationThreshold = 0.2;
        // ##################################
        // ##################################
        // seed to build first population
        final GenotypeSeed<Integer> seed = new IntSeed(2, new Random());
        // the individual we are looking for
        final Individual<Integer> goal =
                new DefaultIndividual<>(seed.genes(bits));
        logger.info("Goal individual genes : " + goal.genes().toString());
        // build first population
        final List<Individual<Integer>> individuals = new ArrayList<>(popSize);
        for (int i = 0; i < popSize; i++) {
            individuals.add(new DefaultIndividual<>(seed.genes(bits)));
        }
        // check solution
        final CheckSolution<Integer> boardSolution = new EqualSolution<>(goal);
        // run experiment
        new DefaultExperiment<>(
                boardSolution,
                new FittestTwin<>(goal.genes()),
                new RandomCross<>(crossThreshold),
                new IntMutation(mutationThreshold, new Random(), 2),
                new PrintList<>()
        ).run(
                tournamentSize, bits, new DefaultPopulation<>(individuals)
        );
    }
}
