package my.algorithm;

import my.algorithm.VertexConnection;
import my.algorithm.Vertex;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractGraphTest {

    protected  List<Vertex> createTestVertexes() {
        List<Vertex> vertexes = Arrays.asList(
                new Vertex(0),
                new Vertex(1),
                new Vertex(2),
                new Vertex(3),
                new Vertex(4)
        );

        VertexConnection.connectDirectional(vertexes.get(0), vertexes.get(1), 2);
        VertexConnection.connectDirectional(vertexes.get(0), vertexes.get(4), 4);

        VertexConnection.connectDirectional(vertexes.get(1), vertexes.get(2), 3);

        VertexConnection.connectDirectional(vertexes.get(2), vertexes.get(4), 1);
        VertexConnection.connectDirectional(vertexes.get(2), vertexes.get(3), 5);

        VertexConnection.connectDirectional(vertexes.get(3), vertexes.get(1), 8);

        VertexConnection.connectDirectional(vertexes.get(4), vertexes.get(3), 7);

        vertexes.get(0).setDistance(0);

        return vertexes;
    }
}