package divide_conquer;

/**
 * Größter gemeinsamer teiler
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

        // ------- Base
        if (left >= right) {
            return numbers[right];
        }

        // ------- Divide
        int center = (left + right) / 2;
        int dividerLeft = calculate(numbers, left, center);
        int dividerRight = calculate(numbers, center+1, right);

        // Edge case
        if (dividerLeft == 0 || dividerRight == 0) {
            return 0;
        }

        // ------- Merge
        boolean leftSmaller = dividerLeft < dividerRight;
        int smallerOne = leftSmaller? dividerLeft : dividerRight;
        int biggerOne = leftSmaller? dividerRight : dividerLeft;

        if (biggerOne % smallerOne == 0) {
            return smallerOne;
        }

        // Find smallest number for which both numbers
        while (smallerOne != 0) {
            int rest = biggerOne % smallerOne;
            biggerOne = smallerOne;
            smallerOne = rest;
        }

        return biggerOne;
    }

}
