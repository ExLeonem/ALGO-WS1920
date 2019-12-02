package supplementary.utils;

public class ArrayUtils {


    /**
     *  Prints the elements of an integer array verticaly with element index.
     *
     * @param array
     */
    public static void printVertical(int[] array) {
        int counter = 0;
        for (int element : array) {
            counter++;
            System.out.print(counter + ": " + element);
        }
    }


    /**
     * Print elements of an integer array horizontally divided by a vertical divider.
     *
     * @param array
     */
    public static void printHorizontal(int[] array) {
        System.out.print("| ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
    }

    // Same methods for float etc.

}
