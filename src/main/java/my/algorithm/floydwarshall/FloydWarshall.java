package my.algorithm.floydwarshall;

import my.algorithm.Vertex;
import my.algorithm.VertexConnection;

import java.util.List;

public class FloydWarshall {

    public FloydWarshallResult calculate(List<Vertex> vetexes) {
        int[][] distance = new int[vetexes.size()][vetexes.size()];
        int[][] pred = new int[vetexes.size()][vetexes.size()];
        for ( int from = 0 ; from < vetexes.size() ; from ++ ) {
            for ( int to = 0 ; to < vetexes.size() ; to ++ ) {
                distance[from][to] = Integer.MAX_VALUE;
                pred[from][to] = -1;
            }
            distance[from][from] = 0;

            Vertex fromVertex = vetexes.get(from);
            for ( VertexConnection connection : fromVertex.getConnections() ) {
                int to = connection.getToVertex().getNumber();
                distance[from][to] = connection.getWeight();
                pred[from][to] = from;
            }
        }

        for ( int inter  = 0 ; inter < vetexes.size() ; inter ++ ) {
            for ( int from = 0 ; from < vetexes.size() ; from ++ ) {
                for ( int to = 0 ; to < vetexes.size() ; to ++ ) {
                    long newDist = (long) distance[from][inter] + (long) distance[inter][to];

                    boolean shorterPathFound = (long) newDist < (long) distance[from][to];
                    if ( shorterPathFound ) {
                        distance[from][to] = (int) newDist;
                        pred[from][to] = pred[inter][to];
                    }
                }
            }
        }

        return new FloydWarshallResult(distance, pred);
    }

}
