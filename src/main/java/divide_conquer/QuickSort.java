package divide_conquer;

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

        // Check
        int arr_length = elements.length;
//        if(arr_length == 0 || arr_length == 1) {
//
//        }

        return QuickSort.sort(elements, 0, arr_length);
    }


    // Recurse quicksort
    private static int[] sort(int[] elements, int left, int right) {

        return elements;
    }

}
