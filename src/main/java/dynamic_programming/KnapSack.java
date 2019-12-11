package dynamic_programming;

import supplementary.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;


/**
 * KnapSack Problem which items to use to get most benefit?
 *
 * @author Maksim Sandybekov
 * @date 2019-12-11
 */
public class KnapSack {

    private int space; // defaults to 5
    private int[] lastItemsIndxCache;

    // Attributes getting reset after fit call
    private int[][][] subProblemField;
    private int[][][] previousWeightBenefit;
    private int[][] items;

    /**
     * Ansatz zum kleinhalten der speicher größe für die Zwischenergebnisse?
     * -> GGT über die Gewichte & die maximale Rucksack größe finden
     * -> Maximale Rucksack größe durch GGT teilen
     * -> Jede Zelle ist so groß wie GGT
     */


    public KnapSack() {
        this.space = 5;
    }

    public KnapSack(int space) {
        this.space = (int) space;
    }


    public int[] fit(int[][] items, int space) {
        this.setSpace(space);
        return this.fit(items);
    }


    public int[] fit(int[][] items) {

        int totalSpace = this.getSpace();
        int[][][] subProblemField = new int[items.length][totalSpace][]; // Collect used item dimensions
        int[][][] previousWeightBenefit = new int[items.length][totalSpace][]; // lookup table for previously calculated [0]: weight, [1]: benefit

        // Iterate over items of knapsack
        for (int i = 0; i < subProblemField.length; i++) {
            int[] currentItem = items[i]; // 0: weight, 1: benefit

            // Iterate over knapsack sub-weights
            for (int j = 0; j < subProblemField[i].length; j++) {

                // Edge case: first line or first sub-problem (pack size == 1)
                boolean updateEdgeCase = this.updateEdgeCase(i, j);
                if (updateEdgeCase) {
                    continue;
                }

                // Compare item cells (namely above cell and previous cell) and eventually compose solution of previously calculated results
                this.updateSubProblemField(i, j);
            }
        }

        return subProblemField[subProblemField.length - 1][subProblemField[0].length - 1];
    }


    /**
     * Covers edge case for dynamic programming problem
     *  - Currently in first line of sub-problem matrix -> therefore no above elements
     *  - Currently currently selected first pack (first sub-problem)
     *
     * @param itemIndx - index i of outter for loop
     * @param packIndx - index j of inner for loop
     * @return true | false depending upon if run into edge case
     */
    private boolean updateEdgeCase(int itemIndx, int packIndx) {

        int[][][]  previousWeightBenefit = this.getPreviousWeightBenefit();
        int[][][] subProblemField = this.getSubProblemField();

        // Not an edge-case
        if (packIndx > 0 && itemIndx != 0) {
            return false;
        }

        // Currently in first line (i == 0)
        int[][] items = this.getItems();
        int[] currentItem = items[itemIndx];
        if (itemIndx == 0) {
            subProblemField[itemIndx][packIndx] = currentItem[0] <= (packIndx+1)? new int[]{itemIndx} : new int[]{};
            previousWeightBenefit[itemIndx][packIndx] = this.aggregateItemValues(subProblemField[itemIndx][packIndx]);
            return true;
        }

        // Not first line but pack size == 1
        int aboveIndx = itemIndx > 0? itemIndx-1 : itemIndx;
        int benefitAbove = itemIndx > 0? previousWeightBenefit[itemIndx-1][packIndx][1] : 0;

        subProblemField[itemIndx][packIndx] = currentItem[1] > benefitAbove && currentItem[0] <= (packIndx+1) ? (new int[]{packIndx}) : subProblemField[aboveIndx][packIndx];
        previousWeightBenefit[itemIndx][packIndx] = this.aggregateItemValues(subProblemField[itemIndx][packIndx]);
        return true;
    }


    /**
     * Run the regular case:
     *  - There is a previous cell in the same line
     *  - There is previous cell above
     *
     * @param itemIndx - current item index
     * @param packIndx - current sub problem of the cell (-1)
     */
    private void updateSubProblemField(int itemIndx, int packIndx) {

        int[][][] previousWeightBenefit = this.getPreviousWeightBenefit();
        int[][][] subProblemField = this.getSubProblemField();

        // There's still space if previous element added
        int weightBefore = previousWeightBenefit[itemIndx][packIndx - 1][0];
        int benefitBefore = previousWeightBenefit[itemIndx][packIndx - 1][1];
        int leftSpace = (packIndx + 1) - weightBefore;
        if (leftSpace > 0) {

            int[] solutionIndices = this.composeSolution();

            int[] previousItems = subProblemField[itemIndx][packIndx - 1];
//            for (int i = 0; )


            // After adding previous element no more space, but is new optimum
        }

        int weightAbove = previousWeightBenefit[itemIndx - 1][packIndx][0];
        int benefitAbove = previousWeightBenefit[itemIndx - 1][packIndx][1];
        if (cellBenefitBefore > cellBenefitAbove) {
            subProblemField[i][j] = subProblemField[i][j-1];
        }
    }


    /**
     * Compose a solution from previously resolved sub-problems.
     *
     * @param itemIndx
     * @param packIndx
     * @param spaceLeft
     * @return
     */
    public int[] composeSolution(int itemIndx, int packIndx, int spaceLeft) {




        return new int[]{};
    }


    /**
     * Merge two array of indices into single array of indices eliminating duplicates.
     *
     * @param firstIndices
     * @param secondIndices
     * @return set of indices
     */
    private int[] mergeItemIndices(int[] firstIndices, int[] secondIndices) {

        HashSet<Integer> itemIndices = new HashSet<Integer>(firstIndices.length + secondIndices.length);
        for (int element : firstIndices) {
            itemIndices.add(element);
        }

        for (int element : secondIndices) {
            itemIndices.add(element);
        }

        return itemIndices.stream().mapToInt(Number::intValue).toArray();
    }


    /**
     * Aggregates values for given item indices.
     *
     * @param itemIndices - arbitary amount of item indicices
     * @return array of new int[]{sum weight, sum benefit}
     */
    private int[] aggregateItemValues(int ...itemIndices) {

        int[][] items = this.getItems();

        int weight = Arrays.stream(itemIndices).map(i -> items[i][0]).reduce(0, Integer::sum);
        int benefit = Arrays.stream(itemIndices).map(i -> items[i][1]).reduce(0, Integer::sum);

        return new int[]{weight, benefit};
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

    private void setItems(int[][] items) {
        this.items = items;
    }

    private void setSubProblemField(int[][][] subProblemField) {
        this.subProblemField = subProblemField;
    }

    private void setPreviousBenefitWeight(int[][][] previousBenefitWeight) {
        this.previousWeightBenefit = previousBenefitWeight;
    }

    private int getSpace() {
        return this.space;
    }

    public int[] lastItems() {
        return this.lastItemsIndxCache;
    }

    public int[][] getItems() {
        return this.items;
    }

    public int[][][] getPreviousWeightBenefit() {
        return this.previousWeightBenefit;
    }

    public int[][][] getSubProblemField() {
        return this.subProblemField;
    }
}
