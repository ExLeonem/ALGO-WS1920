package supplementary.utils;

import java.util.LinkedList;

public class ArrayUtils {


    public static int[] listToArray(LinkedList<Integer> elements) {

        int[] elementsArray = new int[elements.size()];
        for (int i = 0; i < elementsArray.length; i++) {
            elementsArray[i] = elements.pop();
        }

        return elementsArray;
    }


    public static int[][] nestedIntListToArray(LinkedList<int[]> elements) {

        int[][] elementsArray = new int[elements.size()][];
        for (int i = 0; i < elementsArray.length; i++) {
            elementsArray[i] = elements.pop();
        }

        return elementsArray;
    }


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
