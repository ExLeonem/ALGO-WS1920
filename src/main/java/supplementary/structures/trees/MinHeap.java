package supplementary.structures.trees;

import divide_conquer.search_sort.Order;

import java.util.Arrays;

public class MinHeap extends Heap {


    public MinHeap() {
        super();
    }

    public MinHeap(int maxSize) {
        super(maxSize);
    }

    public MinHeap(int[] elements) {
        super(elements);
    }



    // ------------------------
    // Operations
    // ------------------------

    @Override
    public void insert(int element) {

        int size = this.getSize();
        int maxSize = this.getMaxSize();
        int[] heap = this.getHeap();

        if (size < maxSize) {
            heap[size] = element;
            this.heapifyUp(Order.DESC, heap, size);
            this.setSize(size + 1);
            return;
        }

        int[] biggerHeap = Arrays.copyOf(heap, heap.length + 1);
        this.setHeap(biggerHeap);
        this.setMaxSize(++maxSize);
        this.insert(element);
    }


    @Override
    public void delete(int element) {
        // TODO: Impelement
    }


    @Override
    public int[] sort() {
        return this.sort(Order.DESC);
    }


    @Override
    public int max() {

        int[] heap = this.getHeap();
        int height = this.getSize() / 2;

        int elementsToCheck = (int) (Math.pow(2, height) + Math.pow(2, height-1));
        int max = heap[0];
        for (int i = 0; i < elementsToCheck && (this.getSize() - (i+1) >= 0); i++) {

            if (heap[this.getSize() - (i+1)] > max) {
                max = heap[this.getSize() - (i+1)];
            }
        }

        return max;
    }


    @Override
    public int min() {
        int[] heap = this.getHeap();
        return heap[0];
    }
}
