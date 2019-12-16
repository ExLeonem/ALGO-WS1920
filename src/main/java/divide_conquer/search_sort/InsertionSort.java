package divide_conquer.search_sort;

public class InsertionSort {


    /**
     * Perform insertion sort on items.
     *
     * @param items - array with integer values to sort.
     * @return sorted integer array
     */
    public int[] sort(int[] items) {

        if (items.length <= 1) {
            return items;
        }

        this.sort(items, 0, items.length);
        return items;
    }

    /**
     * Sort a sub-array in-place with insertion-sort.
     *
     * @param items - items to sort
     * @param left - left border of items to sort
     * @param right - right border of items to sort
     */
    public void sort(int[] items, int left, int right) {


        for (int i = left; i < items.length; i++) {

            // Sort items till this position
            for (int j = left; j >= 0; j--) {

                if (items[i] < items[j]) {

                }

            }
        }
    }


    /**
     * Shift items from left border to right border
     * @param items
     * @param left
     * @param right
     */
    private void shiftItems(int[] items, int left, int right) {

    }
}
