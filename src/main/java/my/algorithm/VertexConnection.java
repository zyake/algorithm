package my.algorithm;

public class VertexConnection {

    private int weight;

    private Vertex toVertex;

    private  Vertex fromVertex;

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
