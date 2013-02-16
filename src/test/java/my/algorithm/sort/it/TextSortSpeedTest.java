package my.algorithm.sort.it;

import my.algorithm.IT;
import my.algorithm.sort.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Category(IT.class)
@RunWith(Parameterized.class)
public class TextSortSpeedTest {

    private static final List<String> TEST_DATA;

    private static final String VALID_DATA;

    private final Sorter sorter;

    static {
        int min = 'a';
        Random random = new Random();
        List<String> texts = new ArrayList<>();
        for ( int i = 0 ; i < 10000 ; i ++ ) {
            StringBuilder builder = new StringBuilder()
                .append((char) (random.nextInt(26) + min))
                .append((char) (random.nextInt(26) + min))
                .append((char) (random.nextInt(26) + min))
                .append((char) (random.nextInt(26) + min))
                .append((char) (random.nextInt(26) + min))
                .append((char) (random.nextInt(26) + min));

            texts.add(builder.toString());
        }

        TEST_DATA = Collections.unmodifiableList(texts);

        List<String> validData = new ArrayList<>(TEST_DATA);
        Collections.sort(validData);
        VALID_DATA = validData.toString();
    };

    public TextSortSpeedTest(Sorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void sortTest() {
        List<String> testData = new ArrayList<>(TEST_DATA);

        Date start = new Date();
        sorter.sort(testData);
        System.out.println(sorter.getClass().getName() + ", time=" + (new Date().getTime() - start.getTime()));

        assertThat(testData.toString(), is(VALID_DATA));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> createSorters() {
        List<Object[]> objects = new ArrayList<>();
        Collections.addAll(objects,
                new Object[] { new SimpleQuickSorter() },
                new Object[] { new InsertionSorter() },
                new Object[] { new HeapSorter() },
                new Object[] { new CollectionsSorterAdapter() },
                new Object[] { new TreeMapCountingSorter() },
                new Object[] { new BucketSorter() });

        return objects;
    }
}
