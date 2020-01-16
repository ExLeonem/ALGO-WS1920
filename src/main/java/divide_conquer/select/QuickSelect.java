package divide_conquer.select;

import divide_conquer.search_sort.InsertionSort;
import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;
import supplementary.utils.ArrayUtils;

import java.util.Arrays;

/**
 * Quick Select algorithm to divider_conquer.select the nth-biggest element.
 * Partition essentially same as quick-sort.
 *
 * @author Maksim Sandybekov
 * @date 2020-1-6
 */
public class QuickSelect {

    Order order; // nth biggest | nth-smallest
    InsertionSort insertion;


    public QuickSelect() {
        this.order = Order.ASC;
        this.insertion = new InsertionSort(Order.ASC);
    }

    public QuickSelect(Order order) {
        this.order = order;
        this.insertion = new InsertionSort(order);
    }


    /**
     * Select the nth-element.
     *
     * @param items - array of items to divider_conquer.select from
     * @param nth - index of element to divider_conquer.select
     * @return the nth element
     */
    public int select(int[] items, int nth) {

        if (nth > items.length || nth <= 0) {
            throw new IllegalArgumentException("Can't divider_conquer.select the " + nth + "-element, while only " + items.length + "-elements are given."); // Can't find nth biggest number when
        }

        // Recursivly search for nth item
        int[] copyOfItems = Arrays.copyOf(items, items.length);
        return this.select(copyOfItems, 0, copyOfItems.length-1, nth-1);
    }


    private int select(int[] items, int left, int right, int nth) {

        int pivotIndx = this.medianOfMedians(items, left, right);
        pivotIndx = this.partition(items, left, right,pivotIndx);

        if (pivotIndx > nth) {
            // Pivot in left side of elements
            return this.select(items, left, pivotIndx-1, nth);
        }

        if (pivotIndx < nth) {
            // Look in right side of elements
            return this.select(items, pivotIndx+1, right, nth);
        }

        ArrayUtils.printHorizontal(items);
        return items[pivotIndx]; // Pivot index equals nth element
    }


    /**
     * Select a pivot element using the median of medians selection strategy
     *
     * @param items - items to get the pivot from
     * @param left - left border
     * @param right - right border
     * @return pivot index for next iteration
     */
    private int medianOfMedians(int[] items, int left, int right) {

        // Select 5-element chunk, calculate & return the median
        if (right-left <= 5) {

            this.insertion.sort(items, left, right);
            return left + ((right-left) / 2);
        }

        // Get median for each 5-chunk of values
        int numberOfMedians = (int) Math.ceil(right/5);
        int[] medians = new int[numberOfMedians];

        for (int i = left; i <= right -5 ; i += 5) {
            int currentMedian = i > 0? i/5 : i;
            medians[currentMedian] = this.medianOfMedians(items, i, i+5);
        }

        // Select 3 median values (outter right/left and center)
        int [][] threeMedian;
        if (medians.length > 3) {
            threeMedian = new int[3][2];
            threeMedian[0] = new int[]{items[medians[0]], medians[0]};
            threeMedian[1] = new int[]{items[medians[medians.length / 2]], medians[medians.length / 2]};
            threeMedian[2] = new int[]{items[medians[medians.length - 1]], medians[medians.length - 1]};

        } else {
            threeMedian = new int[medians.length][2];
            for (int i = 0; i < medians.length; i++) {
                threeMedian[i] = new int[]{items[medians[i]], medians[i]};
            }
        }

        // Order & select center-median out of max. 3-medians
        QuickSort qSort = new QuickSort();
        qSort.sort(threeMedian);
        int center = threeMedian.length > 0? threeMedian.length / 2 : 0;
        return threeMedian[center][1];

    }


    /**
     * Values smaller than pivot to the left, values higher than pivot to the right.
     *
     * @param items - items to partition
     * @param left - left border
     * @param right -  right border
     * @param pivotIndx - index of the pivot element
     * @return
     */
    private int partition(int[] items, int left, int right, int pivotIndx) {

        this.swap(items, pivotIndx, right);
        int pivot = items[right];
        int changeIndx = left-1;

        for (int i = left; i < right; i++) {

            if (items[i] <= pivot) {
                this.swap(items, i, ++changeIndx);
            }
        }

        // Put pivot element to pivot position
        ++changeIndx;
        this.swap(items, changeIndx, right);
        return changeIndx;
    }


    private void swap(int[] items, int fpos, int tpos) {
        int temp = items[fpos];
        items[fpos] = items[tpos];
        items[tpos] = temp;
    }
}
