package my.algorithm.floydwarshall;

import my.algorithm.GraphBuilder;
import my.algorithm.Vertex;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FloydWarshallTest {

    @Test
    public void testCalculate() throws Exception {
        List<Vertex> vertices = createvertices();

        FloydWarshallResult result = new FloydWarshall().calculate(vertices);

        String distance = createMatrixText(result.getDistance());
        assertThat(distance,
            is("[0,2,5,10,4]\r\n" +
                "[16,0,3,8,4]\r\n" +
                "[13,15,0,5,1]\r\n" +
                "[8,10,13,0,12]\r\n" +
                "[15,17,20,7,0]\r\n"));

        String pred = createMatrixText(result.getPred());
        assertThat(pred,
            is("[-1,0,1,2,0]\r\n" +
                "[3,-1,1,2,2]\r\n" +
                "[3,0,-1,2,2]\r\n" +
                "[3,0,1,-1,0]\r\n" +
                "[3,0,1,4,-1]\r\n"));
    }

    String createMatrixText(int [][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for ( int x = 0 ; x < matrix.length ;  x ++ ) {
            stringBuilder.append("[");
            for ( int y  = 0 ; y < matrix[x].length ; y ++ ) {
                stringBuilder.append(matrix[x][y] + ",");
            }
            boolean deleteLastComma = stringBuilder.charAt(stringBuilder.length() - 1)  == ',';
            if ( deleteLastComma ) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append("]\r\n");
        }

        return stringBuilder.toString();
    }

    List<Vertex> createvertices() {
        return new GraphBuilder(0, 4)
                .connectDirectionally(0, 1, 2)
                .connectDirectionally(0, 4, 4)
                .connectDirectionally(1, 2, 3)
                .connectDirectionally(2, 3, 5)
                .connectDirectionally(2, 4, 1)
                .connectDirectionally(3, 0, 8)
                .connectDirectionally(4, 3, 7)
                .getVertices();
    }
}
