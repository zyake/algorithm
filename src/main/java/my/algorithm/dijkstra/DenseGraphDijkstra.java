package my.algorithm.dijkstra;

import my.algorithm.VertexConnection;
import my.algorithm.Vertex;

import java.util.List;

public class DenseGraphDijkstra implements Dijkstra {

    @Override
    public void calculate(List<Vertex> vertexes) {
        while ( true ) {
            Vertex target = null;
            int dist = Integer.MAX_VALUE;
            for ( Vertex v : vertexes ) {
                if ( v.isVisited() ) {
                    continue;
                }

                boolean isCandidate = dist > v.getDistance();
                if ( isCandidate ) {
                    dist = v.getDistance();
                    target = v;
                }
            }

            boolean completed = target == null;
            if ( completed ) {
                return;
            }

            target.setVisited(true);

            for ( VertexConnection vConnect : target.getConnections() ) {
                int newDist = target.getDistance() + vConnect.getWeight();
                Vertex toVertex = vConnect.getToVertex();

                boolean shorterPathFound = newDist < toVertex.getDistance();
                if ( shorterPathFound ) {
                    toVertex.setDistance(newDist);
                    toVertex.setPrev(target.getNumber());
                }
            }
        }
    }
}
