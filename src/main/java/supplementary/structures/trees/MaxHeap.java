package supplementary.structures.trees;

import java.util.Arrays;

/**
 * MaxHeap structure.
 *
 * @date 2020-1-3
 */
public class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize+1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    public MaxHeap(int[] elements) {
        this.maxSize = elements.length;
        this.size = elements.length;
        this.heap = Arrays.copyOf(elements , elements.length);
    }



    // -----------------------
    // Traverse operations
    // -----------------------

    /**
     * Request position of parent.
     *
     * @param pos - parent of node at this position
     * @return - parent position
     */
    private int parent(int pos) {
        return pos / 2;
    }


    /**
     * Request position of left child.
     *
     * @param pos - child position
     * @return
     */
    private int leftChild(int pos) {
        return pos * 2;
    }


    /**
     * Request position of right child.
     *
     * @param pos - child position
     * @return
     */
    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }


    /**
     * Check if node at given position is a leaf of the binary tree.
     *
     * @param pos - position of the element to check
     * @return true if node is leaf else false
     */
    private boolean isLeaf(int pos) {
        return  pos >= (size / 2) && pos <= size;
    }



    // ----------------------
    // Operations
    // ----------------------

    /**
     * Swap values at positions of the heap.
     *
     * @param fpos - from position
     * @param tpos - to position
     */
    private void swap(int fpos, int tpos) {
        int[] heap = this.getHeap();
        int temp = heap[fpos];
        heap[fpos] = heap[tpos];
        heap[tpos] = temp;
    }


    /**
     * Recursive function. Max-heapifies the tree.
     *
     * @param pos - position from where to start to heapify from
     */
    private void maxHeapify(int pos) {

        if (this.isLeaf(pos)) {
            return;
        }

        int[] heap = this.getHeap();
        int leftChild = heap[this.leftChild(pos)];
        int rightChild = heap[this.rightChild(pos)];
        if (heap[pos] < leftChild || heap[pos] < rightChild) {

            if (leftChild > rightChild) {
                int indx = this.leftChild(pos);
                this.swap(pos, indx);
                this.maxHeapify(indx);
            } else {
                int indx = this.rightChild(pos);
                this.swap(pos, indx);
                this.maxHeapify(indx);
            }
        }

    }


    /**
     * Insert a new element into the heap.
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
     * Remove and return the max-element from the heap.
     * @return
     */
    public int extractMax() {
        int[] heap = this.getHeap();
        int size = this.getSize() -1;

        int popped = heap[1];
        heap[1] = heap[size];
        maxHeapify(1);

        this.setSize(size);

        return popped;
    }


    // -------------------------
    // Utilties
    // -------------------------

    /**
     * Print the max heap to the terminal
     */
    public void print() {

        int[] heap = this.getHeap();
        for (int i = 0; i <= size / 2; i++) {
            System.out.println("Parent: " + heap[i] +
                    "\n (Child) Left: " + heap[i*2] +
                    "\n (Child) Right: " + heap[i*2+1] +
                    "----------------------------------");
        }
    }



    // -------------------------
    // Setter-/Getter
    // -------------------------

    private void setHeap(int[] heap) {
        this.heap = heap;
    }

    private void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    private void setSize(int size) {
        this.size = size;
    }


    public int[] getHeap() {
        return heap;
    }

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }
}

