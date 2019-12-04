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

}
