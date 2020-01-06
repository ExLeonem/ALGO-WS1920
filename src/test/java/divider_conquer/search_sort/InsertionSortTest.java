package divider_conquer.search_sort;

import divide_conquer.search_sort.InsertionSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

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
    void testTwoElements() {
        int[] items = new int[]{5, 3};
        int[] actual = insertion.sort(items);
        int[] expected = new int[]{3, 5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void reverseElements() {
        int[] items = new int[]{5, 3, 2, 1};
        int[] actual = insertion.sort(items);
        int[] expected = new int[]{1, 2, 3, 5};

        assertArrayEquals(expected, actual);
    }


    @Test
    void random() {
        PriorityQueue<Integer> sortedValues = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() > o2.intValue()) {
                    return 1;
                } else if (o1.intValue() == o2.intValue()) {
                    return 0;
                }
                return -1;
            }
        });

        // Test parameter
        final int ARRAY_LENGTH = 200;
        final int MAX_VALUE = 200;
        final int MIN_VALUE = 200;

        // Generate random values copy into priority queue and keep unsorted array
        Random rand = new Random();
        int[] items = new int[rand.nextInt(ARRAY_LENGTH) + MIN_VALUE];
        for (int i = 0; i < items.length; i++) {
            int nextElement = rand.nextInt(MAX_VALUE) + MIN_VALUE;
            items[i] = nextElement;
            sortedValues.add(nextElement);
        }

        // Copy sorted values into array
        int[] actual = insertion.sort(items);
        int[] expected = new int[items.length];
        int indx = 0;
        while (!sortedValues.isEmpty()) {
            expected[indx] = sortedValues.poll();
            indx++;
        }

//        System.out.println("Sorted-by-method: " + Arrays.toString(actual));
//        System.out.println("Expected-Sorting: " + Arrays.toString(expected));

        assertArrayEquals(expected, actual);
    }
}
