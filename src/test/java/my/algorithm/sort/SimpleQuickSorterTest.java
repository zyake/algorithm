package my.algorithm.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQuickSorterTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 5, 2, 3, 8, 15, 22, 10, 2, 4, 9);

        new SimpleQuickSorter<Integer>().sort(integers);

        assertThat(integers.toString(), is("[1, 2, 2, 3, 4, 5, 8, 9, 10, 15, 22]"));
    }

    @Test
    public void testSort_speedTest() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for ( int i = 0 ; i < 100000 ; i  ++ ) {
            integers.add(random.nextInt() % 1000);
        }

        Date start = new Date();
        new SimpleQuickSorter<Integer>().sort(integers);
        System.out.println(new Date().getTime() - start.getTime());
    }
}
