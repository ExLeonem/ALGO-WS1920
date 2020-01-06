package supplementary.structures.trees;


import divide_conquer.search_sort.Order;

import java.util.Arrays;

/**
 * A Max-Heap.
 *
 * @author Maksim Sandybekov
 * @date 2020-1-3
 */
public class MaxHeap extends Heap {


    public MaxHeap() {
        super();
    }

    public MaxHeap(int maxSize) {
        super(maxSize);
    }

    public MaxHeap(int[] elements) {
        super(elements);
    }



    // -------------------------
    // Heap-Operations
    // -------------------------

    @Override
    public void insert(int element) {
        int size = this.getSize();
        int maxSize = this.getMaxSize();
        int[] heap = this.getHeap();

        // There's stil space in the heap
        if (size < maxSize) {
            heap[size] = element;
            this.heapifyUp(Order.ASC, heap, size);
            this.setSize(size+1);
            return;
        }

        // Create a bigger heap. There's no more space for elements in the heap.
        int[] extendedHeap = Arrays.copyOf(heap, heap.length + 1);
        this.setHeap(extendedHeap);
        this.setMaxSize(extendedHeap.length);
        this.insert(element);
    }


    @Override
    public void delete(int element) {
        // TODO: Implement
    }


    @Override
    public int[] sort() {
        return this.sort(Order.ASC);
    }


    @Override
    public int max() {
        int[] heap = this.getHeap();
        return heap[0];
    }


    @Override
    public int min() {

        int[] heap = this.getHeap();
        int height = this.getSize() / 2;

        // Single element in heap return instantly
        if (heap.length == 1) {
            return heap[0];
        }

        int min = heap[0];
        int elementsToCheck = (int) (Math.pow(2, height) + Math.pow(2, height-1));
        for (int i = 0; i < elementsToCheck && (this.getSize() - (i+1)) >= 0; i++) {
            if (min > heap[this.getSize()- (i+1)]) {
                min = heap[this.getSize() - (i+1)];
            }
        }

        return min;
    }
}
