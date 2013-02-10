package my.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * バケツソートの実装。文字列は全て「3文字以上の英小文字」であることを前提としている。
 */
public class BucketSorter implements Sorter<String> {

    private static final int BASE_CHARCODE = 'a';

    private static final Sorter<String> INSERTION_SORTER = new InsertionSorter<>();

    @Override
    public void sort(List<String> list) {
        List<String>[] bucket = createBucket();
        int size = list.size();
        for ( int i = 0 ; i < size ; i ++ ) {
            String text = list.get(i);
            int hash = hash(text);
            boolean arrayNotFound = bucket[hash] == null;
                if ( arrayNotFound ) {
                    bucket[hash] = new ArrayList<String>();
            }
            bucket[hash].add(text);
        }

        int bucketSize = bucket.length;
        int writeCount = 0;
        for ( int i = 0 ; i <  bucketSize ; i ++ ) {
            List<String> hashedList = bucket[i];
            if ( hashedList == null ) {
                continue;
            }

            INSERTION_SORTER.sort(hashedList);

            int hashedListCount = hashedList.size();
            for ( int j = 0 ; j < hashedListCount ; j ++ ) {
                list.set(writeCount, hashedList.get(j));
                writeCount ++;
            }
        }
    }

    private int hash(String text) {
        return ((int)text.charAt(0)  - BASE_CHARCODE) * (676) + ((int)text.charAt(1) - BASE_CHARCODE) * (26) + ((int)text.charAt(2) - BASE_CHARCODE) * 1;
    }

    private List<String>[] createBucket() {
        return new ArrayList[26 * 26 * 26];
    }
}
