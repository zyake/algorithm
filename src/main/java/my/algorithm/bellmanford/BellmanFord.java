package my.algorithm.bellmanford;

import my.algorithm.VertexConnection;
import my.algorithm.Vertex;

import java.util.List;

public class BellmanFord {

    public void calclate(List<Vertex> vertexes) {
        for ( int i = 0 ; i < vertexes.size() ; i ++ ) {
            for ( int j  = 0 ; j < vertexes.size() ; j ++ ) {
                for (VertexConnection vConnect : vertexes.get(j).getConnections() ) {
                    Vertex fromVertex = vConnect.getFromVertex();
                    Vertex toVertex = vConnect.getToVertex();
                    // 気をつけろ、オーバーフローするぞ!
                    long newDist = (long) fromVertex.getDistance() + (long) vConnect.getWeight();
                    boolean updateRequired = newDist < (long) toVertex.getDistance();
                    if ( updateRequired ) {
                        toVertex.setDistance((int) newDist);
                        toVertex.setPrev(fromVertex.getNumber());
                    }
                }
            }
        }
    }
}
