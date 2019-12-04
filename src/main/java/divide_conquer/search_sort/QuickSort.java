package divide_conquer.search_sort;

import java.util.Random;
import java.util.function.Function;
import java.util.zip.CheckedInputStream;

/**
 * Inplace quicksort of different elements.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-6
 */
public class QuickSort {


    private static Random rand = new Random();


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

        QuickSort.recurse(elements, 0, elements.length - 1, checkIndx);
        return elements;
    }


    // Recurse quicksort
    private static int[] recurse(int[] elements, int left, int right, Order order) {

        // Base case
        if (left >= right) {
            return elements;
        }

        // Recursion
        int center = QuickSort.partition(elements, left, right, order);
        QuickSort.recurse(elements, left, center, order); // sort left side
        QuickSort.recurse(elements, center+1, right, order); // sort right side

        return elements;
    }


    /**
     * Divide and conquer multidimensional array.
     *
     * @param elements
     * @param left
     * @param right
     * @return
     */
    private static void recurse(int[][] elements, int left, int right, int checkIndx) {

        // Base (single element dosent need to be sorted
        if (left >= right) {
            return;
        }

        // Sort elements
        int center = QuickSort.partition(elements, left, right, checkIndx);
        QuickSort.recurse(elements, left, center, checkIndx);
        QuickSort.recurse(elements, center+1, right, checkIndx);

    };


    /**
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


    private static int partition(int[][] elements, int left, int right, int checkIndx) {
        Random rand = QuickSort.rand;

        int pivotIndx = rand.nextInt((right - left) - 1);
        QuickSort.swapElements(elements, pivotIndx, right);

        int[] pivotElement = elements[right];
        int moveIndx = -1;
        for (int i = left; i < right; i++) {

//            if ()

        }

        return 2;
    }


    private static void swapElements(int[] elements, int from, int to) {
        int temp = elements[to];
        elements[to] = elements[from];
        elements[from] = temp;
    }

    private static void swapElements(int[][] elements, int fromOutter, int toOutter) {
        int[] temp = elements[fromOutter];
        elements[fromOutter] = elements[toOutter];
        elements[toOutter] = elements[fromOutter];
    }

}
