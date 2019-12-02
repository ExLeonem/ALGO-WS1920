package divide_conquer;

import supplementary.utils.ArrayUtils;

import java.lang.reflect.Array;

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

        int[] maxOrder = this.recurse(elements, 0, elementCount-1);
        return maxOrder[1] - maxOrder[0] + 1;
    }


    /**
     * Divide and conquer the problem
     *
     * @param elements - array of elements to search maximum consecutive order in
     * @param left -
     * @param right -
     *
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
        if (leftPart[1] == rightPart[0] - 1 && elements[leftPart[1]] < elements[rightPart[0]]) {
            // The parts are
            leftPart[1] = rightPart[0];
            return new int[]{leftPart[0], rightPart[1]};
        }

        // Return
        int maxOrderLeft = leftPart[1] - leftPart[0] + 1;
        int maxOrderRight = rightPart[1] - rightPart[0] + 1;

        return maxOrderLeft > maxOrderRight? leftPart : rightPart;
    }

}
