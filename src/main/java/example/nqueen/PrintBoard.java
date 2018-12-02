package example.nqueen;

import com.elbraulio.genetical.Individual;
import com.elbraulio.genetical.PrintSolution;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class PrintBoard implements PrintSolution<Integer> {

    private final int boardSize;
    private final Logger logger = Logger.getLogger(PrintBoard.class);

    public PrintBoard(int boardSize) {

        this.boardSize = boardSize;
    }

    @Override
    public void print(Individual<Integer> individual) {
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
