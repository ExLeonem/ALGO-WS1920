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
        int size = this.getSize() + 1;
        int maxSize = this.getMaxSize();
        int[] heap = this.getHeap();

        if (size < maxSize) {
            heap[size] = element;
            this.setSize(size);
            return;
        }

        int[] biggerHeap = Arrays.copyOf(heap, heap.length + 1);
        this.setHeap(biggerHeap);
        this.setMaxSize(++maxSize);
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
        int size = this.getSize() -1;

        int popped = heap[1];
        heap[1] = heap[size];
        heapify(1);

        this.setSize(size);

        return popped;
    }


    /**
     * Searches and return the min element of the heap. No deletion of element.
     *
     * @return the min element of the tree
     */
    @Override
    public int min() {
        return 2;
    }



    // -----------------------
    // Utilities
    // -----------------------

    /**
     * Max-Heapiefy the binary tree.
     *
     * @param pos - position from where to start to heapify from
     */
    protected void heapify(int pos) {

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
                this.heapify(indx);
            } else {
                int indx = this.rightChild(pos);
                this.swap(pos, indx);
                this.heapify(indx);
            }
        }

    }
}
