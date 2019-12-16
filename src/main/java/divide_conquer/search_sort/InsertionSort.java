package divide_conquer.search_sort;

import java.util.Arrays;

public class InsertionSort {


    private Order order;


    public InsertionSort(Order order) {
        this.order = order;
    }

    public InsertionSort() {
        this.order = Order.ASC;
    }



    /**
     * Perform insertion sort on items.
     *
     * @param items - array with integer values to sort.
     * @return sorted integer array
     */
    public int[] sort(int[] items) {

        // Edge case, more elements needed to perform sorting
        if (items.length <= 1) {
            return items;
        }

        System.out.println("Array: " + Arrays.toString(items));
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

        for (int i = left; i < right; i++) {

            // Sort items till this position
            int lastIndx = i;
            for (int j = i; j >= 0; j--) {

                // Identify index of item
//                System.out.println("Shift Item left + [" + items[i] + "] + [" + items[j] + "]");
                if (this.getOrder().inOrder(items[i], items[j])) {
                    lastIndx = j;
                }
            }

            // Shift all items after indx to the right
            this.shiftItems(items, lastIndx, i);
//            System.out.println("Shifted: " + Arrays.toString(items));
//            System.out.println("------------------------");
        }
    }


    /**
     * Shift items from left border to right border
     *
     * @param items - items to shift to the right
     * @param rightIndx - Index where to start shifting
     * @param valueIndx - right outter index to which to shift items
     */
    private void shiftItems(int[] items, int rightIndx, int valueIndx) {

        // Last element needs to be put to place
        int temp = items[valueIndx];

//        System.out.println("Right: " + rightIndx);
//        System.out.println("Value-Indx: " + valueIndx);
        // Shift items
        for (int i = valueIndx; i > rightIndx; i--) {
//            System.out.println("Swap: [" + i + "] mit [" + (i-1) + "]");
            swap(items, i, i-1);
        }

        items[rightIndx] = temp;
    }


    /**
     * Swap the positions of two items.
     *
     * @param items - the items to switch
     * @param from - swap from this index to the other
     * @param to - swap to this index
     */
    private void swap(int[] items, int from, int to) {

        int temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }


    // -------------------------
    // Setter/-Getter
    // -------------------------

    private Order getOrder() {
        return this.order;
    }

    private void setOrder(Order order) {
        this.order = order;
    }

}
