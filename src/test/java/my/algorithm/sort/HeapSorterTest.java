package my.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HeapSorterTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 5, 4, 2, 3, 8, 9, 7);

        new HeapSorter<Integer>().sort(integers);

        assertThat(integers.toString(), is("[1, 2, 3, 4, 5, 7, 8, 9]"));
    }


}
