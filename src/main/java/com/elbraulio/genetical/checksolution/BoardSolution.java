package com.elbraulio.genetical.checksolution;

import com.elbraulio.genetical.CheckSolution;

import java.util.List;

/**
 * @author Braulio Lopez (brauliop.3@gmail.com)
 */
public final class BoardSolution implements CheckSolution<Integer> {
    @Override
    public int score(List<Integer> genes) {
        int score = 0;
        for (int i = 0; i < genes.size(); i++) {
            if (isClean(genes, i)) {
                score++;
            }
        }
        return score;
    }

    private boolean isClean(List<Integer> genes, int index) {

        for (int i = 0; i < index; i++) {
            if (genes.get(i).equals(genes.get(index))) {
                return false;
            }
        }

        for (int i = index + 1; i < genes.size(); i++) {
            if (genes.get(i).equals(genes.get(index))) {
                return false;
            }
        }

        for (int i = 0; i < index; i++) {
            if (genes.get(i).equals(genes.get(index) + (index - i))) {
                return false;
            }
        }

        for (int i = index + 1; i < genes.size(); i++) {
            if (genes.get(i).equals(genes.get(index) + (i - index))) {
                return false;
            }
        }

        for (int i = 0; i < index; i++) {
            if (genes.get(i).equals(genes.get(index) - (index - i))) {
                return false;
            }
        }

        for (int i = index + 1; i < genes.size(); i++) {
            if (genes.get(i).equals(genes.get(index) - (i - index))) {
                return false;
            }
        }

        return true;
    }
}
