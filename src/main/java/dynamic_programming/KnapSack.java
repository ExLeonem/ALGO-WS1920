package dynamic_programming;

import divide_conquer.search_sort.QuickSort;
import supplementary.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * KnapSack Problem which items to use to get most benefit?
 *
 * @author Maksim Sandybekov
 * @date 2019-12-11
 */
public class KnapSack {

    private int space; // defaults to 5
    private int[] lastItemsIndxCache;
    private int subProblemSize;

    // Attributes getting reset after fit call
    private int[][][] subProblemField;
    private int[][][] previousWeightBenefit;
    private int[][] items;

    /**
     * Idee: Ansatz zum kleinhalten der speicher größe für die Zwischenergebnisse?
     * -> GGT über die Gewichte & die maximale Rucksack größe finden
     * -> Maximale Rucksack größe durch GGT teilen
     * -> Jede Zelle ist so groß wie GGT
     */


    public KnapSack() {
        this.space = 5;
        this.subProblemSize = 1;
    }

    public KnapSack(int space) {
        this.space = (int) space;
        this.subProblemSize = 1;
    }


    /**
     * Calculate the objects to pack into the packsack given a specific packsack size.
     *
     * @param items - the objects given as [[weight, benefit], [weight, benefit], ...]
     * @return indices of the items for optimal solution
     */
    public int[] fit(int[][] items) {

        int problemSize = this.calcuateProblemSize();

        int[][][] subProblemField = new int[items.length][problemSize][]; // Collect used item dimensions
        int[][][] previousWeightBenefit = new int[items.length][problemSize][]; // lookup table for previously calculated [0]: weight, [1]: benefit

        this.setSubProblemField(subProblemField);
        this.setPreviousBenefitWeight(previousWeightBenefit);

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
     * Equals method same name but single paramter, a specific size can be additionally passed.
     *
     * @param items - items given as [[weight, benefit], [weight, benefit], ...]
     * @param space - size of the knapsack
     * @return calculated optimal solution
     */
    public int[] fit(int[][] items, int space) {
        this.setSpace(space);
        return this.fit(items);
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

        int[][][]  previousWeightBenefit = this.getPreviousWeightBenefit();  // lookup table for previously calculated [0]: weight, [1]: benefit
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
        int[] currentOptWeightBenefit = new int[]{weightBefore, benefitBefore}; // max. reachable using the previous solution
        int[] newOptIndices = new int[]{itemIndx};

        // There is still space left after putting object into cell, search in sub-solutions for other optimal items
        int leftSpace = (packIndx + 1) - weightBefore;
        if (leftSpace > 0 ) {
            newOptIndices = this.composeSolution(itemIndx, packIndx, leftSpace);
            currentOptWeightBenefit = this.aggregateItemValues(newOptIndices);
        }

        // Newly calculated optimum is better than above optimum
        int benefitAbove = previousWeightBenefit[itemIndx - 1][packIndx][1];
        if (currentOptWeightBenefit[1] > benefitAbove) {
            subProblemField[itemIndx][packIndx] = newOptIndices;
            previousWeightBenefit[itemIndx][packIndx] = currentOptWeightBenefit;
            return;
        }

        subProblemField[itemIndx][packIndx] = subProblemField[itemIndx - 1][packIndx];
        previousWeightBenefit[itemIndx][packIndx] = previousWeightBenefit[itemIndx - 1][packIndx];
    }


    /**
     * Compose a solution from previously resolved sub-problems.
     *
     * @param itemIndx - current item index (row)
     * @param packIndx - index of current subproblem (column)
     * @param leftSpace - the available space in the current cell (subproblem)
     * @return aggregated indices for potentially new optimum solution
     */
    public int[] composeSolution(int itemIndx, int packIndx, int leftSpace) {

        int[][][] previousWeightBenefit = this.getPreviousWeightBenefit();
        int[][][] subProblemField = this.getSubProblemField();

        // Iterate from current element to first element
        int[] previousIndices = subProblemField[itemIndx][leftSpace];
        LinkedList<Integer> indices = new LinkedList<Integer>();

        for (int i = itemIndx; (i > -1) && (leftSpace >= 0); i--) {
            previousIndices = this.mergeItemIndices(subProblemField[i][leftSpace], previousIndices, leftSpace);
//            leftSpace = calculate new left space
        }



        return previousIndices;
    }


    /**
     * Merge two collection of indices of previously calculated sub-solution into a single array representing a new sub-solution.
     *
     * @param firstIndices
     * @param secondIndices
     * @return updated left space
     */
    private int[] mergeItemIndices(int[] firstIndices, int[] secondIndices, int leftSpace) {

        int[][] items = this.getItems();
        HashSet<Integer> trackDuplicate = new HashSet<Integer>(firstIndices.length + secondIndices.length);
        LinkedList<Integer[]> elementsToSort = new LinkedList<Integer[]>();

        // Put elements from first array into set & linked list
        for (int element : firstIndices) {

            if (!trackDuplicate.contains(element)) {
                int[] itemInformation = items[element];
                elementsToSort.add(new Integer[]{element, itemInformation[0], itemInformation[1]}); // itemIndx, weight, benefit
                trackDuplicate.add(element);
            }
        }

        // Put elements from second array into set and linkedlist
        for (int element : secondIndices) {

            if (!trackDuplicate.contains(element)) {
                int[] itemInformation = items[element];
                elementsToSort.add(new Integer[]{element, itemInformation[0], itemInformation[1]}); // itemIndx, weight, benefit
                trackDuplicate.add(element);
            }
        }


        QuickSort quick = new QuickSort();
        int[][] eliminatedDuplicates = elementsToSort.toArray(new int[elementsToSort.size()][]);
        eliminatedDuplicates = quick.sort(eliminatedDuplicates, 2); // Sort by benefit



        return 12;
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


    /**
     * Calculates how many subproblems are needed.
     *
     * @return integer representing the number of subproblems
     */
    private int calcuateProblemSize() {

        int totalSpace = this.getSpace();
        int subProblemSize = this.getSubProblemSize();
        int subProblemCount = totalSpace / subProblemSize;
        if (totalSpace % subProblemSize != 0) {
            subProblemCount = totalSpace;
        }

        return subProblemCount;
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

    private void setSubProblemSize(int subProblemSize) {
        this.subProblemSize = subProblemSize;
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

    private int getSubProblemSize() {
        return this.subProblemSize;
    }
}
