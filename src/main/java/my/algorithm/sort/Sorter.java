package my.algorithm.sort;

import java.util.List;

public interface Sorter<T extends Comparable<T>> {

    public void sort(List<T> list);
}
