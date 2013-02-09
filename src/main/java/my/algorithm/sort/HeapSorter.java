package my.algorithm.sort;

import java.util.List;

public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public void sort(List<T> list) {
        buildHeap(list);
        for ( int i  = list.size() - 1 ; i > 0 ; i -- ) {
            T target = list.get(i);
            list.set(i, list.get(0));
            list.set(0, target);

            heapfy(list, 0, i);
        }
    }

    private void buildHeap(List<T> list) {
        for ( int i = ( list.size() / 2 ) - 1 ; i  > - 1 ; i -- ) {
            heapfy(list, i, list.size());
        }
    }

    private void heapfy(List<T> list, int index, int max) {
        int largestIndex = index;
        T largestValue = list.get(index);

        int leftIndex = index * 2 + 1;
        boolean hasLeft = leftIndex < max;
        if ( hasLeft ) {
            T left = list.get(leftIndex);
            boolean leftIsLarger = left.compareTo(largestValue) > 0;
            if ( leftIsLarger ) {
                largestIndex = leftIndex;
                largestValue = list.get(leftIndex);
            }
        }

        int rightIndex = index * 2 + 2;
        boolean hasRight = rightIndex < max;
        if ( hasRight ) {
            T right = list.get(rightIndex);
            boolean rightIsLarger = right.compareTo(largestValue) > 0;
            if ( rightIsLarger ) {
                largestIndex = rightIndex;
                largestValue = list.get(rightIndex);
            }
        }

        boolean pullUpLargerValue = largestIndex != index;
        if ( pullUpLargerValue ) {
            T indexValue = list.get(index);
            list.set(index, largestValue);
            list.set(largestIndex, indexValue);
            heapfy(list, largestIndex, max);
        }
    }
}
