package supplementary.structures.trees;

import divide_conquer.search_sort.Order;

import java.nio.channels.FileLockInterruptionException;
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

    final int DEFAULT_MAX_SIZE = 5;

    private int[] heap;
    private int size;
    private int maxSize;


    public Heap() {
        this.maxSize = DEFAULT_MAX_SIZE;
        this.size = 0;
        this.heap = new int[this.maxSize];
    }


    public Heap(int maxSize) {

        // Only Heaps with at least 1 element
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Can't create which contains less than 0 - elements.");
        }

        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }


    public Heap(int[] elements) {

        this.maxSize = elements.length;
        this.size = 0;

        // Insert values into heap
        this.heap = new int[elements.length];
        for (int element: elements) {
            this.insert(element);
        }
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

        // Index out of range, no parent node
        if (pos <= 0) {
           return -1;
        }

        return (pos - 1) / 2;
    }


    /**
     * Request position of left child.
     *
     * @param pos - child position
     * @return
     */
    protected int leftChild(int pos) {

        // Index out of range, no left child
        if (pos < 0) {
            return -1;
        }

        return (pos * 2) + 1;
    }


    /**
     * Request position of right child.
     *
     * @param pos - child position
     * @return
     */
    protected int rightChild(int pos) {

        // index out of range, no right child
        if (pos < 0) {
            return -1;
        }

        return (pos * 2) + 2;
    }


    /**
     * Check if node at given position is a leaf of the binary tree.
     *
     * @param pos - position of the element to check
     * @return true if node is leaf else false
     */
    protected boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
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
     * Performs an heap sort on the elements of the heap.
     *
     * @param order - the order of elements
     */
    protected int[] sort(Order order) {
        int[] heap = Arrays.copyOf(this.getHeap(), this.getHeap().length);
        if (heap.length <= 1) {
            return heap;
        }

        // Iterate till first position (fp) >= last position (lp)
        int lpos = this.getSize() - 1;
        int fpos = 0;
        while(fpos < lpos-1) {

            this.swap(heap, fpos, lpos);
            this.heapifyDown(order, heap, fpos, lpos);
            lpos--;
        }

        if (!order.inOrder(heap[fpos], heap[lpos])) {
            this.swap(heap, fpos, lpos);
        }

        return heap;
    }

    public abstract int[] sort();


    /**
     * Gets element at the specified position.
     *
     * @param pos - element position
     * @return the element at given position
     *
     */
    public int get(int pos) {
        int[] heap = this.getHeap();
        return heap[pos];
    }

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


    protected void swap(int[] elements, int fpos, int tpos) {
        int temp = elements[fpos];
        elements[fpos] = elements[tpos];
        elements[tpos] = temp;
    }

    /**
     * Checks wether position exists in the current tree.
     *
     * @param pos - position to check
     * @return -1 (position is to small) | 0 (position in range) | 1 (position to big)
     */
    protected boolean posInRange(int pos) {

        // Position to small
        if (pos >= 0 && pos < maxSize) {
            return true;
        }

        return false;
    }


    /**
     * Recursivly heapify the element at given position down the tree.
     *
     * @param heap - heap to perfom the heapify operation on
     * @param pos - position from where to start to heapify from
     * @param maxDepth - the maxmium depth to which heapify the heap
     */
    protected void heapifyDown(Order order, int heap[], int pos, int maxDepth) {
        if (this.isLeaf(pos) || pos >= maxDepth) {
            return;
        }

        int leftIndx = this.leftChild(pos);
        int rightIndx = this.rightChild(pos);

        if (this.posInRange(leftIndx) && this.posInRange(rightIndx) && leftIndx < maxDepth && rightIndx < maxDepth) {

            int leftChild = heap[leftIndx];
            int rightChild = heap[rightIndx];
            if (order.inOrder(heap[pos], leftChild) || order.inOrder(heap[pos], rightChild)) {

                if (!order.inOrder(leftChild, rightChild)) {
                    this.swap(heap, pos, leftIndx);
                    this.heapifyDown(order, heap, leftIndx, maxDepth);

                } else {
                    this.swap(heap, pos, rightIndx);
                    this.heapifyDown(order, heap, rightIndx, maxDepth);
                }
            }

        } else if (this.posInRange(leftIndx) && order.inOrder(heap[pos], heap[leftIndx]) && leftIndx < maxDepth) {
            this.swap(heap, pos, leftIndx);
            this.heapifyDown(order, heap, leftIndx, maxDepth);

        } else if (this.posInRange(rightIndx) && order.inOrder(heap[pos], heap[rightIndx]) && rightIndx < maxDepth) {
            this.swap(heap, pos, rightIndx);
            this.heapifyDown(order, heap, rightIndx, maxDepth);
        }
    }


    /**
     * Recursivly heapify the element at given position up.
     *
     * @param heap - elements to perform heapify operation on
     * @param pos - element position
     */
    protected void heapifyUp(Order order, int[] heap, int pos) {
        // At the root of elements
        int currentParent = this.parent(pos);
        if (currentParent == -1) {
            return;
        }


        if (order.inOrder(heap[currentParent], heap[pos])) {
            this.swap(currentParent, pos);
            this.heapifyUp(order, heap, currentParent);
        }
    }


    /**
     * Print the max heap to the terminal
     */
    public void print() {

        int[] heap = this.getHeap();
        int size = this.getSize();
        int maxSize = this.getMaxSize();

        System.out.println("++++++++++++++++++\nSize: " + size + "\nMax-Size: " + maxSize + "\n++++++++++++++++++++++++++");

        for (int i = 0; i < size; i++) {

            String toPrint = "Parent: " + heap[i];

            int leftChild = this.leftChild(i);
            if (this.posInRange(leftChild) && leftChild < size) {
                toPrint += "\n(" + leftChild + ") Left: " + heap[leftChild];
            }

            int rightChild = this.rightChild(i);
            if (this.posInRange(rightChild) && rightChild < size) {
                toPrint += "\n(" + rightChild + ") Right: " + heap[rightChild];
            }

            System.out.println(toPrint + "\n-------------------");
        }
    }


    /**
     *
     * @return current heap as an array
     */
    public int[] toArray() {
        return this.getHeap();
    }


    /**
     * Puts the heap into an array. Uses the nodes at given positions.
     *
     * @param fpos - from position to take
     * @param tpos - to position to take
     * @return returns an array slice
     */
    public int[] toArray(int fpos, int tpos) {

        // From position must be greater than to position
        if (fpos >= tpos) {
            throw new IllegalArgumentException("Expection (toArray/2):  Can't slice binary heap. From-Position (fpos) greater or equals to To-Position (tpos). Try to exchange the positions.");
        }

        if (fpos <= 0) {
            throw new IllegalArgumentException("Expection (toArray/2): Can't slice because From-Position (fpos) is smaller than zero.");
        }

        int maxSize = this.getMaxSize();
        if (tpos >= maxSize) {
            throw new IllegalArgumentException("Expection (toArray/2): Can't slice tree because To-Position (tpos) is greater than max. heap size.");
        }

        // Create, copy values and return new array
        int[] slicedArray = new int[tpos - fpos];
        int[] heap = this.getHeap();
        for (int i = fpos; i < tpos; i++) {
            slicedArray[i%fpos] = heap[i];
        }

        return slicedArray;
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

