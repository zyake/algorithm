package my.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TreeMapCountingSorterTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 3, 0, 2, 0, 0, 2, 2);

        new TreeMapCountingSorter<Integer>().sort(integers);

        assertThat(integers.toString(), is("[0, 0, 0, 2, 2, 2, 3]"));
    }
}
