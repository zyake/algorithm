package my.algorithm.dijkstra;

import my.algorithm.AbstractGraphTest;
import my.algorithm.Vertex;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DenseGraphGraphTest extends AbstractGraphTest {

    @Test
    public void testCalculate() throws Exception {
        List<Vertex> vertexes = createTestVertexes();

        new DenseGraphDijkstra().calculate(vertexes);

        assertThat(vertexes.toString(),
                is("[{number=0, distance=0, prev=0}, {number=1, distance=2, prev=-1}, {number=2, distance=5, prev=1}, {number=3, distance=10, prev=2}, {number=4, distance=4, prev=0}]"));
    }
}
