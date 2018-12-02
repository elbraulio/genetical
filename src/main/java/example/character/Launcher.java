package example.character;

import com.elbraulio.genetical.CheckSolution;
import com.elbraulio.genetical.GenotypeSeed;
import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.crosses.RandomCross;
import com.elbraulio.genetical.experiment.DefaultExperiment;
import com.elbraulio.genetical.fittestseleccion.FittestTwin;
import com.elbraulio.genetical.individual.DefaultIndividual;
import com.elbraulio.genetical.population.DefaultPopulation;
import example.bits.EqualSolution;
import example.bits.PrintList;
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
        final int chars = 3;
        // probability for an individual to leave inheritance by gene
        final double crossThreshold = 0.5;
        // probability to have a mutation by gene
        final double mutationThreshold = 0.1;
        // alphabet of possible genes
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // ##################################
        // ##################################
        // seed to build first population
        final GenotypeSeed<Character> seed = new CharSeed(new Random(), alphabet);
        // the individual we are looking for
        final Individual<Character> goal =
                new DefaultIndividual<>(seed.genes(chars));
        logger.info("Goal individual genes : " + goal.genes().toString());
        // build first population
        final List<Individual<Character>> individuals = new ArrayList<>(popSize);
        for (int i = 0; i < popSize; i++) {
            individuals.add(new DefaultIndividual<>(seed.genes(chars)));
        }
        // check solution
        final CheckSolution<Character> boardSolution = new EqualSolution<>(goal);
        // run experiment
        new DefaultExperiment<>(
                boardSolution,
                new FittestTwin<>(goal.genes()),
                new RandomCross<>(crossThreshold),
                new CharMutation(mutationThreshold, new Random(), alphabet),
                new PrintList<>()
        ).run(
                tournamentSize, chars, new DefaultPopulation<>(individuals)
        );
    }
}
