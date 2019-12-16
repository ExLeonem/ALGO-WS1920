package divider_conquer.search_sort;

import divide_conquer.search_sort.InsertionSort;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {

    InsertionSort insertion = new InsertionSort();


    @Test
    void testSingleElement() {
        int[] items = new int[]{1};
        int[] actual = insertion.sort(items);
        int[] expected = new int[]{1};

        assertArrayEquals(expected, actual);
    }


    @Test
    void middleNotInOrder() {
        int[] items = new int[]{1, 4, 2, 5, 6};
        int[] actual = insertion.sort(items);
        int[] expected = new int[]{1, 2, 4, 5, 6};

        assertArrayEquals(expected, actual);
    }


    @Test
    void reverseElements() {
        int[] items = new int[]{5, 3, 2, 1};
        int[] actual = insertion.sort(items);
        int[] expected = new int[]{1, 2, 3, 5};

        assertArrayEquals(expected, actual);
    }
}
