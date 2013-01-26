package my.algorithm.dijkstra;


import my.algorithm.VertexConnection;
import my.algorithm.Vertex;

import java.util.List;import java.util.PriorityQueue;import java.util.Queue;

public class PriorityQueueDijkstra implements Dijkstra {

    @Override
    public void calculate(List<Vertex> vertexes) {
        Queue<Vertex> queue = new PriorityQueue<Vertex>();
        for ( Vertex vertex : vertexes ) {
            queue.add(vertex);
        }

        while ( ! queue.isEmpty() ) {
            Vertex vertex = queue.poll();
            for ( VertexConnection vConnect :  vertex.getConnections() ) {
                int newDist = vConnect.getWeight() + vertex.getDistance();
                Vertex toVertex = vConnect.getToVertex();
                boolean updateRequired = newDist < toVertex.getDistance();
                if ( updateRequired ) {
                    toVertex.setDistance(newDist);
                    toVertex.setPrev(vertex.getNumber());
                }
            }
        }
    }

}
