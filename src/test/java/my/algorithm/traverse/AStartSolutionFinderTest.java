package my.algorithm.traverse;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class AStartSolutionFinderTest {

    @Test
    public void testSpeed() {
        int[][] board = {
                { 8, 1, 3 },
                { PuzzuleNode.EMPTY, 4, 5 },
                { 2, 7, 6 }
        };
        PuzzuleNode init = new PuzzuleNode(board, 1, 0);

        int[][] targetBoard = {
                { 1, 2, 3 },
                { 8, PuzzuleNode.EMPTY, 4 },
                { 7, 6, 5 }
        };
        PuzzuleNode target = new PuzzuleNode(targetBoard, 1, 1);

        Solution solution = new AStartSolutionFinder<>(new GoodPuzzuleEvaluator()).findSolution(init, target);

        System.out.println(solution);
    }
}
