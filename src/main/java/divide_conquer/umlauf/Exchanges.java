package divide_conquer.umlauf;

import java.util.Random;

/**
 * Zählen der Anzahl der Vertauschungen in unsortierter liste.
 */
public class Exchanges {

    private Random rand;
    private int changeCounts;


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

        // Set pivot
        int pivotIndx = rand.nextInt(numbers.length);
        this.swap(numbers, pivotIndx, numbers.length-1);

        // Sort in place
        int pivotNumber = numbers[numbers.length-1];
        int swapIndx = -1;
        for (int i = left; i < right; i++) {

            if (numbers[i] < pivotNumber) {
                swap(numbers, i, swapIndx++);
            }
        }

        swap(numbers, swapIndx++, numbers.length-1);
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
        numbers[to] = numbers[tmp];
    }


    // ---------------------
    // ----- Setter-/Getter
    // ---------------------

    public int getCount() {
        return this.changeCounts;
    }


    public int getRandomInt(int border) {
        return this.rand.nextInt(border);
    }
}
