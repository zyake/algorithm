package my.algorithm.prim;

import my.algorithm.Vertex;
import my.algorithm.VertexConnection;

import java.util.*;

public class Prim {

    private static final Comparator<Vertex> VERTEX_COMPARATOR = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return o1.getDistance() - o2.getDistance();
        }
    };

    void calculate(List<Vertex> vertices) {
        List<Vertex> unvisitVertices = new ArrayList<>();
        for ( Vertex vertex : vertices ) {
            unvisitVertices.add(vertex);
        }
        while ( ! unvisitVertices.isEmpty() ) {
            Collections.sort(unvisitVertices, VERTEX_COMPARATOR);
            Vertex target = unvisitVertices.remove(0);
            for (VertexConnection connection : target.getConnections() ) {
                Vertex toVertex = connection.getToVertex();
                boolean isAlreadyVisited = ! unvisitVertices.contains(toVertex);
                if ( isAlreadyVisited ) {
                    continue;
                }

                boolean smallerWeightFound = connection.getWeight() < toVertex.getDistance();
                if ( smallerWeightFound ) {
                    toVertex.setDistance(connection.getWeight());
                    toVertex.setPrev(target.getNumber());
                }
            }
        }
    }
}
