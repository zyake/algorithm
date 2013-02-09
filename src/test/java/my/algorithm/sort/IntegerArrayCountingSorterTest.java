package my.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerArrayCountingSorterTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 3, 0, 2, 0, 0, 2, 2);

        new IntegerArrayCountingSorter(3).sort(integers);

        System.out.println(integers);
    }
}
