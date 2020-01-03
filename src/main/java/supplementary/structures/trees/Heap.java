package supplementary.structures.trees;

import java.util.Arrays;

/**
 * Heap datastructure
 * Basic Operations implemented:
 * - Insertion, Deletion
 * - Heapify
 * - Search (children,
 *
 * @author Maksim Sandybekov
 * @date 2020-1-3
 */
public abstract class Heap {

    private int[] heap;
    private int size;
    private int maxSize;

    public Heap() {
        this.maxSize = 5;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize+1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    public Heap(int[] elements) {
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
    protected int parent(int pos) {
        return pos / 2;
    }


    /**
     * Request position of left child.
     *
     * @param pos - child position
     * @return
     */
    protected int leftChild(int pos) {
        return pos * 2;
    }


    /**
     * Request position of right child.
     *
     * @param pos - child position
     * @return
     */
    protected int rightChild(int pos) {
        return (pos * 2) + 1;
    }


    /**
     * Check if node at given position is a leaf of the binary tree.
     *
     * @param pos - position of the element to check
     * @return true if node is leaf else false
     */
    protected boolean isLeaf(int pos) {
        return  pos >= (size / 2) && pos <= size;
    }



    // ----------------------
    // Operations
    // ----------------------

    /**
     * Inserts a new element into the heap.
     *
     * @param element - the element to insert into the heap
     */
    public abstract void insert(int element);


    /**
     * Deletes the element from the heap if it is existent.
     *
     * @param element - the element to delete from the heap
     */
    public abstract void delete(int element);


    /**
     * Searches the tree for the max value.
     *
     * @return max value of the tree
     */
    public abstract int max();


    /**
     * Searches the tree for the min value.
     *
     * @return min value of the tree.
     */
    public abstract int min();


    // -------------------------
    // Utilties
    // -------------------------

    /**
     * Swap values at positions of the heap.
     *
     * @param fpos - from position
     * @param tpos - to position
     */
    protected void swap(int fpos, int tpos) {
        int[] heap = this.getHeap();
        int temp = heap[fpos];
        heap[fpos] = heap[tpos];
        heap[tpos] = temp;
    }


    /**
     * Recursive function. Heapiefy the tree.
     *
     * @param pos - position from where to start to heapify from
     */
    protected abstract void heapify(int pos);


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

    protected void setHeap(int[] heap) {
        this.heap = heap;
    }

    protected void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    protected void setSize(int size) {
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

