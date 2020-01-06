package divide_conquer.search_sort;

import supplementary.structures.trees.Heap;
import supplementary.structures.trees.MaxHeap;
import supplementary.structures.trees.MinHeap;


/**
 * HeapSort:
 * Uses a max-heap for ascending order and a min-heap for descending order of element values.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-16
 */
public class HeapSort {

    private Order order;
    private Heap heap;


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

        // Build the heap
        if (this.getOrder() == Order.ASC) {
            this.heap = new MaxHeap(items);
        } else {
            this.heap = new MinHeap(items);
        }

        return this.heap.sort();
    }


    // --------------------
    // Setter-/Getter
    // --------------------

    private void setOrder(Order order) {
        this.order = order;
    }

    private Order getOrder() {
        return this.order;
    }

    public int[] getHeap() {
        return this.heap.getHeap();
    }
}
