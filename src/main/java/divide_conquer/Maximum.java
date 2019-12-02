package divide_conquer;

/**
 * Find maximum intger in array of values
 */
public class Maximum {


    public int search(int[] array) {

        if (array.length < 1) {
            return -1;
        }

        return this.recurse(array, 0, array.length-1);
    }


    private int recurse(int[] array, int left, int right) {

        // Base
        if (left >= right) {
            return array[left];
        }

        // Conquer
        int center = (left + right) / 2;
        int valueLeft = this.recurse(array, left, center);
        int valueRight = this.recurse(array, center +1 , right);

        // Divide
        return valueLeft > valueRight? valueLeft : valueRight;
    }


}
