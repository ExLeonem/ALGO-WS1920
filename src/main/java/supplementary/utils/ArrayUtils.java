package supplementary.utils;

public class ArrayUtils {


    /**
     *  Prints the elements of an integer array.
     *
     * @param elements
     */
    public void printArray(int[] elements) {
        int counter = 0;
        for (int element : elements) {
            counter++;
            System.out.println(counter + ": " + element);
        }
    }

    // Same methods for float etc.

}
