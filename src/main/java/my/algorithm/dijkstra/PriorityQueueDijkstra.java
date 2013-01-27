package my.algorithm.dijkstra;


import my.algorithm.VertexConnection;
import my.algorithm.Vertex;

import java.util.*;

public class PriorityQueueDijkstra implements Dijkstra {

    private static final Comparator<Vertex> VERTEX_DISTANCE_COMPARATOR = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            return o1.getDistance() - o2.getDistance();
        }
    };

    @Override
    public void calculate(List<Vertex> vertices) {
        List<Vertex> unvisitVertices = new ArrayList<>();
        for ( Vertex vertex : vertices ) {
            unvisitVertices.add(vertex);
        }

        while ( ! unvisitVertices.isEmpty() ) {
            Collections.sort(unvisitVertices, VERTEX_DISTANCE_COMPARATOR);
            Vertex vertex = unvisitVertices.remove(0);
            for ( VertexConnection vConnect :  vertex.getConnections() ) {
                int newDist = vConnect.getWeight() + vertex.getDistance();
                Vertex toVertex = vConnect.getToVertex();

            boolean shorterPathFound = newDist < toVertex.getDistance();
            if ( shorterPathFound ) {
                toVertex.setDistance(newDist);
                toVertex.setPrev(vertex.getNumber());
            }
        }
        }
    }

}
