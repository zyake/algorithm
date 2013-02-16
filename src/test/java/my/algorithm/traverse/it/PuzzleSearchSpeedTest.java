package my.algorithm.traverse.it;

import my.algorithm.IT;
import my.algorithm.traverse.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@Category(IT.class)
@RunWith(Parameterized.class)
public class PuzzleSearchSpeedTest {

    private SolutionFinder finder;

    public PuzzleSearchSpeedTest(SolutionFinder finder) {
        this.finder = finder;
    }

    @Test
    public void testSpeed_15puzzule() {
        int[][] board = {
                { 2, 10, 8, 3 },
                { 1, 6, PuzzuleNode.EMPTY, 4},
                { 5, 9, 7, 11 },
                { 13, 14, 15, 12 }
        };
        Node init = new PuzzuleNode(board, 1, 2);

        int[][] targetBoard = {
                { 1, 2, 3 , 4},
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, PuzzuleNode.EMPTY }
        };
        Node target = new PuzzuleNode(targetBoard, 3, 3);

        Date start = new Date();
        Solution solution = finder.findSolution(init, target);
        long end = new Date().getTime() - start.getTime();
        System.out.println(finder.getClass().getName() + ", time=" + end + ", solution=" + solution);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> createFinders() {
        Collection<Object[]> finders = Arrays.asList(
                new Object[]{new DepthFirstSolutionFinder(15)},
                new Object[]{new BreadthFirstSolutionFinder()},
                new Object[]{new AStartSolutionFinder<>(new GoodPuzzuleEvaluator())});

        return finders;
    }
}
