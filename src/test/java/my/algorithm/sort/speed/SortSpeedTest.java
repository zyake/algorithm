package my.algorithm.sort.speed;


import my.algorithm.sort.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SortSpeedTest {

    private static final List<Integer> INTEGER_TEST_DATA;

    private static final String INTEGER_VALID_DATA;

    private Sorter sorter;

    static {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for ( int i = 0 ; i < 100000 ; i  ++ ) {
            integers.add(random.nextInt(1000));
        }
        INTEGER_TEST_DATA = Collections.unmodifiableList(integers);
        List<Integer> validData = new ArrayList<>(INTEGER_TEST_DATA);
        Collections.sort(validData);
        INTEGER_VALID_DATA = validData.toString();
    }

    public SortSpeedTest(Sorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void testSort_integerSpeedTest() throws Exception {
        List<Integer> integers = new ArrayList<>(INTEGER_TEST_DATA);
        Date start = new Date();
        sorter.sort(integers);
        System.out.println(sorter.getClass().getName() + ": " + (new Date().getTime() - start.getTime()));

        assertThat(integers.toString(), is(INTEGER_VALID_DATA));
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> createSorters() {
        List<Object[]> sorters = Arrays.asList(
                new Object[]{ new InsertionSorter() },
                new Object[]{ new SimpleQuickSorter() },
                new Object[]{ new HeapSorter() },
                new Object[]{ new TreeMapCountingSorter() },
                new Object[]{ new CollectionsSorterAdapter() }
        );

        return sorters;
    }
}
