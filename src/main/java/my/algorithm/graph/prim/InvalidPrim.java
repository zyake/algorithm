package my.algorithm.graph.prim;

import my.algorithm.graph.Vertex;
import my.algorithm.graph.VertexConnection;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * {@link PriorityQueue}って、実はpoll対象の要素はソート対象から除外されてるのね・・・。
 * つまり、動的にソートに使用するキーが変わるようなオブジェクトの管理には向いていないっぽい。
 */
public class InvalidPrim {

    private static final Comparator<Vertex> VERTEX_COMPARATOR = new Comparator<Vertex>() {
        @Override
        public int compare(Vertex o1, Vertex o2) {
            System.out.println("compare: " + o1 + ", " + o2);
            return o1.getDistance() - o2.getDistance();
        }
    };

    void calculate(List<Vertex> vertices) {
        System.out.println("creation start");
        PriorityQueue<Vertex> unvisitVertices = new PriorityQueue<>(vertices.size(), VERTEX_COMPARATOR);
        for ( Vertex vertex : vertices ) {
            unvisitVertices.add(vertex);
        }
        System.out.println(unvisitVertices);

        System.out.println("iteration start");
        while ( ! unvisitVertices.isEmpty() ) {
            System.out.println("iteration...");
            System.out.println(unvisitVertices);

            Vertex target = unvisitVertices.poll();
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
