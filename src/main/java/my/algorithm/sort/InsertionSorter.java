package my.algorithm.sort;

import java.util.List;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T>  {

    @Override
    public void sort(List<T> list) {
        doSort(list, 0, list.size());
    }

    protected void doSort(List<T> list, int left, int right) {
        for( int i = left ; i < right; i ++ ) {
            insert(list, i - 1, list.get(i));
        }
    }

    private void insert(List<T> list, int fromPos, T target) {
        T opponent = null;
        while( fromPos >= 0 &&  target.compareTo((opponent = list.get(fromPos))) < 0 ) {
            list.set(fromPos + 1, opponent);
            fromPos --;
        }
        list.set(fromPos + 1, target);
    }
}
