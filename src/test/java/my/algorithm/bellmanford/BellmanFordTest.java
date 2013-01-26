package my.algorithm.bellmanford;

import my.algorithm.AbstractGraphTest;
import my.algorithm.Vertex;
import my.algorithm.VertexConnection;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BellmanFordTest {

    @Test
    public void testCalclate() throws Exception {
        List<Vertex> vetexes = createVetexes();

        new BellmanFord().calclate(vetexes);

        assertThat(vetexes.toString(),
                is("[{number=0, distance=0, prev=-1}, {number=1, distance=7, prev=4}, {number=2, distance=11, prev=3}, {number=3, distance=5, prev=1}, {number=4, distance=2, prev=0}]"));
    }

    List<Vertex> createVetexes() {
        List<Vertex> vertexes = Arrays.asList(
                new Vertex(0),
                new Vertex(1),
                new Vertex(2),
                new Vertex(3),
                new Vertex(4));

        VertexConnection.connectDirectional(vertexes.get(0), vertexes.get(4), 2);

        VertexConnection.connectDirectional(vertexes.get(1), vertexes.get(3), -2);

        VertexConnection.connectDirectional(vertexes.get(2), vertexes.get(1), -3);

        VertexConnection.connectDirectional(vertexes.get(3), vertexes.get(2), 6);

        VertexConnection.connectDirectional(vertexes.get(4), vertexes.get(3), 4);
        VertexConnection.connectDirectional(vertexes.get(4), vertexes.get(1), 5);

        vertexes.get(0).setDistance(0);

        return vertexes;
    }
}
