package divide_conquer;

public class Search {


    /**
     * Searches the sorted array for a specific value and returns index if value is found.
     *
     * @param sortedArray -
     * @param valueToSearch - value to search for in array
     * @return index of value location
     */
    public int search(int[] sortedArray, int valueToSearch) {

        int arrayLength = sortedArray.length;
        if(arrayLength < 1) {
            return -1;
        }

        return this.recurse(sortedArray, 0, arrayLength-1, valueToSearch);
    }


    private int recurse(int[] sortedArray, int left, int right, int valueToSearch) {

        // Base
        int center = (left + right) / 2;
        if (sortedArray[center] == valueToSearch) {
            return center;
        }

        if ( left >= right) {
            return -1;
        }

        // Divide & Conquer
        if (valueToSearch < sortedArray[center]) {
            return this.recurse(sortedArray, left, center, valueToSearch);
        }
        return this.recurse(sortedArray, center+1, right, valueToSearch);
    }

}
