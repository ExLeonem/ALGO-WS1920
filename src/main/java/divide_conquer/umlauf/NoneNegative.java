package divide_conquer.umlauf;

public class NoneNegative {

    public int count(int[] numbers) {

        if (numbers.length < 1) {
            return 0;
        }

        return this.recurse(numbers, 0, numbers.length-1);
    }


    /**
     * D&C for count of none negatives.
     *
     * @param numbers
     * @param left - left outter border
     * @param right - right outter border
     *
     * @return number of non negtive numbers
     */
    private int recurse(int[] numbers, int left, int right) {

        // Base Case
        if (left >= right) {
            return numbers[right] >= 0 ? 1 : 0;
        }

        // Divide
        int center = (left + right) / 2;
        int leftCount = this.recurse(numbers, left, center);
        int rightCount = this.recurse(numbers, center+1, right);

        // Merge
        return leftCount+rightCount;
    }

}
