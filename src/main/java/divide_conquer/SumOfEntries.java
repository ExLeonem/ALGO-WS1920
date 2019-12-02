package divide_conquer;

/**
 * Calculate the sum of all entries of an array.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-2
 */
public class SumOfEntries {


    /**
     * Calculate the sum of all entries of an array.
     *
     * @param array - array of integer values
     * @return - sum of all entries
     */
    public int calculate(int[] array) {

        // Cover special case
        if (array.length == 0) {
            return 0;
        }

        return this.recurseSum(array, 0, array.length-1);
    }


    /**
     * Conquer & Divide step. Calculate the sum of all entries.
     *
     * @param array - array of integer values
     * @param left - left window border
     * @param right - right window border
     * @return - sum of all entries
     */
    private int recurseSum(int[] array, int left, int right) {

        // Base
        if (left >= right) {
            return array[left];
        }

        // Divide
        int center = (left + right) / 2;
        int leftSum = this.recurseSum(array, left, center);
        int rightSum = this.recurseSum(array, center+1, right);

        // Conquer (Merge)
        return leftSum + rightSum;
    }


}
