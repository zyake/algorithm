package my.algorithm.traverse;

import java.util.Arrays;

public class GoodPuzzuleEvaluator implements NodeEvaluator<PuzzuleNode> {

    @Override
    public int evaluate(PuzzuleNode target, PuzzuleNode current) {
        int manhattan = calcManhattan(target, current);
        int movePoint = calcMovePoint(target, current);

        return manhattan + movePoint * 3;
    }

    protected int calcMovePoint(PuzzuleNode target, PuzzuleNode current) {
        int movePoint = 0;
        int[][] targetBoard = target.getPuzzuleBoard();
        int[][] currentBoard = current.getPuzzuleBoard();
        for ( int x = 0 ; x < targetBoard.length ; x ++ ) {
            for ( int y = 0 ; y < targetBoard[0].length ; y ++ ) {
                movePoint += calcPoint(targetBoard, currentBoard, x, y);
            }
        }

        return movePoint;
    }

    private int calcPoint(int[][] targetBoard, int[][] currentBoard, int x, int y) {
        boolean isEmpty = currentBoard[x][y] == PuzzuleNode.EMPTY;
        if ( isEmpty ) {
           return 0;
        }

        boolean isCenter = currentBoard.length / 2 == x && currentBoard[0].length / 2 == y;
        if ( isCenter ) {
            return 1;
        }

        boolean canLeft = x - 1 > -1;
        if ( canLeft ) {
            boolean isMatched = currentBoard[x - 1][y] == targetBoard[x - 1][y];
            if ( isMatched ) {
                return 0;
            }
        }

        boolean canRight = targetBoard.length > x + 1;
        if ( canRight ) {
            boolean isMatched = currentBoard[x + 1][y] == targetBoard[x + 1][y];
            if ( isMatched ) {
                return 0;
            }
        }

        boolean canUp = targetBoard[0].length > y + 1;
        if ( canUp ) {
            boolean isMatched = currentBoard[x][y + 1] == targetBoard[x][y + 1];
            if ( isMatched ) {
                return 0;
            }
        }

        boolean canDown = y - 1 > -1;
        if ( canDown ) {
            boolean isMatched = currentBoard[x][y - 1] == targetBoard[x][y - 1];
            if ( isMatched ) {
                return 0;
            }
        }

        return 2;
    }

    protected int calcManhattan(PuzzuleNode target, PuzzuleNode current) {
        int distance = 0;
        int[][] targetBoard = target.getPuzzuleBoard();
        int[][] currentBoard = current.getPuzzuleBoard();
        for ( int x = 0 ; x < targetBoard.length ; x ++ ) {
            for ( int y = 0 ; y < targetBoard[0].length ; y ++ ) {
                int targetValue = targetBoard[x][y];
                if ( PuzzuleNode.EMPTY == targetValue ) {
                    continue;
                }

                int dist = calcDistance(targetValue, x, y, currentBoard);
                distance += dist;
            }
        }

        return distance;
    }

    private int calcDistance(int targetValue, int initX, int initY, int[][] currentBoard) {
        for ( int x = 0 ; x < currentBoard.length ; x ++ ) {
            for ( int y = 0 ; y < currentBoard[0].length ; y ++ ) {
                int currentValue = currentBoard[x][y];
                boolean isMatched = currentValue == targetValue;
                if ( isMatched ) {
                    return Math.abs( x - initX ) + Math.abs( y - initY );
                }
            }
        }

        throw new RuntimeException("値が見つかりませんでした: value=" + targetValue + ", board=" + Arrays.toString(currentBoard));
    }
}
