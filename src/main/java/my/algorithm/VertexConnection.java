package my.algorithm;

public class VertexConnection {

    private int weight;

    private Vertex toVertex;

    private  Vertex fromVertex;

    public static VertexConnection connectDirectional(Vertex fromVertex, Vertex toVertex, int weight) {
        VertexConnection connection = new VertexConnection(weight, fromVertex, toVertex);
        fromVertex.getConnections().add(connection);

        return connection;
    }

    public static VertexConnection connectIndirectional(Vertex fromVertex, Vertex toVertex, int weight) {
        VertexConnection connection = new VertexConnection(weight, fromVertex, toVertex);
        fromVertex.getConnections().add(connection);
        toVertex.getConnections().add(connection);

        return connection;
    }

    public VertexConnection(int weight, Vertex fromVertex, Vertex toVertex) {
        this.weight = weight;
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }
}
