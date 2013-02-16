package my.algorithm.graph.prim;

import my.algorithm.graph.GraphBuilder;
import my.algorithm.graph.Vertex;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PrimTest {

    @Test
    public void testCalculate() throws Exception {
        List<Vertex> vertices = createVertices();

        new Prim().calculate(vertices);

        assertThat(vertices.toString(),
            is("[{number=0, distance=0, prev=-1}, {number=1, distance=2, prev=0}, {number=2, distance=3, prev=1}, {number=3, distance=5, prev=2}, {number=4, distance=1, prev=2}]"));
    }

    List<Vertex> createVertices() {
        List<Vertex> vertices = new GraphBuilder(0, 4)
                .connectIndirectionally(0, 1, 2)
                .connectIndirectionally(0, 4, 4)
                .connectIndirectionally(0, 3, 8)
                .connectIndirectionally(1, 2, 3)
                .connectIndirectionally(2, 4, 1)
                .connectIndirectionally(2, 3, 5)
                .connectIndirectionally(3, 4, 7)
                .getVertices();
        vertices.get(0).setDistance(0);

        return vertices;
    }
}

