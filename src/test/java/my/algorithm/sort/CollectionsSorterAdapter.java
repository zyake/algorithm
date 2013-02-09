package my.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class CollectionsSorterAdapter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> list) {
        Collections.sort(list);
    }
}
