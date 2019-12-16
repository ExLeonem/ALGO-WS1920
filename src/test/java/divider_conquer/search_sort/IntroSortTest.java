package divider_conquer.search_sort;

import divide_conquer.search_sort.IntroSort;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class IntroSortTest {


    IntroSort intro = new IntroSort();


    @Test
    void quickSortMedianTest() {
        int[] items = new int[]{5, 1, 4, 3, 11, 12, 6, 37, 6, 10, 18, 199, 200, 160, 75, 66, 97, 12, 17, 22};
        int[] actual = intro.sort(items);
        int[] expected = new int[]{1, 3, 4, 5, 6, 6, 10, 11, 12, 17, 18, 22, 37, 160, 199, 200, 66, 75, 97};

        assertArrayEquals(expected, actual);
    }


    @Test
    void singleInsertionSortTest() {
        int[] items = new int[]{4, 5, 2, 1};
        int[] actual = intro.sort(items);
        int[] expected = new int[]{1, 2, 4, 5};

        assertArrayEquals(expected, actual);
    }


    @Test
    void testHeapSort() {

        PriorityQueue<Integer> sortedValues = new PriorityQueue<Integer>();

        Random rand = new Random();
        final int ARRAY_LENGTH = 150;
        int arrayLength = rand.nextInt(ARRAY_LENGTH) + 5;
        int[] items = new int[arrayLength];
        final int MAX_VALUE = 200;
        final int MIN_VALUE = 200;

        for (int i = 0; i < arrayLength; i++) {
            int randomValue = rand.nextInt(MAX_VALUE + MIN_VALUE) - MIN_VALUE;
            sortedValues.add(randomValue);
            items[i] = randomValue;
        }

        int[] actual = intro.sort(items);

        int[] expected = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            expected[i] = sortedValues.poll();
        }

        assertArrayEquals(expected, actual);
    }

}
