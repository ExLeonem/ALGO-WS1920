package dynamic_programming;

import divide_conquer.search_sort.QuickSort;
import supplementary.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.BinaryOperator;


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
     * Calculate the objects to pack into the packsack given a specific packsack size.
     *
     * @param items - the objects given as [[weight, benefit], [weight, benefit], ...]
     * @return indices of the items for optimal solution
     */
    public int[] fit(int[][] items) {

        this.setItems(items);
        int problemSize = this.getSpace();
        int[][][] subProblemField = new int[items.length][problemSize][1]; // Collect used item dimensions
        int[][][] previousWeightBenefit = new int[items.length][problemSize][]; // lookup table for previously calculated [0]: weight, [1]: benefit

        this.setSubProblemField(subProblemField);
        this.setPreviousBenefitWeight(previousWeightBenefit);

        // Each row an item
        for (int i = 0; i < subProblemField.length; i++) {

            // Each column a subproblem
            for (int j = 0; j < subProblemField[i].length; j++) {

                int aboveIndx = i > 0? i-1 : i;
                int[] currentItem = items[i];
                int currentWeight = currentItem[0];

                // First Line, just check if item weight's less than knapsack size of subproblem
                int knapsackSize = this.getKnapsackSize(j+1);
                if (aboveIndx == i) {
                    boolean itemFits = knapsackSize >= currentWeight;
                    subProblemField[i][j] = itemFits? new int[]{i} : new int[]{};
                    previousWeightBenefit[i][j] = itemFits? items[i] : new int[]{0,0};
                    continue;
                }

                // Use sub-solutions to calculate a new optimum
                int[] newOptimalSolution = this.composeOptimumIndices(i, j, knapsackSize);
                int newOptimumBenefit = Arrays.stream(newOptimalSolution).map(item -> items[item][1]).reduce(0, Integer::sum);

                // Check if new optimum is better than previous solution
                int aboveBenefit = previousWeightBenefit[aboveIndx][j][1];
                if (aboveBenefit >= newOptimumBenefit) {
                    subProblemField[i][j] = subProblemField[aboveIndx][j];
                    previousWeightBenefit[i][j] = previousWeightBenefit[aboveIndx][j];
                } else {
                    int newOptimumWeight = Arrays.stream(newOptimalSolution).map(item -> items[item][0]).reduce(0, Integer::sum);
                    subProblemField[i][j] = newOptimalSolution;
                    previousWeightBenefit[i][j] = new int[]{newOptimumWeight, newOptimumBenefit};
                }
            }
        }


        return subProblemField[subProblemField.length-1][problemSize-1];
    }


    /**
     * Compose the new optimum out of previously calculated sub-solutions
     *
     * @param itemIndx - index of current item for which to calculate the solution
     * @param packIndx - index of the current subproblem for which to calculate the solution
     * @param leftSpace - how much space is left in the current cell
     * @return item indices which would fit in the current cell
     */
    public int[] composeOptimumIndices(int itemIndx, int packIndx, int leftSpace) {

        HashSet<Integer> alreadyUsedItems = new HashSet<Integer>();
        LinkedList<Integer> optItemIndices = new LinkedList<Integer>(); // Item indices in new optimum

        int[][] items = this.getItems();
        int currentWeight = items[itemIndx][0];
        int newSpace = leftSpace - currentWeight; // if bigger than 0 proceed else return solution

        // Item doesen't fit
        if (newSpace < 0) {
            return new int[]{};

        }

        alreadyUsedItems.add(itemIndx);
        optItemIndices.add(itemIndx);

        // Check

        int[][][] subProblemField = this.getSubProblemField();
        boolean spaceChanged = true;
        while (newSpace > 0 && spaceChanged) {
            spaceChanged = false;

            int[] itemIndices = subProblemField[itemIndx][newSpace]; // Grab previous optimal solution
            for (int newItem : itemIndices) {

                if (!alreadyUsedItems.contains(newItem) && newSpace - items[newItem][0] >= 0) {
                    alreadyUsedItems.add(newItem);
                    optItemIndices.add(newItem);
                    newSpace -= items[newItem][0];
                    spaceChanged = true;
                }
            }
        }

        return optItemIndices.stream().mapToInt(Integer::intValue).toArray();
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


    // -------------------------
    // Utilities
    // -------------------------

    /**
     * For debugg purposes. Prints the occupation of the current field.
     */
    public void printFill() {

        int[][][] subProblemField = this.getSubProblemField();
        int[][][] previousWeightBenefit = this.getPreviousWeightBenefit();

        System.out.println("Current-Field: \n----------------------------\n");

        // Iterate over every row
        for (int row = 0; row < subProblemField.length; row++) {
            String rowItems = "";
            String rowValues = "";

            // All columns in current row
            for (int column = 0; column < subProblemField[row].length; column++) {

                // Aggregate item indices of current cell &
                rowItems += this.aggregateInnerLoopPrints(subProblemField[row][column], 20) + " | ";
                rowValues += this.aggregateInnerLoopPrints(previousWeightBenefit[row][column], 20) + " | ";
            }

            // Print collected information from row
            System.out.println(rowItems + "\n" + rowValues + "\n" + "-".repeat(rowItems.length()));
        }
    }


    /**
     * Collect values of inner loop into string for printing
     *
     * @param values - values to aggregate into string
     * @param maxLength -
     * @return collected string values.
     */
    private String aggregateInnerLoopPrints(int[] values, int maxLength) {

        String[] mappedValues = Arrays.stream(values).mapToObj(String::valueOf).toArray(String[]::new);
        String joinedString = String.join(", ", mappedValues);

        if (joinedString.length() < maxLength) {
            int lengthDifference = maxLength - joinedString.length();
            int paddBefore = lengthDifference/2;
            joinedString = " ".repeat(paddBefore) + joinedString + " ".repeat(lengthDifference-paddBefore);
        }

        return joinedString;
    }


    private int getKnapsackSize(int packSizeMultiplier) {
        int subProblemSize = this.getSubProblemSize();
        return packSizeMultiplier*subProblemSize;
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
