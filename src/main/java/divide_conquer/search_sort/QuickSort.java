package divide_conquer.search_sort;

import java.util.Random;

/**
 * Inplace quicksort for different elements.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-6
 */
public class QuickSort {


    /**
     * Sort an integer array in ascending order.
     *
     * @param elements unsorted array of integers.
     * @return sorted array
     */
    public static int[] sort(int[] elements) {

        if (elements.length <= 1) {
            return elements;
        }

        return QuickSort.recurse(elements, 0, elements.length, Order.ASC);
    }


    /**
     * Sort an integer array.
     *
     * @param elements - elements so sort
     * @param order - sorting order ASC | DESC
     * @return
     */
    public static int[] sort(int[] elements, Order order) {

        if (elements.length <= 1) {
            return elements;
        }

        return QuickSort.recurse(elements, 0, elements.length, order);
    }


    /**
     * Sort an nested integer array in ascending order using the element at index 0 of the nested array.
     *
     * @param elements - elements to sort
     * @return
     */
    public static int[][] sort(int[][] elements) {
        return QuickSort.sort(elements, 0, Order.ASC);
    }


    /**
     * Sort an nested array.
     *
     * @param elements - elements to sort
     * @param checkIndx - outter index to check
     * @param order - sorting order ascending | descing
     * @return - sorted array
     */
    public static int[][] sort(int[][] elements, int checkIndx, Order order) {

        if (elements.length <= 1) {
            return elements;
        }

        return QuickSort.recurse(elements, 0, elements.length, checkIndx, order);
    }


    /**
     * Divide and Conquer, QuickSort recursion.
     *
     * @param elements - elements to sort
     * @param left - left border
     * @param right - right border
     * @param order - Order of elements to use
     * @return sorted array
     */
    private static int[] recurse(int[] elements, int left, int right, Order order) {

        // Base case
        if (left >= right) {
            return elements;
        }

        // Recursion
        int center = QuickSort.partition(elements, left, right, order);
        QuickSort.recurse(elements, left, center, order); // sort left side
        return QuickSort.recurse(elements, center+1, right, order); // sort right side
    }


    /**
     * Divide and conquer multidimensional array.
     *
     * @param elements - elements to sort.
     * @param left - left border
     * @param right - right border
     * @return
     */
    private static int[][] recurse(int[][] elements, int left, int right, int checkIndx, Order order) {

        // Base (single element dosent need to be sorted
        if (left >= right) {
            return elements;
        }

        // Sort elements
        int center = QuickSort.partition(elements, left, right, checkIndx, order);
        QuickSort.recurse(elements, left, center, checkIndx, order);
        return QuickSort.recurse(elements, center+1, right, checkIndx, order);
    };


    /**
     * Partition step of quick-sort on regular intger array.
     *
     * @param elements - elements to sort
     * @param left - left border
     * @param right - right border
     * @param order - sorting order ascending | descending
     * @return
     */
    private static int partition(int[] elements, int left, int right, Order order) {

        int pivotElement = elements[right-1];
        int ex_var = left-1;
        for (int i = left; i < right - 1; i++) {

            if (order.inOrder(elements[i], pivotElement)) {
                ex_var++;
                swapElements(elements, i, ex_var);
            }
        }

        // Exchange pivot element with
        swapElements(elements, ex_var+1, right-1);
        return ex_var+1;
    }


    private static int partition(int[][] elements, int left, int right, int checkIndx, Order order) {

        // In-Place swapping of elements
        int[] pivotElement = elements[right-1];
        int moveIndx = left - 1;
        for (int i = left; i < right-1; i++) {

            if (order.inOrder(elements[i], pivotElement, checkIndx)) {
                moveIndx++;
                swapElements(elements, i, moveIndx);
            }
        }

        // Put pivot element in the middle
        swapElements(elements, right-1, moveIndx+1);

        return moveIndx+1; // pivot index
    }


    /**
     * Exchange positions of inteer values.
     *
     * @param elements
     * @param from
     * @param to
     */
    private static void swapElements(int[] elements, int from, int to) {
        int temp = elements[to];
        elements[to] = elements[from];
        elements[from] = temp;
    }


    /**
     * Exchange positions of nested integer values.
     *
     * @param elements - array of elements
     * @param from - from position
     * @param to - to position
     */
    private static void swapElements(int[][] elements, int from, int to) {
        int[] temp = elements[from];
        elements[from] = elements[to];
        elements[to] = temp;
    }

}
