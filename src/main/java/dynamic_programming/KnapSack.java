package dynamic_programming;

import divide_conquer.search_sort.QuickSort;

import java.util.Arrays;
import java.util.LinkedList;


/**
 * KnapSack Problem which items to use to get most benefit?
 *
 * @author Maksim Sandybekov
 * @date 2019-12-11
 */
public class KnapSack {

    private int space; // defaults to 5
    private int[] lastItemsIndxCache;


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

        QuickSort quick = new QuickSort();

        int totalSpace = this.getSpace();
        int[][][] subProblemField = new int[items.length][totalSpace][]; // Collect used item dimensions
        int[][][] previousWeightBenefit = new int[items.length][totalSpace][]; // lookup table for previously calculated [0]: weight, [1]: benefit

        // Iterate over items of knapsack
        for (int i = 0; i < subProblemField.length; i++) {
            int[] currentItem = items[i]; // 0: weight, 1: benefit

            // Iterate over knapsack sub-weights
            for (int j = 0; j < subProblemField[i].length; j++) {

                if (j == 0) {

                    if (i == 0) {
                        subProblemField[i][j] = currentItem[0] <= (j+1)? new int[]{i} : new int[]{};

                        continue;
                    }

                    int aboveIndx = i > 0? i-1 : i;
                    int benefitAbove = i > 0? previousWeightBenefit[i-1][j][1] : 0;

                    subProblemField[i][j] = currentItem[1] > benefitAbove && currentItem[0] <= (j+1) ? (new int[]{j}) : subProblemField[aboveIndx][j];
                    int cellWeight = Arrays.stream(subProblemField[i][j]).map(itemIndx -> items[itemIndx][0]).reduce(0, Integer::sum);
                    int cellBenefit = Arrays.stream(subProblemField[i][j]).map(itemIndx -> items[itemIndx][1]).reduce(0, Integer::sum);

                    previousWeightBenefit[i][j] = new int[]{cellWeight, cellBenefit};
                    continue;
                }

                // There's still space if previous element added
                leftSpace = (j+1) - cellWeightBefore;
                if (((j+1) - cellWeightBefore) > 0) {
                    // fill space with previously calculated optimums
                    int[] previousItems = subProblemField[i][j-1];
                    for (int i = 0; )


                // After adding previous element no more space, but is new optimum
                } else if (cellBenefitBefore > cellBenefitAbove) {
                    subProblemField[i][j] = subProblemField[i][j-1];
                }
            }
        }


        return subProblemField[subProblemField.length - 1][subProblemField[0].length - 1];
    }



    private int[] compareValues(int[] above, int[] left) {


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
