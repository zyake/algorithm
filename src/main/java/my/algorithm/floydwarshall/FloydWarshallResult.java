package my.algorithm.floydwarshall;

public class FloydWarshallResult {

    private int[][] distance;

    private int[][] pred;

    public FloydWarshallResult(int[][] distance, int[][] pred) {
        this.distance = distance;
        this.pred = pred;
    }

    public int[][] getDistance() {
        return distance;
    }

    public int[][] getPred() {
        return pred;
    }
}
