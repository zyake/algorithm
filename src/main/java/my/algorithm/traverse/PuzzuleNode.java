package my.algorithm.traverse;

import sun.management.snmp.jvmmib.EnumJvmMemPoolType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzuleNode implements Node {

    public static final int EMPTY = -1;

    private int currentDepth;

    private int score;

    private PuzzuleNode prevStep;

    private int[][] puzzuleBoard;

    private int emptyIndexX;

    private int emptyIndexY;

    public PuzzuleNode(int[][] puzzuleBoard, int emptyIndexX, int emptyIndexY, int currentDepth) {
        this(puzzuleBoard, emptyIndexX, emptyIndexY, currentDepth, null);
    }

    public PuzzuleNode(int[][] puzzuleBoard, int emptyIndexX, int emptyIndexY, int currentDepth, PuzzuleNode prevStep) {
        this.puzzuleBoard = puzzuleBoard;
        this.emptyIndexX = emptyIndexX;
        this.emptyIndexY = emptyIndexY;
        this.currentDepth = currentDepth;
        this.prevStep = prevStep;
    }

    public PuzzuleNode(int[][] puzzuleBoard, int emptyIndexX, int emptyIndexY) {
        this(puzzuleBoard, emptyIndexX, emptyIndexY, 0, null);
    }

    @Override
    public int currentDepth() {
        return currentDepth;
    }

    @Override
    public List<Node> nextSteps() {
        List<Node> nextSteps = new ArrayList<>();

        int right = emptyIndexX + 1;
        boolean canMoveRight = puzzuleBoard.length > right;
        if ( canMoveRight ) {
            int[][] newBoard = copyBoard();
            newBoard[emptyIndexX][emptyIndexY] = newBoard[right][emptyIndexY];
            newBoard[right][emptyIndexY] = EMPTY;
            Node newNode = new PuzzuleNode(newBoard, right, emptyIndexY, currentDepth + 1, this);
            nextSteps.add(newNode);
        }

        int left = emptyIndexX - 1;
        boolean canMoveLeft = left > -1;
        if ( canMoveLeft ) {
            int[][] newBoard = copyBoard();
            newBoard[emptyIndexX][emptyIndexY] = newBoard[left][emptyIndexY];
            newBoard[left][emptyIndexY] = EMPTY;
            Node newNode = new PuzzuleNode(newBoard, left, emptyIndexY, currentDepth + 1,this);
            nextSteps.add(newNode);
        }

        int up = emptyIndexY + 1;
        boolean canMoveUp = puzzuleBoard[0].length > up;
        if ( canMoveUp ) {
            int[][] newBoard = copyBoard();
            newBoard[emptyIndexX][emptyIndexY] = newBoard[emptyIndexX][up];
            newBoard[emptyIndexX][up] = EMPTY;
            Node newNode = new PuzzuleNode(newBoard, emptyIndexX, up, currentDepth + 1,this);
            nextSteps.add(newNode);
        }

        int down = emptyIndexY - 1;
        boolean canMoveDown = down > -1;
        if ( canMoveDown ) {
            int[][] newBoard = copyBoard();
            newBoard[emptyIndexX][emptyIndexY] = newBoard[emptyIndexX][down];
            newBoard[emptyIndexX][down] = EMPTY;
            Node newNode = new PuzzuleNode(newBoard, emptyIndexX, down, currentDepth + 1,this);
            nextSteps.add(newNode);
        }

        return nextSteps;
    }

    private int[][] copyBoard() {
        int[][] newBoard = new int[puzzuleBoard.length][puzzuleBoard[0].length];
        for ( int i = 0 ; i < newBoard.length ; i ++ ) {
            int[] copiedLine = Arrays.copyOf(puzzuleBoard[i], puzzuleBoard[i].length);
            newBoard[i] = copiedLine;
        }

        return newBoard;
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
    public int hashCode() {
        return Arrays.deepHashCode(puzzuleBoard);
    }

    @Override
    public boolean equals(Object o) {
        boolean isNotPuzzuleNode = ! (o instanceof PuzzuleNode);
        if ( isNotPuzzuleNode ) {
            throw new RuntimeException("パズルノードではありません。");
        }

        PuzzuleNode puzzuleNode = (PuzzuleNode) o;
        return Arrays.deepEquals(this.puzzuleBoard, puzzuleNode.puzzuleBoard);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for ( int i = 0 ; i < puzzuleBoard.length ; i ++ ) {
            builder.append(Arrays.toString(puzzuleBoard[i]));
        }
        return builder.toString();
    }

    public int[][] getPuzzuleBoard() {
        return puzzuleBoard;
    }
}
