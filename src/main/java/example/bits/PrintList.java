package example.bits;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.PrintSolution;
import org.apache.log4j.Logger;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class PrintList<T> implements PrintSolution<T> {

    private final Logger logger = Logger.getLogger(PrintList.class);

    @Override
    public void print(Individual<T> individual) {
        this.logger.info(individual.genes().toString());
    }
}
