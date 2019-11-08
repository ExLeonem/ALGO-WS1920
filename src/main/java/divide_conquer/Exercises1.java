package divide_conquer;
import java.util.Random;

/**
 *  Exercises to divide and conquery
 *  Book: Algorithm Design manual
 *
 */
public class Exercises1 {


    /**
     *  4.1 Grinch wants to split 2n players into two teams as unequal as possible.
     *
     * @param players
     * @return
     */
    public double[][] grinchPartition(double[] players) {

        if ( players.length == 1 || players.length == 0 || players.length % 2 != 0 ) {
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
        grinchSort(players, center+1, right);
    }


    private int grinchPartition(double[] players, int left, int right) {

        // Select random element in sortable area
        Random rand = new Random();
        int pivotIndex = rand.nextInt(right-left) + left;
        swapPlayers(players, pivotIndex, right-1);

        // In place sort
        int convergeToCenter = left-1;
        for (int i = left; i < right-1; i++) {

            // Swap smaller values to first indices
            if ( players[i] < players[right-1]) {
                convergeToCenter++;
                swapPlayers(players, i, convergeToCenter);
            }
        }

        // Swap pivot element to center
        swapPlayers(players, convergeToCenter+1, right-1);
        return convergeToCenter+1;
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

            System.out.println(players[i]);
            int j = team == 1? i - singleTeamLength : i;
            twoTeams[team][j] = players[i];
        }

        return twoTeams;
    }

    /**
     * 4.2 For each problem give an algorithm that finds desired numbers in specific amount of time.
     *
     * a) unsorted array of n integers. Find pair x,y that maximizes | x-y | algorithm must run in O(n) worst-case.
     * b) sorted array of n integers. Find pair that maximizes | x - y |, algorithm must run in O(1) worst-case.
     * c) unsorted array of n integers. Find pair that minimizes | x - y | for x != y. Algorithm must run in O(n log n) worst-case time.
     * d) sorted array of n integers Find pair that minimizes | x - y | x != y. Algorithm must run in O(n) worst-case time.
     */
    public int[] maximizeUnsortedPair(int[] numbers) {

        return new int[]{3, 2};
    }

    public int[] maximizeSortedPair(int[] numbers) {

        return new int[]{1, 5};
    }

    public int[] minimizeUnsortedPairs(int[] numbers) {

        return new int[]{1, 2};
    }

    public int[] minimizeSortedParis(int[] numbers) {

        return new int[]{1, 3};
    }

    /**
     * Take a sequence of 2n real numbers. Design O(n log n) algorithm that partitions
     * @param numbers
     */
    public double[] smallestParitionSumPairs(double[] numbers) {

        return new double[]{1.1, 2.2};
    }


    // -------------------- Utils
    public void printArray(double[] array) {
        for ( int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
