package supplementary.structures.trees;

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

    /**
     * Insert a new element into the heap
     *
     * @param element - elment to insert into the heap
     */
    public void insert(int element) {

        int size = this.getSize() + 1;
        int maxSize = this.getMaxSize();
        int[] heap = this.getHeap();

        if (size < maxSize) {
            heap[size] = element;
            this.setSize(size);
            return;
        }

        int[] biggerHeap = Arrays.copyOf(heap, heap.length+1);
        this.setHeap(biggerHeap);
        this.setMaxSize(++maxSize);
        this.insert(element);
    }


    /**
     * Delete an element from the heap.
     *
     * @param element - the element to delete from the heap
     */
    @Override
    public void delete(int element) {

    }


    /**
     *
     * @return
     */
    @Override
    public int max() {
        return 0;
    }


    /**
     *
     * @return
     */
    @Override
    public int min() {
        return 0;
    }


    // ----------------------
    // Utilities
    // ----------------------

    /**
     * Min-Heapiefs the tree.
     *
     * @param pos - position from where to start to heapify from
     */
    @Override
    protected void heapify(int pos) {

    }

}
