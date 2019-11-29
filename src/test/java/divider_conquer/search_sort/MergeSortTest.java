package divider_conquer.search_sort;

import divide_conquer.search_sort.MergeSort;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;


public class MergeSortTest {

    @Test
    void singleElement() {
        int[] in = {1};
        int[] out = {1};

        assertArrayEquals(MergeSort.sort(in), out);
    }

    @Test
    void twoElements() {
        int[] in = {2,1};
        int[] out = {1,2};

        assertArrayEquals(MergeSort.sort(in), out);
    }

    @Test
    void threeElements() {
        int[] in = {3,1,2};
        int[] out = {1,2,3};

        assertArrayEquals(MergeSort.sort(in), out);
    }

    @Test
    void randomElement() {
        int[] elements = new int[]{6,3,21,4,4,5,2,1};
        int[] result = new int[]{1,2,3,4,4,5,6,21};

        assertArrayEquals(MergeSort.sort(elements), result);
    }

}
