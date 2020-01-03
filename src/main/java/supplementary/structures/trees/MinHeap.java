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

        int[] heap = this.getHeap();
        int size = this.getSize();
        int max = heap[0];

        int leftChild = this.leftChild(0);
        int rightChild = this.rightChild(0);


        return 1;
    }


    /**
     *
     * @return
     */
    @Override
    public int min() {
        int[] heap = this.getHeap();
        return heap[0];
    }


    // ----------------------
    // Utilities
    // ----------------------

    @Override
    protected void heapifyDown(int pos) {

    }


    @Override
    protected void heapifyUp(int pos) {

    }

}
