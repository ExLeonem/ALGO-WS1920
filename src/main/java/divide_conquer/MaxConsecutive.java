package divide_conquer;

import java.util.Arrays;

/**
 * D&Q algorithm to calculate max. consecutive order of elements
 *
 * @author Maksim Sandybekov
 * @date 2019-20-11
 */
public class MaxConsecutive {


    /**
     * Search for the maximum consecutive order of elements.
     * Public user API.
     *
     * @param elements - array of integer to search the maximum consecutive order in.
     * @return - number of max. consecutive elements.
     */
    public int search(int[] elements) {

        // Catch single/none elements
        int elementCount = elements.length;
        if (elementCount < 2) {
            return elementCount == 0? 0 : 1;
        }

        int[] maxOrder = this.recurse(elements, 0, elementCount);
        return maxOrder.length;
    }


    /**
     *
     * @param elements - array of elements to search maximum consecutive order in
     * @param left -
     * @param right -
     * @return array of length 2, containing the left and right border of the maximum consecutive order.
     */
    public int[] recurse(int[] elements, int left, int right) {

        // Base-Case
        if (left >= right) {
            return new int[]{left, right};
        }

        // Divide
        int center = (left + right) / 2;
        int[] leftPart = this.recurse(elements, left, center);
        int[] rightPart = this.recurse(elements, center + 1, right);


        // Conquer
        int leftCount = Arrays.stream(leftPart).sum();
        int rightCount = Arrays.stream(rightPart).sum();
        if (leftCount == 1) {

        }



        return new int[]{1};
    }




}
