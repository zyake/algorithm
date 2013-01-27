package my.algorithm.bellmanford;

import my.algorithm.GraphBuilder;
import my.algorithm.Vertex;
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
        List<Vertex> vertices = new GraphBuilder(0, 4)
                .connectDirectionally(0, 4, 2)
                .connectDirectionally(1, 3, -2)
                .connectDirectionally(2, 1, -3)
                .connectDirectionally(3, 2, 6)
                .connectDirectionally(4, 3, 4)
                .connectDirectionally(4, 1, 5)
                .getVertices();

        vertices.get(0).setDistance(0);

        return vertices;
    }
}
