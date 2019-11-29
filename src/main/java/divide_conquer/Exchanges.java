package divide_conquer;

import java.util.Random;

/**
 * Zählen der Anzahl der Vertauschungen in unsortierter liste.
 */
public class Exchanges {

    private Random rand;
    private int changeCounts;
    private int[] sorted;


    public Exchanges() {
        this.rand = new Random();
        this.changeCounts = 0;
    }


    public int count(int[] unsortedNumbers) {

        int size = unsortedNumbers.length;
        if (size < 2) {
            return 0;
        }

        this.recurse(unsortedNumbers, 0, size);
        this.sorted = unsortedNumbers;
        return this.getCount();
    }


    public void recurse(int[] numbers, int left, int right) {

        // Base Case
        if (left >= right) { return; }

        // Divide
        int center = this.partition(numbers, left, right);
        recurse(numbers, left, center);
        recurse(numbers, center+1, right);
    }


    /**
     * In place sorting of elements.
     *
     * @param numbers
     * @param left
     * @param right
     * @return the center
     */
    public int partition(int[] numbers, int left, int right) {

        // Sort in place
        int pivotNumber = numbers[right-1];
        int swapIndx = left-1;
        for (int i = left; i < right-1; i++) {

            if (numbers[i] < pivotNumber) {
                swapIndx++;
                swap(numbers, i, swapIndx);
            }
        }

        swapIndx++;
        swap(numbers, swapIndx, right-1);
        this.incrementCounter();

        return swapIndx;
    }


    /**
     * Simply swap two elements of an array
     *
     * @param numbers
     * @param from
     * @param to
     */
    public void swap(int[] numbers, int from, int to) {
        int tmp = numbers[from];
        numbers[from] = numbers[to];
        numbers[to] = tmp;
    }

    public void incrementCounter() {
        this.changeCounts++;
    }

    public void printArray(int[] numbers) {
        System.out.print("| ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " | ");
        }
    }


    // ---------------------
    // ----- Setter-/Getter
    // ---------------------

    public int getCount() {
        return this.changeCounts;
    }

    public int[] getSorted() {
        return this.sorted;
    }
}
