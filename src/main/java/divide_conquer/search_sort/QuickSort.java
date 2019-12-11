package divide_conquer.search_sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Inplace quicksort for different elements.
 *
 * @author Maksim Sandybekov
 * @date 2019-11-6
 */
public class QuickSort<T extends Comparable> {

    Order order;


    public QuickSort() {
        this.order = this.getDefaultOrder();
    }


    public QuickSort(Order order) {
        this.order = order;
    }





    /**
     * Sort an integer array in ascending order.
     *
     * @param elements unsorted array of integers.
     * @return sorted array
     */
    public T[] sort(T[] elements) {

        if (elements.length <= 1) {
            return elements;
        }

        return this.recurse(elements, 0, elements.length);
    }

    public int[] sort(int[] elements) {

        if (elements.length <= 1) {
            return elements;
        }

        return this.recurse(elements, 0, elements.length);
    }

    /**
     * Sort an nested array.
     *
     * @param elements - elements to sort
     * @param checkIndx - outter index to check
     * @return - sorted array
     */
    public T[][] sort(T[][] elements, int checkIndx) {

        if (elements.length <= 1) {
            return elements;
        }

        return this.recurse(elements, 0, elements.length, checkIndx);
    }

    public T[][] sort(T[][] elements) {
        return this.sort(elements, 0);
    }

    public int[][] sort(int[][] elements, int checkIndx) {

        if (elements.length <= 1) {
            return elements;
        }

        return this.recurse(elements, 0, elements.length, checkIndx);
    }

    public int[][] sort(int[][] elements) {
        return this.sort(elements, 0);
    }


    /**
     * Divide and Conquer, QuickSort recursion.
     *
     * @param elements - elements to sort
     * @param left - left border
     * @param right - right border
     * @return sorted array
     */
    private T[] recurse(T[] elements, int left, int right) {

        // Base case
        if (left >= right) {
            return elements;
        }

        // Recursion
        int center = this.partition(elements, left, right);
        this.recurse(elements, left, center); // sort left side
        return this.recurse(elements, center+1, right); // sort right side
    }


    private int[] recurse(int[] elements, int left, int right) {

        // Base case
        if (left >= right) {
            return elements;
        }

        // Recursion
        int center = this.partition(elements, left, right);
        this.recurse(elements, left, center); // sort left side
        return this.recurse(elements, center+1, right); // sort right side
    }


    private T[][] recurse(T[][] elements, int left, int right, int checkIndx) {

        // Base (single element dosent need to be sorted
        if (left >= right) {
            return elements;
        }

        // Sort elements
        int center = this.partition(elements, left, right, checkIndx);
        this.recurse(elements, left, center, checkIndx);
        return this.recurse(elements, center+1, right, checkIndx);
    };


    private int[][] recurse(int[][] elements, int left, int right, int checkIndx) {

        // Base (single element dosent need to be sorted
        if (left >= right) {
            return elements;
        }

        // Sort elements
        int center = this.partition(elements, left, right, checkIndx);
        this.recurse(elements, left, center, checkIndx);
        return this.recurse(elements, center+1, right, checkIndx);
    };



    /**
     * Partition step of quick-sort on regular intger array.
     *
     * @param elements - elements to sort
     * @param left - left border
     * @param right - right border
     * @return
     */
    private int partition(T[] elements, int left, int right) {

        Order order = this.getOrder();
        T pivotElement = elements[right-1];
        int ex_var = left-1;
        for (int i = left; i < right - 1; i++) {

            if (this.compare(elements[i], pivotElement)) {
                ex_var++;
                swapElements(elements, i, ex_var);
            }
        }

        // Exchange pivot element with
        swapElements(elements, ex_var+1, right-1);
        return ex_var+1;
    }


    private int partition(int[] elements, int left, int right) {

        Order order = this.getOrder();
        int pivotElement = elements[right-1];
        int ex_var = left-1;
        for (int i = left; i < right - 1; i++) {

            if (this.compare(elements[i], pivotElement)) {
                ex_var++;
                swapElements(elements, i, ex_var);
            }
        }

        // Exchange pivot element with
        swapElements(elements, ex_var+1, right-1);
        return ex_var+1;
    }


    private int partition(T[][] elements, int left, int right, int checkIndx) {

        // In-Place swapping of elements
        Order order = this.getOrder();
        T[] pivotElement = elements[right-1];
        int moveIndx = left - 1;
        for (int i = left; i < right-1; i++) {

            if (this.compare(elements[i][checkIndx], pivotElement[checkIndx])) {
                moveIndx++;
                swapElements(elements, i, moveIndx);
            }
        }

        // Put pivot element in the middle
        swapElements(elements, right-1, moveIndx+1);

        return moveIndx+1; // pivot index
    }


    private int partition(int[][] elements, int left, int right, int checkIndx) {

        // In-Place swapping of elements
        Order order = this.getOrder();
        int[] pivotElement = elements[right-1];
        int moveIndx = left - 1;
        for (int i = left; i < right-1; i++) {

            if (this.compare(elements[i][checkIndx], pivotElement[checkIndx])) {
                moveIndx++;
                swapElements(elements, i, moveIndx);
            }
        }

        // Put pivot element in the middle
        swapElements(elements, right-1, moveIndx+1);

        return moveIndx+1; // pivot index
    }


    /**
     * Swaps positions of two elements in given array.
     *
     * @param elements - array of elements
     * @param from - first position
     * @param to - second position
     */
    private void swapElements(T[] elements, int from, int to) {
        T temp = elements[to];
        elements[to] = elements[from];
        elements[from] = temp;
    }

    private void swapElements(int[] elements, int from, int to) {
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
    private void swapElements(T[][] elements, int from, int to) {
        T[] temp = elements[from];
        elements[from] = elements[to];
        elements[to] = temp;
    }

    private void swapElements(int[][] elements, int from, int to) {
        int[] temp = elements[from];
        elements[from] = elements[to];
        elements[to] = temp;
    }


    // -----------------------------------
    // Utils
    // -----------------------

    private boolean compare(int first, int second) {
        if (this.getOrder() == Order.ASC) {
            return first < second;
        }
        return first > second;
    }


    private boolean compare(T o1, T o2) {

        if (this.getOrder() == Order.ASC) {
            return this.isASC(o1, o2); // Compare for ascending order
        }
        return this.isDESC(o1, o2); // Compare for descending order
    }


    /**
     * Compares two generic types for order. Defaults to ascending order.
     *
     * @param o1 - first object of generic type
     * @param o2 - second object of generic type
     * @return
     */
    private boolean isASC(T o1, T o2) {
      int compareResult = o1.compareTo(o2);

      if (compareResult < 1) {
          return true;
      }
        return false;
    }

    private boolean isDESC(T o1, T o2) {
        int comparableResult = o1.compareTo(o2);

        if (comparableResult > -1) {
            return true;
        }
        return false;
    }


    // -----------------------------------
    // Setter/-Getter
    // ----------------------------------


    public void setOrder(Order order) {
        if (order == null) {
            this.order = this.getDefaultOrder();
            return;
        }
        this.order = order;
    }

    private Order getOrder() {
        return this.order;
    }

    private Order getDefaultOrder() {
        return Order.ASC;
    }
}