package divide_conquer.select;

/**
 * Median finding algorithm using Median of Three (Killer) strategy.
 *
 * @author Maksim Sandybekov
 * @date 2020-6-1
 */
public class MedianFinding {


    private int select(int[] items) {

        return 0;
    }


    private void medianOfThree() {

    }


    /**
     * Select the median from the given elements.
     *
     * @param items - items from which to divider_conquer.select the median
     * @return the median
     */
    private int selectMedianValue(int[] items) {
        return MedianFinding.selectMedianValue(items, 0, items.length);
    }


    protected static int selectMedianValue(int[] items, int left, int right) {

        int center = left + ((right-left) / 2);
        if ((right - left + 1) % 2 == 0) {
            return (items[center] + items[center+1]) / 2;
        }

        return items[center];
    }


    protected static int selectMedian(int[] items, int left, int right) {
        int center = left + ((right-left) / 2);
        return items[center];
    }
}
