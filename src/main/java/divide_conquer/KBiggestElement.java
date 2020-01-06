package divide_conquer;

/**
 * Search the k-th biggest element in an array of integers.
 *
 * @author Maksim Sandybekov
 */

public class KBiggestElement {


    public int search(int[] numbers, int k_th_element) {

        // k-th element must be in range of available elements
        int numbers_length = numbers.length;
        if (numbers_length < k_th_element) {
            throw new IllegalArgumentException("Can't find the " + k_th_element + " biggest element in an array of only " + numbers_length + " elements.");
        }

        // Allow only positive numbers
        if (k_th_element < 1) {
            throw new IllegalArgumentException("K-th element must be positive.");
        }

        // If only one element available
        if (numbers_length == 1) {
            return numbers[0];
        }

        int[] ordered_elements = this.recurse(numbers, 0, numbers_length, k_th_element);

        return 1;
//        return this.recurse(recurse, 0, );
    }

    public int[] recurse(int[] numbers, int left, int right, int k_th) {

        // Base case
        if (left >= right) {
            int number = numbers[right];
            return new int[]{number, number, k_th};
        }

        // Divide
        int center = (left + right) / 2;
        int[] leftPart = this.recurse(numbers, left, center, k_th);
        int[] rightPart = this.recurse(numbers, center + 1, right, k_th);


        // Merge (Conquer)



        return new int[]{1, 3};
    }

}
