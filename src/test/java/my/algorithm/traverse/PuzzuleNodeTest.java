package my.algorithm.traverse;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PuzzuleNodeTest {

    @Test
         public void testNextSteps_normal_4direction() {
        int[][] ints = {
                {1, 2, 3},
                {4, PuzzuleNode.EMPTY, 6},
                {7, 8, 9}
        };

        List<Node> nextSteps = new PuzzuleNode(ints, 1, 1).nextSteps();

        assertThat(nextSteps.toString(),
                is("[[1, 2, 3][4, 8, 6][7, -1, 9], [1, -1, 3][4, 2, 6][7, 8, 9], [1, 2, 3][4, 6, -1][7, 8, 9], [1, 2, 3][-1, 4, 6][7, 8, 9]]"));
    }

    @Test
    public void testNextSteps_normal_3direction() {
        int[][] ints = {
                {1, 2, 3},
                {4, 6, PuzzuleNode.EMPTY},
                {7, 8, 9}
        };

        List<Node> nextSteps = new PuzzuleNode(ints, 1, 2).nextSteps();

        assertThat(nextSteps.toString(),
                is("[[1, 2, 3][4, 6, 9][7, 8, -1], [1, 2, -1][4, 6, 3][7, 8, 9], [1, 2, 3][4, -1, 6][7, 8, 9]]"));
    }

    @Test
    public void testNextSteps_normal_topLeft() {
        int[][] ints = {
                {PuzzuleNode.EMPTY, 1, 2},
                {3, 4, 6},
                {7, 8, 9}
        };

        List<Node> nextSteps = new PuzzuleNode(ints, 0, 0).nextSteps();

        assertThat(nextSteps.toString(),
                is("[[3, 1, 2][-1, 4, 6][7, 8, 9], [1, -1, 2][3, 4, 6][7, 8, 9]]"));
    }

    @Test
    public void testNextSteps_normal_rightBottom() {
        int[][] ints = {
                {1, 2, 3},
                {4, 6, 7},
                {8, 9, PuzzuleNode.EMPTY}
        };

        List<Node> nextSteps = new PuzzuleNode(ints, 2, 2).nextSteps();

        assertThat(nextSteps.toString(),
                is("[[1, 2, 3][4, 6, -1][8, 9, 7], [1, 2, 3][4, 6, 7][8, -1, 9]]"));
    }

    @Test
    public void testCompareTo_normal_match() {
        int[][] ints = {
                {1, 2, 3},
                {4, 6, 7},
                {8, 9, PuzzuleNode.EMPTY}
        };

        Node node = new PuzzuleNode(ints, 2, 2);

        assertTrue(node.equals(node));
    }

    @Test
    public void testCompareTo_normal_notMatch() {
        int[][] ints = {
                {1, 2, 3},
                {4, 6, 7},
                {8, 9, PuzzuleNode.EMPTY}
        };
        Node node = new PuzzuleNode(ints, 2, 2);

        int[][] ints2 = {
                {2, 3, 3},
                {4, 6, 7},
                {8, 9, PuzzuleNode.EMPTY}
        };

        Node node2 = new PuzzuleNode(ints2, 2, 2);

        assertFalse(node.equals(node2));
    }

    @Test
    public void testHash() {
        int[][] ints = {
                {1, 2, 3},
                {4, 6, 7},
                {8, 9, PuzzuleNode.EMPTY}
        };
        Node node = new PuzzuleNode(ints, 2, 2);
        Set<Node> hashSet = new HashSet<>();
        hashSet.add(node);
        hashSet.add(node);
        Assert.assertTrue(hashSet.size()==1);
    }
}
