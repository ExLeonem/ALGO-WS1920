package supplementary.structures.trees;


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

    /**
     * Insert a new element into the heap.
     *
     * @param element - the element to insert into the heap
     */
    @Override
    public void insert(int element) {
        int size = this.getSize();
        int maxSize = this.getMaxSize();
        int[] heap = this.getHeap();

        // There's stil space in the heap
        if (size < maxSize) {
            heap[size] = element;
            this.heapifyUp(size);
            this.setSize(size + 1);
            return;
        }

        // Create a bigger heap. There's no more space for elements in the heap.
        int[] extendedHeap = Arrays.copyOf(heap, heap.length + 1);
        this.setHeap(extendedHeap);
        this.setMaxSize(extendedHeap.length);
        this.insert(element);
    }


    /**
     * Deletes an element from the heap.
     *
     * @param element - the element to delete from the heap
     */
    @Override
    public void delete(int element) {

    }


    /**
     * Search and return the max element of the tree.
     *
     * @return max element of the tree
     */
    public int max() {
        int[] heap = this.getHeap();
        return heap[0];
    }


    /**
     * Searches and return the min element of the heap. No deletion of element.
     *
     * @return the min element of the tree
     */
    @Override
    public int min() {

        int[] heap = this.getHeap();
        int size = this.getSize();
        int min = heap[0];

        int leftChild = this.leftChild(0);
        int rightChild = this.rightChild(0);
        while ((this.posInRange(leftChild)& leftChild <= size) || (this.posInRange(rightChild) && rightChild <= size)) {

            if (heap[leftChild] < heap[rightChild]) {
                // left Child is smaller
            }


            if (heap[leftChild] > heap[rightChild]) {
                // right child is smaller
            }
        }


        return min;
    }



    // -----------------------
    // Utilities
    // -----------------------

    @Override
    protected void heapifyDown(int pos) {

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
                this.heapifyDown(indx);
            } else {
                int indx = this.rightChild(pos);
                this.swap(pos, indx);
                this.heapifyDown(indx);
            }
        }
    }


    @Override
    protected void heapifyUp(int pos) {

        // At the root of elements
        int currentParent = this.parent(pos);
        if (currentParent == -1) {
            return;
        }

        int[] heap = this.getHeap();
        if (heap[currentParent] < heap[pos]) {
            this.swap(currentParent, pos);
            this.heapifyUp(currentParent);
        }
    }

}
