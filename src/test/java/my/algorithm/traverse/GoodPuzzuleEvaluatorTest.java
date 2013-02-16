package my.algorithm.traverse;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GoodPuzzuleEvaluatorTest {

    @Test
         public void testEvaluate() throws Exception {
        int[][] targetBoard = {
                {1, 2, 3},
                {8, PuzzuleNode.EMPTY, 4},
                {7, 6, 5}
        };
        PuzzuleNode target = new PuzzuleNode(targetBoard, 1, 1);

        int[][] currentBoard = {
                {1, 4, 8},
                {7, 3, PuzzuleNode.EMPTY},
                {6, 5, 2}
        };
        PuzzuleNode current = new PuzzuleNode(currentBoard, 1, 2);

        int result = new GoodPuzzuleEvaluator().evaluate(target, current);

        assertThat(result, is(46));
    }

    @Test
    public void testManhattan() throws Exception {
        int[][] targetBoard = {
                {1, 2, 3},
                {8, PuzzuleNode.EMPTY, 4},
                {7, 6, 5}
        };
        PuzzuleNode target = new PuzzuleNode(targetBoard, 1, 1);

        int[][] currentBoard = {
                {1, 4, 8},
                {7, 3, PuzzuleNode.EMPTY},
                {6, 5, 2}
        };
        PuzzuleNode current = new PuzzuleNode(currentBoard, 1, 2);

        int result = new GoodPuzzuleEvaluator().calcManhattan(target, current);

        assertThat(result, is(13));
    }

    @Test
    public void testMovePoint() throws Exception {
        int[][] targetBoard = {
                {1, 2, 3},
                {8, PuzzuleNode.EMPTY, 4},
                {7, 6, 5}
        };
        PuzzuleNode target = new PuzzuleNode(targetBoard, 1, 1);

        int[][] currentBoard = {
                {1, 4, 8},
                {7, 3, PuzzuleNode.EMPTY},
                {6, 5, 2}
        };
        PuzzuleNode current = new PuzzuleNode(currentBoard, 1, 2);

        int result = new GoodPuzzuleEvaluator().calcMovePoint(target, current);

        assertThat(result, is(11));
    }
}
