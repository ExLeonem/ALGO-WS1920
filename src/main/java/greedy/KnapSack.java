package greedy;

import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;
import supplementary.utils.ArrayUtils;
import java.util.LinkedList;


/**
 *
 * @author Maksim Sandybekov
 * @date 2019-12-4
 */
public class KnapSack {

    private int size;
    private int currentSize;
    private int[][] items;
    private int optim;


    public KnapSack() {
        this.size = 5;
        this.currentSize = 0;
        this.optim = 0;
    }

    public KnapSack(int size) {
        this.size = size;
        this.currentSize = 0;
        this.optim = 0;
    }


    /**
     *  Collect items trying maximize the benefit in regard to knappsack size.
     *  Result is saved in instance attributes and will be overwritten on recalculation.
     *
     * @param itemValues - available items of format [weight/size, benefit]
     * @return - array with indices of items to use
     */
    public int[] minValues(int[][] itemValues) {
        return this.calculat(itemValues, Order.ASC);
    }

    public int[] maxValues(int[][] itemValues) {
        return this.calculat(itemValues, Order.DESC);
    }


    private int[] calculat(int[][] elements, Order order) {

        // Presort items on benefit O(n log n)
        int[][] sortedItemValues = QuickSort.sort(elements, 1, order);

        // Greedy condition: Select items with max value
        LinkedList<Integer> knappsack = new LinkedList<Integer>();
        LinkedList<int[]> items = new LinkedList<int[]>();
        int sackSize = this.getSize();
        int currentSize = 0;
        int itemIndx = 0;
        int[] currentElement;
        while (sackSize > currentSize && itemIndx < elements.length) {

            // Keep track of items and current weight
            currentElement = elements[itemIndx];

            // Item fits into knapsack
            if (currentElement[0]+currentSize <= sackSize) {
                knappsack.add(currentElement[1]);
                items.add(currentElement);
                currentSize += currentElement[0];
            }

            itemIndx++;
        }

        // Save result into class-attributes
        int[] knappsackValues = ArrayUtils.listToArray(knappsack);
        int[][] knappsackItems = ArrayUtils.nestedIntListToArray(items);
        int optim = knappsack.stream().reduce(0, (subtotal, element) -> subtotal + element);

        this.setOptim(optim);
        this.setItems(knappsackItems);
        this.setCurrentSize(knappsackValues.length);

        return knappsackValues;
    }


    // ----------------------------
    // Setter/-Getter
    // ----------------------------

    public void setItems(int[][] items) {
        this.items = items;
    }

    public void setOptim(int optim) {
        this.optim = optim;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getSize() {
        return this.size;
    }

    public int getOptim() {
        return this.optim;
    }

    public int[][] getItems() {
        return this.items;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

}
