package divide_conquer.abstract_exercises;
import java.util.Random;

/**
 * Exercises to divide and conquery
 * Book: Algorithm Design manual
 */
public class Exercises1 {


    /**
     * 4.1 Grinch wants to split 2n players into two teams as unequal as possible.
     *
     * @param players
     * @return
     */
    public double[][] grinchPartition(double[] players) {

        if (players.length == 1 || players.length == 0 || players.length % 2 != 0) {
            throw new IllegalArgumentException("Parameter: {players} must have an even number of players.");
        }

        grinchSort(players, 0, players.length); // Reference passed, in-place sorting
        return grinchSplit(players);
    }


    private void grinchSort(double[] players, int left, int right) {

        // Base Case
        if (left >= right) {
            return;
        }

        // Step: In-Place sort
        int center = grinchPartition(players, left, right);

        // Step: Divide
        grinchSort(players, left, center);
        grinchSort(players, center + 1, right);
    }


    private int grinchPartition(double[] players, int left, int right) {

        // Select random element in sortable area
        Random rand = new Random();
        int pivotIndex = rand.nextInt(right - left) + left;
        swapPlayers(players, pivotIndex, right - 1);

        // In place sort
        int convergeToCenter = left - 1;
        for (int i = left; i < right - 1; i++) {

            // Swap smaller values to first indices
            if (players[i] < players[right - 1]) {
                convergeToCenter++;
                swapPlayers(players, i, convergeToCenter);
            }
        }

        // Swap pivot element to center
        swapPlayers(players, convergeToCenter + 1, right - 1);
        return convergeToCenter + 1;
    }


    private void swapPlayers(double[] players, int from, int to) {
        double toTemp = players[to];
        players[to] = players[from];
        players[from] = toTemp;
    }


    private double[][] grinchSplit(double[] players) {
        int singleTeamLength = players.length / 2;
        double[][] twoTeams = new double[2][singleTeamLength];

        // Fill Teams up
        int team = 0;
        for (int i = 0; i < players.length; i++) {

            if (i == singleTeamLength) {
                team++;
            }

            int j = team == 1 ? i - singleTeamLength : i;
            twoTeams[team][j] = players[i];
        }

        return twoTeams;
    }


    /**
     * 4.2 a) Finds the pair that maximizes distance metric | x - y |  in O(n) worst-case
     *
     * @param numbers - array of unsorted numbers
     * @return pair that maximizes distance
     */
    public int[] maximizeUnsortedPair(int[] numbers) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Can't find pairs of minimal size in array with less than two elements.");
        }

        return recurseMaxUnsortedPair(numbers, 0, numbers.length - 1);
    }

    private int[] recurseMaxUnsortedPair(int[] numbers, int left, int right) {

        // Base case, single element at this index
        if (left >= right) {
            return new int[]{numbers[right], numbers[right]};
        }

        // Divide (Sub Problems always return array of length 2);
        int center = (left + right) / 2;
        int[] leftSubPair = recurseMaxUnsortedPair(numbers, left, center);
        int[] rightSubPair = recurseMaxUnsortedPair(numbers, center + 1, right);

        // Conquer (Merge)
        boolean leftIsSmaller = leftSubPair[0] < leftSubPair[1];
        int min = leftIsSmaller ? leftSubPair[0] : leftSubPair[1];
        int max = leftIsSmaller ? leftSubPair[1] : leftSubPair[0];

        // Compare elements
        for (int i = 0; i < rightSubPair.length; i++) {

            if (max < rightSubPair[i]) {
                max = rightSubPair[i];
            }

            if (min > rightSubPair[i]) {
                min = rightSubPair[i];
            }
        }

        return new int[]{max, min}; // Always return max left, min right
    }


    /**
     * 4.2 b) Find pair that maximizes | x - y |, algorithm must run in O(1) worst-case.
     *
     * @param sortedNumbers - array of sorted numbers
     * @return pair that maximzes distance metric
     */
    public int[] maxSortedPair(int[] sortedNumbers) {

        if (sortedNumbers.length < 2) {
            throw new IllegalArgumentException("Can't find max pair of array with less than 2 elements");
        }

        // Access smallest and biggest value ind fields
        int min = sortedNumbers[0];
        int max = sortedNumbers[sortedNumbers.length];

        return new int[]{max, min};
    }


    /**
     * 4.2 c) Find pair that minimizes | x - y | for x != y. Algorithm must run in O(n log n) worst-case time.
     *
     * @param numbers - array of unsorted numbers
     * @return pair that minimzes distance
     */
    public int[] minimizeUnsortedPairs(int[] numbers) {

        if (numbers.length < 2) {
            throw new IllegalArgumentException("Can't find a pair in array with less than 2-Elements");
        }

        int[] sorted = this.sortMinPairs(numbers, 0, numbers.length - 1);

        int first = 0;
        int second = 0;



        return new int[]{};
    }


    // In essence merge-sort
    private int[] sortMinPairs(int[] numbers, int left, int right) {

        // Base Case
        if (left > right) {
            return new int[]{numbers[right]};
        }

        // Divide
        int center = (left + right) / 2;
        int[] leftSub = this.sortMinPairs(numbers, left, center);
        int[] rightSub = this.sortMinPairs(numbers, center+1, right);

        // Conquer
        int[] merged = new int[leftSub.length + rightSub.length];
        int leftIndx = 0;
        int rightIndx = 0;
        for (int i = 0; i < merged.length; i++) {

            if (merged[leftIndx] < merged[rightIndx]) {

            }

        }

        return new int[]{1,2};
    }


    private int[] recurseMinimzeDistancePairs(int[] numbers) {
        // do something
        return new int[]{1,2};
    }


    /**
     *  4.2 d) Find pair that minimizes | x - y | x != y. Algorithm must run in O(n) worst-case time.
     *
     * @param sortedNumbers - array of sorted numbers
     * @return pair that minimzes distance metrics
     */
    public int[] minimzeSortedPairs(int[] sortedNumbers) {

        return new int[]{1, 3};
    }


    /**
     * 4.3 Take a sequence of 2n real numbers. Design O(n log n) algorithm that partitions
     *
     * @param numbers
     */
    public double[] smallestParitionSumPairs(double[] numbers) {

        return new double[]{1.1, 2.2};
    }


    // -------------------- Utils
    public void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
