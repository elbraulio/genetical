package com.elbraulio.genetical.experiment;

import com.elbraulio.genetical.*;
import com.elbraulio.genetical.evolution.FittestEvolve;
import com.elbraulio.genetical.fittestseleccion.SubsetOf;
import com.elbraulio.genetical.PrintSolution;
import org.apache.log4j.Logger;

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
        final List<Population<T>> offspring = new LinkedList<>();
        offspring.add(startPop);
        while (
                this.solution.score(
                        offspring.get(offspring.size() - 1).fittest(
                                this.fittestSelection
                        ).genes()
                ) < minScore
        ) {
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
            this.logger.info(
                    "Fittest individual from offspring " + offspring.size()
            );
            this.printSolution.print(
                    offspring.get(offspring.size() - 1).fittest(
                            this.fittestSelection
                    )
            );
        }
        this.logger.info(
                "Solution found after " + offspring.size() + " " +
                        "offspring"
        );
        this.printSolution.print(
                offspring.get(offspring.size() - 1).fittest(
                        this.fittestSelection
                )
        );
    }
}
