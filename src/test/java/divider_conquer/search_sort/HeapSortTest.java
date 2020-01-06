package divider_conquer.search_sort;

import divide_conquer.search_sort.HeapSort;
import divide_conquer.search_sort.Order;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import supplementary.utils.ArrayUtils;

import java.util.PriorityQueue;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class HeapSortTest {


    @Nested
    class MaxHeap {

        HeapSort heap = new HeapSort();

        @Test
        void singleElement() {
            int[] values = {1};
            int[] expected = {1};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void reverseThreeElement() {
            int[] values = {4, 3, 1};
            int[] expected = {1, 3, 4};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void reverseTwoElement() {
            int[] values = {2, 1};
            int[] expected = {1, 2};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void nonSort() {
            int[] values = {1, 2, 3};
            int[] expected = {1, 2, 3};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void testRandom() {

            Random rand = new Random();
            final int MAX_ARRAY_SIZE = 100;
            final int MIN_ARRAY_SIZE = 10;
            final int MIN_VALUE = -50;
            final int MAX_VALUE = 100;

            PriorityQueue<Integer> preSort = new PriorityQueue<Integer>();
            int randomNumberCount = rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + MIN_ARRAY_SIZE;
            int[] unsorted = new int[randomNumberCount];

            // Generate random numbers
            for (int i = 0; i < randomNumberCount; i++) {

                int nextInt = rand.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                preSort.add(nextInt);
                unsorted[i] = nextInt;
            }


            // Copy presorted values into an array
            int[] expectedSorted = new int[randomNumberCount];
            int i = 0;
            while(!preSort.isEmpty()) {

                expectedSorted[i] = preSort.remove();
                i++;
            }

            int[] actualSorted = heap.sort(unsorted);

            ArrayUtils.printHorizontal(actualSorted);

            // Compare results
            assertArrayEquals(expectedSorted, actualSorted);
        }
    }


    @Nested
    class MinHeap {
        HeapSort heap = new HeapSort(Order.DESC);

        @Test
        void singleElement() {
            int[] values = {1};
            int[] expected = {1};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void reverseThreeElement() {
            int[] values = {4, 3, 1};
            int[] expected = {4, 3, 1};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void reverseTwoElement() {
            int[] values = {2, 1};
            int[] expected = {2, 1};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void nonSort() {
            int[] values = {1, 2, 3};
            int[] expected = {3, 2, 1};

            assertArrayEquals(expected, heap.sort(values));
        }


        @Test
        void testRandom() {

            Random rand = new Random();
            final int MAX_ARRAY_SIZE = 100;
            final int MIN_ARRAY_SIZE = 10;
            final int MIN_VALUE = -50;
            final int MAX_VALUE = 100;

            PriorityQueue<Integer> preSort = new PriorityQueue<Integer>();
            int randomNumberCount = rand.nextInt(MAX_ARRAY_SIZE - MIN_ARRAY_SIZE) + MIN_ARRAY_SIZE;
            int[] unsorted = new int[randomNumberCount];

            // Generate random numbers
            for (int i = 0; i < randomNumberCount; i++) {

                int nextInt = rand.nextInt(MAX_VALUE - MIN_VALUE) + MIN_VALUE;
                preSort.add(nextInt);
                unsorted[i] = nextInt;
            }


            // Copy presorted values into an array
            int[] expectedSorted = new int[randomNumberCount];
            int i = expectedSorted.length -1;
            while(!preSort.isEmpty()) {

                expectedSorted[i] = preSort.remove();
                i--;
            }

            int[] actualSorted = heap.sort(unsorted);
            ArrayUtils.printHorizontal(actualSorted);

            // Compare results
            assertArrayEquals(expectedSorted, actualSorted);
        }
    }
}
