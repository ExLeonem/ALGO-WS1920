package dynamic_programming;

import divide_conquer.search_sort.QuickSort;

/**
 * KnapSack Problem which items to use to get most benefit?
 *
 * @author Maksim Sandybekov
 * @date 2019-12-11
 */
public class KnapSack {

    private int space;
    private int[] lastItemsIndxCache;


    public KnapSack(int space) {
        this.space = (int) space;
    }


    public int[] optimize(int[][] items, int space) {
        this.setSpace(space);
        return this.optimize(items);
    }


    public int[] optimize(int[][] items) {

        QuickSort quickSort = new QuickSort();

        int totalSpace = this.getSpace();
        int[][] dynamicField = new int[items.length][];





        return new int[]{};
    }


    // ----------------------
    // Setter/-Getter
    // ----------------------

    private void setSpace(int space) {
        this.space = space;
    }

    private void setLastItemsIndxCache(int[] lastItemsCache) {
        this.lastItemsIndxCache = lastItemsCache;
    }

    private int getSpace() {
        return this.space;
    }

    public int[] lastItems() {
        return this.lastItemsIndxCache;
    }
}
