package divider_conquer.select;

import divide_conquer.search_sort.InsertionSort;
import divide_conquer.select.QuickSelect;
import divider_conquer.search_sort.InsertionSortTest;
import org.junit.jupiter.api.Test;
import supplementary.utils.ArrayUtils;

import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSelectTest {

    QuickSelect quickSelect = new QuickSelect();

    @Test
    void singleElementValidIndx() {
        int[] values = {1};
        int actual = quickSelect.select(values, 1);
        int expected = 1;

        assertEquals(expected, actual);
    }


    @Test
    void median() {
        int[] values = {5, 2, 7, 1, 0}; // 0, 1, 2, 5, 7
        int actual = quickSelect.select(values, 3);
        int expected = 2;

        assertEquals(expected, actual);
    }


    @Test
    void multipleOutterLeft() {
        int[] values = {5, 2, 7, 1, 0};
        int actual = quickSelect.select(values, 1);
        int expected = 0;

        assertEquals(expected, actual);
    }


    @Test
    void multipleOutterRight() {
        int[] values = {5, 2, 7, 1, 0};
        int actual = quickSelect.select(values, values.length);
        int expected = 7;

        assertEquals(expected, actual);
    }

    @Test
    void testStackOverflowSituation() {
        // Sorted: -43, -40, -35, -34, -34, -29, -27, -26, -21, -18, -16, -10, -7, -3, 0, 2, 8, 10, 14, 29, 31, 36, 41, 42, 47
        int[] values = {-10, -43, -34, 36, -21, -18, -35, -40, -34, -3, 14, -7, -29, 41, -26, -27, 2, 47, 8, 10, 31, 0, 42, -16, 29};
        int actual = quickSelect.select(values, 4);
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    void nonWorkingSample() {
        // Sorted: -50, -45, -43, -43, -42, -41, -34, -32, -32, -26, -24, -22, -10, -7, 2, 14, 18, 23, 27, 29, 30, 37, 41, 42, 44
        int[] values = {-50, 30, 44, -22, 41, 23, 18, 27, -24, -43, -7, -32, -10, -32, -26, 42, 14, -43, -34, -45, 37, -41, 2, -42, 29};
        int actual = quickSelect.select(values, 18);
        int expected = 25; // 27

        assertEquals(expected, actual);
    }


    @Test
    void random() {
        Random rand = new Random();

        final int MAX_ARRAY_SIZE = 100;
        final int MIN_ARRAY_SIZE = 10;

        final int MIN_VALUE = -50;
        final int MAX_VALUE = 50;

//      int arraySize = rand.nextInt(MAX_ARRAY_SIZE-MIN_ARRAY_SIZE) + MIN_ARRAY_SIZE;
        int arraySize = 25;
        int[] randomValues = new int[arraySize];
        PriorityQueue<Integer> sortedValues = new PriorityQueue<Integer>();
        for (int i = 0; i < arraySize; i++) {
            int nextInt = rand.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
            randomValues[i] = nextInt;
            sortedValues.add(nextInt);
        }

        int nth = rand.nextInt(arraySize-1) + 1;
        int nthCounter = nth;
        int expected = -1;

        while (!sortedValues.isEmpty()) {
            nthCounter--;
            int nextValue = sortedValues.remove();

            if (nthCounter == 0) {
                expected = nextValue;
                break;
            }
        }

        InsertionSort insertion = new InsertionSort();
        System.out.println("\nNth- " + nth);
        System.out.println("Expected: " + expected + "\n");
        ArrayUtils.printHorizontal(randomValues);
        System.out.println("");
        ArrayUtils.printHorizontal(insertion.sort(randomValues));
        int actual = quickSelect.select(randomValues, nth);
        System.out.println("\nActual: " + actual);

        assertEquals(expected, actual);
    }
}
