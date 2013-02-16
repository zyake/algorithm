package my.algorithm.traverse;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BreadthFirstSolutionFinderTest {

    @Test
    public void testFindSolution_normal_oneDiff() throws Exception {
        Node initNode = new TinyGameNode(0, 0, 0);
        Node targetNode = new TinyGameNode(1, 0, 0);

        Solution solution = new BreadthFirstSolutionFinder().findSolution(initNode, targetNode);

        assertThat(solution.getPath().toString(),
                is("[{left=1, right=0}, {left=0, right=0}]"));
    }

    @Test
    public void testFindSolution_normal_threeDiff() throws Exception {
        Node initNode = new TinyGameNode(0, 0);
        Node targetNode = new TinyGameNode(1, 2);

        Solution solution = new BreadthFirstSolutionFinder().findSolution(initNode, targetNode);

        assertThat(solution.getPath().toString(),
                is("[{left=1, right=2}, {left=1, right=1}, {left=1, right=0}, {left=0, right=0}]"));
    }

    @Test
    public void testFindSolution_normal_same() throws Exception {
        Node initNode = new TinyGameNode(0, 0);
        Node targetNode = new TinyGameNode(0, 0);

        Solution solution = new BreadthFirstSolutionFinder().findSolution(initNode, targetNode);

        assertThat(solution.getPath().toString(),
                is("[{left=0, right=0}]"));
    }
}
