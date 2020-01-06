package divide_conquer.search_sort;

import java.util.Random;

/**
 * Combination of Heap-, Quick and Insertionsort.
 * - Heap: when getting into deep recursions to prevent QuickSort worst-case
 * - Insert: when the amount of elements is small
 *
 * Max. Recursion depth: 2*logn(N) (if reached -> switch to heapsort)
 * If partition size to small Quick-Sort decays to Insertion-sort (cutoff at 16)
 *
 * The quick-sort additionally uses the media-of-three strategy and choses the first pivot randomly
 *
 *
 * @author Maksim Sandybekov
 * @date 2019-12-16
 */
public class IntroSort<T extends Comparable> {


    private InsertionSort insertion;
    private HeapSort heap;
    private int depthLimit;
    private int partitionSize; // For switching to Insertion-sort
    private int nextPivotIndx; //
    private Random randomizer;


    public IntroSort() {
        this.partitionSize = 16;
        this.insertion = new InsertionSort();
        this.heap = new HeapSort();
    }

    // ----------------------------------
    // Sort-Integer-Arrays
    // ----------------------------------

    public int[] sort(int[] items) {

        if (items.length <= 1) {
            return items;
        }

        int depthLimit = (int) (2 * Math.log(items.length)); // Depth limit to switch to heap-sort
        this.recurseIntroSort(items, 0, items.length - 1, depthLimit);
        return items;
    }


    /**
     * Divide and Conquer step of Intro-Sort.
     *
     * @param items - items to sort.
     * @param left - left border.
     * @param right - right border
     */
    private void recurseIntroSort(int[] items, int left, int right, int depthLimit) {

        // Switch to Insertion-Sort (less than 16-items in sub-problem)
        if ((right - left) <= this.getPartitionSize()) {
            System.out.println("Perform insertion sort");
            this.getInsertion().sort(items, left, right+1);
            return;
        }

        // Depth Limit reached, switch to HeapSort
        if (depthLimit <= 0) {

            // Copy array slice into new array
            int tempArrayLength = right - left;
            int[] temp =  new int[tempArrayLength];
            int maxLeft = left == 0? 1 : left;
            for (int i = left; i < right; i++) {
                temp[i%maxLeft] = items[i];
            }

            // Perform Heap-Sort on array slice
            HeapSort heap = this.getHeap();
            heap.sort(temp);

            // Copy sorted values back into main array
            for (int i = left; i < right; i++) {
                items[i] = temp[i%maxLeft];
            }
            return;
        }


        if (left > right) {
            return;
        }

        // Recurse
        System.out.println("Perfomr recursion");
        int pivot = this.partition(items, left, right);
        this.recurseIntroSort(items, left, pivot, --depthLimit);
        this.recurseIntroSort(items, pivot, right, --depthLimit);
    }


    /**
     * Sort a sub-array into left & right parts
     *
     * @param items - items to sort
     * @param left - left border from which to start the sorting
     * @param right - right border marks the point to which all elements should be partitioned
     */
    private int partition(int[] items, int left, int right) {

        int pivotIndx = this.getNextPivotIndx();
        if (pivotIndx == -1) {
            Random rand = this.getRandomizer();
            pivotIndx = rand.nextInt(right-left) + left;
        }

        // Partition item values
        for (int i = left; i < right; i++) {

        }



        return pivotIndx;
    }


    /**
     * Swap operations of Intro-Sort for integer values.
     *
     * @param items - items to sort
     * @param from - swap item from index.
     * @param to - swap item to this index.
     */
    private void swap(int[] items, int from , int to) {
        int temp = items[from];
        items[from] = items[to];
        items[to] = temp;
    }


    /**
     *
     * @param items
     * @param from
     * @param to
     */
    private void medianOfMedians(int[] items, int from, int to) {



    }


    // ---------------------------------
    // Sort-Generic items
    // ---------------------------------

    /**
     * Sorts a set of items and returns the sorted set.
     *
     * @param items - set of unsorted items
     * @return sorted items
     */
    public T[] sort(T[] items) {

        if (items.length <= 1) {
            return items;
        }


        this.recurseSortItems(items, 0, items.length - 1);
        return items;
    }


    private void recurseSortItems(T[] items, int left, int right) {

        // Small enough partition size to perform Insertion-Sort
        if (this.getPartitionSize() > (right - left)) {
            this.insertionSort(items, left, right);
            return;
        }
    }


    /**
     * Insertion sort.
     *
     * @param items
     * @param left
     * @param right
     */
    private void insertionSort(T[] items, int left, int right) {

        //
        int pivotIndex = this.getNextPivotIndx();
        if (pivotIndex == -1) {
            Random randomizer = this.getRandomizer();
            pivotIndex = randomizer.nextInt(right - left) + left;
        }

        for (int i = left; i < right; i++) {
            break;
        }
    }


    private void swap(T[] items, int from, int to) {
        T tmp = items[to];
        items[to] = items[from];
        items[from] = tmp;
    }


    // -----------------------
    // Setter/-Getter
    // -----------------------

    private void setPartitionSize(int partitionSize) {
        this.partitionSize = partitionSize;
    }

    private void setDepthLimit(int depthLimit) {
        this.depthLimit = depthLimit;
    }

    private void setNextPivotIndx(int nextPivotIndx) {
        this.nextPivotIndx = nextPivotIndx;
    }

    private InsertionSort getInsertion() {
        return this.insertion;
    }

    private HeapSort getHeap() {
        return this.heap;
    }

    private int getDepthLimit() {
        return this.depthLimit;
    }

    private int getPartitionSize() {
        return this.partitionSize;
    }

    private int getNextPivotIndx() {
        return this.nextPivotIndx;
    }

    private Random getRandomizer() {
        return this.randomizer;
    }
}
