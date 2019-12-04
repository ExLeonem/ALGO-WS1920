package divide_conquer;

/**
 * Größter gemeinsamer teiler
 *
 * @author Maksim Sandybekov
 */
public class GGT {

    /**
     * Returns the biggest divider of some numbers.
     *
     * @param numbers
     * @return biggest divider
     */
    public int calculate(int[] numbers) {

        int numberCount = numbers.length;
        if (numberCount == 0) {
            return -1;
        }

        // REVIEW: what if 0 passed.
        if (numberCount == 1) {
            return numbers[0];
        }

        return this.calculate(numbers, 0, numberCount-1);
    }


    /**
     * Rescursive step of previous method.
     *
     * @return
     */
    private int calculate(int[] numbers, int left, int right) {

        // Base-Case
        if (left >= right) {
            return numbers[right];
        }

        // Divide
        int center = (left + right) / 2;
        int dividerLeft = calculate(numbers, left, center);
        int dividerRight = calculate(numbers, center+1, right);

        // Cover edge case (only accept non negative and values greater )
        if (dividerLeft <= 0 || dividerRight <= 0) {
            return 0;
        }

        // Conquer
        boolean leftSmaller = dividerLeft < dividerRight;
        int smallerOne = leftSmaller? dividerLeft : dividerRight;
        int biggerOne = leftSmaller? dividerRight : dividerLeft;

        return  this.calculate(biggerOne, smallerOne);
    }


    /**
     * Calculate the greatest common divisor for two numbers.
     *
     * @param a - the bigger number
     * @param b - the smaller number
     * @return the greatest common divisor
     */
    public int calculate(int a, int b) {

        if (b == 0) {
            return a;
        }

        return calculate(b, a % b);
    }

}
