package my.algorithm.sort;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * より汎用性の高い{@link TreeMap}による数え上げソートの実装。
 * get,set,containsKeyの各操作では、log(n)の計算量が必要となるため、
 * バケツ作成のコストがnで済む普通の数え上げソートよりも遅いが、
 * 数値以外の値に関してもソートすることができるため、より汎用性が高い。
 * ただし、値を入れ替えながら本当にソートするわけではないため、
 * ソート対象の各オブジェクトは「厳密に」一致している必要がある。
 * @param <T>
 */
public class TreeMapCountingSorter<T extends Comparable<T>> implements Sorter<T> {

    private class Counter {
        int value;
    }

    @Override
    public void sort(List<T> list) {
        Map<T, Counter> countMap = new TreeMap<>();
        int size = list.size();
        for ( int i = 0 ; i < size ; i ++ ) {
            T value = list.get(i);
            if ( ! countMap.containsKey(value) ) {
                countMap.put(value, new Counter());
            }
            Counter counter = countMap.get(value);
            counter.value ++;
        }

        int listIndex  = 0;
        for ( Map.Entry<T, Counter> entry : countMap.entrySet() ) {
            T key = entry.getKey();
            for ( int i = entry.getValue().value ; i > 0 ; i -- ) {
                 list.set(listIndex, key);
                 listIndex ++;
             }
        }
    }
}
