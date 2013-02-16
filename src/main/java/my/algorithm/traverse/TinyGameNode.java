package my.algorithm.traverse;

import java.util.Arrays;
import java.util.List;

public class TinyGameNode implements Node {

    private int left;

    private int right;

    private Node prevStep;

    private int currentDepth;

    private int score;

    public TinyGameNode(int left, int right) {
        this(left, right, 0, null);
    }

    public TinyGameNode(int left, int right, int currentDepth) {
        this(left, right, currentDepth, null);
    }

    public TinyGameNode(int left, int right,int currentDepth, Node prevStep) {
        this.left = left;
        this.right = right;
        this.currentDepth = currentDepth;
        this.prevStep = prevStep;
    }

    @Override
    public int currentDepth() {
        return currentDepth;
    }

    @Override
    public List<Node> nextSteps() {
        List nextNodes = Arrays.asList(
                new TinyGameNode(left + 1, right, currentDepth +1, this),
                new TinyGameNode(left, right + 1, currentDepth + 1, this));

        return nextNodes;
    }

    @Override
    public int hashCode() {
        return left^4 + right;
    }

    @Override
    public boolean equals(Object o) {
        boolean isNotTarget = ! (o instanceof TinyGameNode);
        if ( isNotTarget ) {
            throw new RuntimeException("比較不能なオブジェクトが渡されました: " + o);
        }

        TinyGameNode node = (TinyGameNode) o;
        boolean isMatched = left == node.left && right == node.right;

        return isMatched;
    }

    @Override
    public Node getPrevStep() {
        return prevStep;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "{left=" + left + ", right=" + right +"}";
    }
}
