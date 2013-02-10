package my.algorithm.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BucketSorterTest {

    @Test
    public void testSort() {
        List<String> texts = new ArrayList<>();
        Collections.addAll(texts,
                "bcdefg",
                "acdefg",
                "hijklmn",
                "abcdefg",
                "abceefg");

        new BucketSorter().sort(texts);

        assertThat(texts.toString(), is("[abcdefg, abceefg, acdefg, bcdefg, hijklmn]"));
    }
}
