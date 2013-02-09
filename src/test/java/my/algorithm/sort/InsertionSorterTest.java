package my.algorithm.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class InsertionSorterTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 10, 8, 2, 15, 9, 22);

        new InsertionSorter<Integer>().sort(integers);

        assertThat(integers.toString(), is("[2, 8, 9, 10, 15, 22]"));
    }
}
