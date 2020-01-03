package divide_conquer.search_sort;

import supplementary.structures.trees.Heap;

import java.util.Arrays;

/**
 *
 * @author Maksim Sandybekov
 * @date 2019-12-16
 */
public class HeapSort {

    private Heap heap;
    private Order order;


    public HeapSort() {
        this.order = Order.ASC;
    }

    public HeapSort(Order order) {
        this.order = order;
    }



    // ---------------
    //

    /**
     * Performs an heap sort on a specific amount of elements.
     *
     * @param items - element to sort.
     * @return sorted array
     */
    public int[] sort(int[] items) {

        // Array to small to sort
        if (items.length <= 1) {
            return items;
        }

        this.sort(items, 0, items.length);
        return items;
    }


    private void sort(int[] items, int left, int right) {

    }



    // --------------------
    // Setter-/Getter
    // --------------------

    private void setMaxHeap(Heap heap) {
        this.heap = heap;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return this.order;
    }
}
