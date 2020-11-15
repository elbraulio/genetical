package com.elbraulio.genetical.experiment;

import com.elbraulio.genetical.*;
import com.elbraulio.genetical.evolution.FittestEvolve;
import com.elbraulio.genetical.fittestseleccion.SubsetOf;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class DefaultExperiment<T> {

    private final CheckSolution<T> solution;
    private final FittestSelection<T> fittestSelection;
    private final Crosses<T> crosses;
    private final Mutation<T> mutation;
    private final PrintSolution<T> printSolution;
    private final Logger logger = Logger.getLogger(DefaultExperiment.class);

    public DefaultExperiment(
            CheckSolution<T> solution, FittestSelection<T> fittestSelection,
            Crosses<T> crosses, Mutation<T> mutation,
            PrintSolution<T> printSolution
    ) {
        this.solution = solution;
        this.fittestSelection = fittestSelection;
        this.crosses = crosses;
        this.mutation = mutation;
        this.printSolution = printSolution;
    }

    public void run(int tournamentSize, int minScore, Population<T> startPop) {
        final List<Number> scoreAverage = new LinkedList<>();
        final List<Number> fittestScore = new LinkedList<>();
        final List<Population<T>> offspring = new LinkedList<>();
        offspring.add(startPop);
        Map<String, Number> score = offspring.get(offspring.size() - 1).scores(this.solution);
        double maxScore;
        while ((maxScore = findMax(score)) < minScore) {
            scoreAverage.add(scoreAverage(score));
            fittestScore.add(maxScore);
            offspring.add(
                    offspring.get(offspring.size() - 1).evolve(
                            new FittestEvolve<>(
                                    new SubsetOf<>(
                                            tournamentSize,
                                            fittestSelection
                                    ),
                                    this.crosses,
                                    this.mutation
                            )
                    )
            );
            String fittest = fittestId(score);
            this.printSolution.print(offspring.get(offspring.size() - 1).individuals().stream()
                    .filter(i -> i.id().equals(fittest))
                    .limit(1)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("Individual must be found")));
            score = offspring.get(offspring.size() - 1).scores(this.solution);
        }
        scoreAverage.add(scoreAverage(score));
        fittestScore.add(maxScore);
        this.logger.info(
                "Solution found after " + offspring.size() + " " +
                        "offspring"
        );
        this.printSolution.print(
                offspring.get(offspring.size() - 1).fittest(
                        this.fittestSelection
                )
        );
        new PrecisionChart(
                scoreAverage.toArray(new Number[0]),
                "Score average by offspring.\nScore accepted as fittest = " + minScore,
                minScore

        ).show();
        new PrecisionChart(
                fittestScore.toArray(new Number[0]),
                "Fittest score by offspring.\nScore accepted as fittest = " + minScore,
                minScore
        ).show();
    }

    private String fittestId(Map<String, Number> score) {
        return score.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().doubleValue()))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    private double findMax(Map<String, Number> score) {
        return score.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().doubleValue()))
                .map(e -> e.getValue().doubleValue())
                .orElse(0d);
    }

    /**
     * calculate score average for a given Population
     *
     * @return score average
     */
    private Number scoreAverage(Map<String, Number> score) {
        return score.values().stream()
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(0d);
    }
}
