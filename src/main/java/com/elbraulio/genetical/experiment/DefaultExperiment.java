package com.elbraulio.genetical.experiment;

import com.elbraulio.genetical.*;
import com.elbraulio.genetical.evolution.FittestEvolve;
import com.elbraulio.genetical.fittestseleccion.SubsetOf;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class DefaultExperiment<T> implements Experiment<T> {

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

    @Override
    public void run(int tournamentSize, int minScore, Population<T> startPop) {
        final List<Number> scoreAverage = new LinkedList<>();
        final List<Number> fittestScore = new LinkedList<>();
        final List<Population<T>> offspring = new LinkedList<>();
        offspring.add(startPop);
        Number[] score =
                offspring.get(offspring.size() - 1).scores(this.solution);
        double maxScore = 0d;
        while (
                (maxScore = findMax(score)) < minScore
        ) {
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
            this.printSolution.print(
                    offspring.get(offspring.size() - 1).individuals()
                            .get(fittestIndex(score))
            );
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
                scoreAverage.toArray(new Number[scoreAverage.size()]),
                "Score average by offspring.\nScore accepted as fittest = " + minScore,
                minScore

        ).show();
        new PrecisionChart(
                fittestScore.toArray(new Number[fittestScore.size()]),
                "Fittest score by offspring.\nScore accepted as fittest = " + minScore,
                minScore
        ).show();
    }

    private int fittestIndex(Number[] score) {
        int max = 0;
        for (int i = 0; i < score.length; i++) {
            max = score[max].doubleValue() > score[i].doubleValue() ? max : i;
        }
        return max;
    }

    private double findMax(Number[] score) {
        double max = 0;
        for (int i = 0; i < score.length; i++) {
            max = score[i].doubleValue() > max ? score[i].doubleValue() : max;
        }
        return max;
    }

    /**
     * calculate score average for a given Population
     *
     * @return score average
     */
    private Number scoreAverage(Number[] score) {
        double average = 0d;
        for (int i = 0; i < score.length; i++) {
            average += score[i].doubleValue();
        }
        return average / score.length;
    }
}
