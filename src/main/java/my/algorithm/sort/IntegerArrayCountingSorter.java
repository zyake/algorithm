package my.algorithm.sort;

import java.util.List;

public class IntegerArrayCountingSorter implements Sorter<Integer> {

    private int maxValue;

    public IntegerArrayCountingSorter(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void sort(List<Integer> list) {
        int[] valueCount = new int[maxValue + 1];
        int size = list.size();
        for ( int i = 0 ; i < size ; i ++ ) {
            valueCount[list.get(i)] ++;
        }

        int listIndex = 0;
        for ( int i = 0 ; i <= maxValue ; i ++ ) {
            while ( valueCount[i] > 0 ) {
                list.set(listIndex, i);
                listIndex ++;
                valueCount[i] -= 1;
            }
        }
    }
}
