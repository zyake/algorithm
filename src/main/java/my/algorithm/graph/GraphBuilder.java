package my.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

    private List<Vertex> vertices;

    public GraphBuilder(int from, int to) {
        this.vertices = new ArrayList<>();
        for ( int i = from ; i <= to ; i ++ ) {
            this.vertices.add(new Vertex(i));
        }
    }

    public GraphBuilder connectDirectionally(int from, int to, int weight) {
        VertexConnection connection = new VertexConnection(weight, vertices.get(from), vertices.get(to));
        vertices.get(from).getConnections().add(connection);

        return this;
    }

    public GraphBuilder connectIndirectionally(int from, int to, int weight) {
        VertexConnection connection = new VertexConnection(weight, vertices.get(from), vertices.get(to));
        vertices.get(from).getConnections().add(connection);


        VertexConnection toConnection = new VertexConnection(weight, vertices.get(to), vertices.get(from));
        vertices.get(to).getConnections().add(toConnection);

        return this;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }
}