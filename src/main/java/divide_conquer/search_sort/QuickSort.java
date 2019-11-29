package divide_conquer.search_sort;

/**
 * @author Maksim Sandybekov
 * @date 2019-11-6
 */
public class QuickSort {

    /**
     *
     * @param elements unsorted array of integers.
     * @return sorted array
     */
    public static int[] sort(int[] elements) {

        if (elements.length == 0 || elements.length == 1) {
            return elements;
        }

        // Initial recursive call
        return QuickSort.sort(elements, 0, elements.length);
    }


    // Recurse quicksort
    private static int[] sort(int[] elements, int left, int right) {

        // Base case
        if (left >= right) {
            return elements;
        }

        // Recursion
        int center = QuickSort.partition(elements, left, right);
        QuickSort.sort(elements, left, center); // sort left side
        QuickSort.sort(elements, center+1, right); // sort right side

        return elements;
    }


    private static int partition(int[] elements, int left, int right) {
        int pivotElement = elements[right-1];

        int ex_var = left-1;
        for (int i = left; i < right - 1; i++) {

            if (elements[i] < pivotElement) {
                ex_var++;
                swapElements(elements, i, ex_var);
            }
        }

        // Exchange pivot element with
        swapElements(elements, ex_var+1, right-1);
        return ex_var+1;
    }


    private static void swapElements(int[] elements, int from, int to) {
        int temp = elements[to];
        elements[to] = elements[from];
        elements[from] = temp;
    }

}
