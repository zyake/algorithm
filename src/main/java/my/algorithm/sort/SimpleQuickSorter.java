package my.algorithm.sort;

import java.util.List;

public class SimpleQuickSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> list) {
        doSort(list, 0, list.size() - 1);
    }

    private void doSort(List<T> list, int left, int right) {
        boolean isCompleted = right <= left;
        if ( isCompleted ) {
            return;
        }

        int pivot = partition(list, left, right);
        doSort(list, left, pivot - 1);
        doSort(list, pivot + 1, right);
    }

    private int partition(List<T> list, int left, int right) {
        int pivot = selectPivot(list, left, right);
        T pivotValue = list.get(pivot);
        list.set(pivot, list.get(right));
        list.set(right, pivotValue);

        int smallerStore = left;
        for ( int i = left ; i < right  ;  i  ++ ) {
            T target = list.get(i);
            boolean requireSwap = target.compareTo(pivotValue) <= 0;
            if ( requireSwap ) {
                list.set(i, list.get(smallerStore));
                list.set(smallerStore, target);
                smallerStore ++;
            }
        }

        list.set(right, list.get(smallerStore));
        list.set(smallerStore, pivotValue);

        return smallerStore;
    }

    protected int selectPivot(List<T> list, int left, int right) {
        return (left + right) / 2;
    }
}
