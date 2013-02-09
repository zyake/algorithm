package my.algorithm.sort.speed;

import my.algorithm.sort.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class DenseSortSpeedTest {

    private static final List<Integer> DENSE_TEST_DATA;

    private static final String VALID_DATA;

    private Sorter sorter;

    public static final int MAX_VALUE = 100;

    static {
        {
            List<Integer> integers = new ArrayList<>();
            Random random = new Random();
            for ( int i = 0 ; i < 100000 ; i  ++ ) {
                integers.add(random.nextInt(MAX_VALUE));
            }
            DENSE_TEST_DATA = Collections.unmodifiableList(integers);
        }
        {
            List<Integer> validData = new ArrayList<>(DENSE_TEST_DATA);
            Collections.sort(validData);
            VALID_DATA = validData.toString();
        }
    }

    public DenseSortSpeedTest(Sorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void testSort_denseSpeedTest() throws Exception {
        List<Integer> integers = new ArrayList<>(DENSE_TEST_DATA);
        Date start = new Date();
        sorter.sort(integers);
        System.out.println(sorter.getClass().getName() + ": " + (new Date().getTime() - start.getTime()));

        assertThat(integers.toString(), is(VALID_DATA));
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> createSorters() {
        List<Object[]> sorters = Arrays.asList(
                new Object[]{ new InsertionSorter<Integer>() },
                new Object[]{ new SimpleQuickSorter<Integer>() },
                new Object[]{ new HeapSorter<Integer>() },
                new Object[]{ new TreeMapCountingSorter<Integer>() },
                new Object[]{ new IntegerArrayCountingSorter(MAX_VALUE) },
                new Object[]{ new CollectionsSorterAdapter<Integer>() }
        );

        return sorters;
    }
}
