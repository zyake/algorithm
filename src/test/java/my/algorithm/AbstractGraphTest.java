package my.algorithm;

import my.algorithm.graph.GraphBuilder;
import my.algorithm.graph.Vertex;

import java.util.List;

public abstract class AbstractGraphTest {

    protected  List<Vertex> createTestvertices() {
        List<Vertex> vertices = new GraphBuilder(0, 4)
                .connectDirectionally(0, 1, 2)
                .connectDirectionally(0, 4, 4)
                .connectDirectionally(1, 2, 3)
                .connectDirectionally(2, 4, 1)
                .connectDirectionally(2, 3, 5)
                .connectDirectionally(3, 1, 8)
                .connectDirectionally(4, 3, 7)
                .getVertices();

        vertices.get(0).setDistance(0);

        return vertices;
    }
}