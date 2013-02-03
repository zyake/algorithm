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


    @Test
    public void testSort_speedTest() throws Exception {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for ( int i = 0 ; i < 100000 ; i  ++ ) {
            integers.add(random.nextInt() % 1000);
        }

        Date start = new Date();
        new InsertionSorter<Integer>().sort(integers);
        System.out.println(new Date().getTime() - start.getTime());
    }
}
