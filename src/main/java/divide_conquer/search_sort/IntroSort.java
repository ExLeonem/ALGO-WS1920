package divide_conquer.search_sort;

/**
 * Combination of Heap-, Quick and Insertionsort.
 * - Heap: when getting into deep recursions to prevent QuickSort worst-case
 * - Insert: when the amount of elements is small
 *
 * Max. Recursion depth: 2*logn(N)
 * If partition size to small Quick-Sort decays to Insertion-sort (cutoff at 16)
 *
 * The quick-sort additionally uses the media-of-three strategy.
 *
 *
 * @author Maksim Sandybekov
 * @date 2019-12-16
 */
public class IntroSort<T extends Comparable> {


    private int depthLimit;
    private int partitionSize; // For switching to Insertion-sort


    public IntroSort() {
        this.depthLimit = 0;
        this.partitionSize = 16;
    }


    /**
     * Sorts a set of items and returns the sorted set.
     *
     * @param items - set of unsorted items
     * @return sorted items
     */
    public T[] search(T[] items) {

        if (items.length <= 1) {
            return items;
        }


        this.recurseSortItems(items, 0, items.length);
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
        for (int i = left; i < right; i++) {


        }
    }


    /**
     * Perform an heap-sort on a set of items.
     *
     * @param items - items to be sorted
     */
    private void heapSort(T[] items) {

    }



    private void swapItems(T[] items, int from, int to) {
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

    private int getDepthLimit() {
        return this.depthLimit;
    }

    private int getPartitionSize() {
        return this.partitionSize;
    }

}
