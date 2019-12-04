package divide_conquer;

/**
 * A unimodal array is an array that has a sequence
 * of monotonically increasing integers followed by a
 * sequence of monotonically decreasing integers.
 * • All elements in the array are unique
 * • Examples
 * – {4, 5, 8, 9, 10, 11, 7, 3, 2, 1}: Max. Element: 11
 * • There is an increasing seq. followed by a decreasing seq.
 * – {11, 9, 8, 7, 5, 4, 3, 2, 1}: Max. Element: 11
 * • There is no increasing seq. It is simply a decreasing seq.
 * – {1, 2, 3, 4, 5, 7, 8, 9, 11}: Max. Element: 11
 * • There is an increasing seq., but there is no decreasing seq.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-3
 */
public class UnimodalMax {

    /**
     * Searches for the maximum value in an unimodal-list
     *
     * @param unimodalArray - unimodal list of values.
     * @return returns max value of list.
     */
    public int search(int[] unimodalArray) {

        if (unimodalArray.length < 1) {
            throw new IllegalArgumentException("Can't search for maximum value in an empty array.");
        }

        return this.recurse(unimodalArray, 0, unimodalArray.length-1);
    }


    /**
     * Modified binary search algorithm
     *
     * @param unimodalArray
     * @param left
     * @param right
     * @return
     */
    private int recurse(int[] unimodalArray, int left, int right) {

        if (left >= right) {
            return unimodalArray[left];
        }

        int center = (left + right) / 2;
        if (unimodalArray[center] > unimodalArray[right] && unimodalArray[center] > unimodalArray[left]) {
            return this.recurse(unimodalArray, center, right);
        }

        // outter right element is biggest element
        if (unimodalArray[center] < unimodalArray[right]) {
            return this.recurse(unimodalArray, center+1, right);
        }

        return this.recurse(unimodalArray, left, center);

//        if (unimodalArray[center] > unimodalArray[left]) {
//            // right is decreasing.
//            return this.recurse(unimodalArray, center, right);
//        }
//        return this.recurse(unimodalArray, left, center);
    }


}
