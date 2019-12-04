package divide_conquer;


/**
 * Implementation to count all none negative values in an array
 *
 * @author Maksim Sandybekov
 * @date 2019-12-2
 */
public class SumNoneNegative {


    /**
     * Calculate the sum of none negative values of an array.
     *
     * @param array - array of integer values
     * @return - the sum of none-negative values
     */
    public int calculate(int[] array) {

        // Special case
        if (array.length == 0) {
            return 0;
        }

        return this.recurseCount(array, 0, array.length-1);
    }


    /**
     * Divide and Conquer the array of values to calculate the sum of none-negative values.
     *
     * @param array - array of values
     * @param left - left border
     * @param right - right border
     * @return the sum of none negative values
     */
    private int recurseCount(int[] array, int left, int right) {

        // Base
        if (left >= right) {
            return array[left] > 0? array[left] : 0;
        }

        // Divide
        int center = (left + right) / 2;
        int leftSum = this.recurseCount(array, left, center);
        int rightSum = this.recurseCount(array, center+1, right);

        // Merge
        return leftSum + rightSum;
    }

}
