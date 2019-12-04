package divider_conquer.search_sort;

import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

   @Nested
    class AscTest {

       @Test
       void singleElement() {
           int[] elements = {1};
           int[] result = {1};
           assertArrayEquals(QuickSort.sort(elements), result);
       }

       @Test
       void twoElementUnsorted() {
           int[] elements = {2,1};
           int[] results = {1,2};

           assertArrayEquals(QuickSort.sort(elements), results);
       }

       @Test
       void threeElementsReverseOrder() {
           int[] elements = {3,2,1};
           int[] results = {1,2,3};

           assertArrayEquals(QuickSort.sort(elements), results);
       }

       @Test
       void fourElementsRandomized() {
           int[] elements = new int[]{6,3,21,4,4,5,2,1};
           int[] result = new int[]{1,2,3,4,4,5,6,21};

           assertArrayEquals(QuickSort.sort(elements), result);
       }
   }

   @Nested
    class DescTest {

       @Test
       void singleElement() {
           int[] elements = {1};
           int[] result = {1};
           assertArrayEquals(QuickSort.sort(elements, Order.DESC), result);
       }

       @Test
       void twoElementUnsorted() {
           int[] elements = {2,1};
           int[] results = {2,1};

           assertArrayEquals(QuickSort.sort(elements, Order.DESC), results);
       }

       @Test
       void threeElementsReverseOrder() {
           int[] elements = {3,2,1};
           int[] results = {3,2,1};

           assertArrayEquals(QuickSort.sort(elements, Order.DESC), results);
       }

       @Test
       void fourElementsRandomized() {
           int[] elements = new int[]{6,3,21,4,4,5,2,1};
           int[] result = new int[]{21,6,5,4,4,3,2,1};

           assertArrayEquals(QuickSort.sort(elements, Order.DESC), result);
       }
   }

    @Nested
    class NestedTest {

        @Test
        void singleElement() {
            int[][] values = new int[][]{{1, 1}};
            int[][] actual = QuickSort.sort(values);

            assertArrayEquals(values, actual);
        }


        @Test
        void twoElementFirstIndex() {
            int[][] values = new int[][]{{2, 1}, {1, 2}};
            int[][] actual = QuickSort.sort(values);
            int[][] expected = new int[][]{{1, 2}, {2, 1}};

            assertArrayEquals(expected, actual);
        }


        @Test
        void twoElementSecondIndex() {
            int[][] values = new int[][]{{2, 1}, {1, 2}};
            int[][] actual = QuickSort.sort(values, 1, Order.ASC);
            int[][] expected = new int[][]{{1, 2}, {2, 1}};

            assertArrayEquals(values, actual);
        }


        @Test
        void threeElementsReverse() {
            int[][] values = new int[][]{{3,80},{2,1},{1,2}};
            int[][] actual = QuickSort.sort(values);
            int[][] expected = new int[][]{{1,2},{2,1},{3,80}};

            assertArrayEquals(expected, actual);
        }


        @Test
        void threeElementFirstTwo() {
            int[][] values = new int[][]{{2,1},{1,2},{3,80}};
            int[][] actual = QuickSort.sort(values, 0, Order.ASC);
            int[][] expected = new int[][]{{1,2},{2,1},{3,80}};

            assertArrayEquals(expected, actual);
        }


        @Test
        void threeElementLastTwo() {
            int[][] values = new int[][]{{1,2},{2,1},{3,80}};
            int[][] actual = QuickSort.sort(values);
            int[][] expected = new int[][]{{1,2},{2,1},{3,80}};

            assertArrayEquals(expected, actual);
        }

        @Test
        void threeElementOutter() {
            int[][] values = new int[][]{{3,80},{2,1},{1,2}};
            int[][] actual = QuickSort.sort(values);
            int[][] expected = new int[][]{{1,2},{2,1},{3,80}};

            assertArrayEquals(expected, actual);
        }

        @Test
        void threeElementSecondIndex() {
            int[][] values = new int[][]{{2,1},{3,80},{1,2}};
            int[][] actual = QuickSort.sort(values, 1, Order.ASC);
            int[][] expected = new int[][]{{2,1},{1,2},{3,80}};

            assertArrayEquals(expected, actual);
        }

    }

}
