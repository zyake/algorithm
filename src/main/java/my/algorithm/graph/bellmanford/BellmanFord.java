package my.algorithm.graph.bellmanford;

import my.algorithm.graph.VertexConnection;
import my.algorithm.graph.Vertex;

import java.util.List;

public class BellmanFord {

    public void calclate(List<Vertex> vertices) {
        for ( int i = 0 ; i < vertices.size() ; i ++ ) {
            for ( int j  = 0 ; j < vertices.size() ; j ++ ) {
                for (VertexConnection vConnect : vertices.get(j).getConnections() ) {
                    Vertex fromVertex = vConnect.getFromVertex();
                    Vertex toVertex = vConnect.getToVertex();

                    // 気をつけろ、オーバーフローするぞ!
                    long newDist = (long) fromVertex.getDistance() + (long) vConnect.getWeight();
                    boolean shorterPathFound = newDist < (long) toVertex.getDistance();
                    if ( shorterPathFound ) {
                        toVertex.setDistance((int) newDist);
                        toVertex.setPrev(fromVertex.getNumber());
                    }
                }
            }
        }
    }
}
