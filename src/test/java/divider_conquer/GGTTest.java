package divider_conquer;

import divide_conquer.GGT;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GGTTest {

    GGT ggt = new GGT();


    @Test
    void onlyEvenNumbers() {
        int[] evenNumbers = {18, 8, 4, 12, 36};
        int divider = ggt.calculate(evenNumbers);

        assertEquals(2, divider);
    }


    @Test
    void onlyUnEvenNumbers() {
        int[] unevenNumbers = {25, 35, 30, 60, 45};
        int divider = ggt.calculate(unevenNumbers);

        assertEquals(5, divider);
    }


    @Test
    void mixedNumbers() {
        int[] someNumbers = {64, 342, 293, 101, 124, 74, 193, 84};
        int divider = ggt.calculate(someNumbers);

        assertEquals(1, divider);
    }


    @Test
    void oneBiggestDivider() {
        int[] biggestOne = {7, 5, 18, 11, 13};
        int divider = ggt.calculate(biggestOne);

        assertEquals(1, divider);
    }


    @Test
    void singleNumber() {
        int[] numbers = {5};
        int result = ggt.calculate(numbers);

        assertEquals(5, result);
    }


    @Test
    void arrayOfTwo() {
        int[] numbers = {17, 34};
        int divider = ggt.calculate(numbers);

        assertEquals(17, divider);
    }


    @Test
    void arrayOfThree() {
        int[] numbers = {16, 6, 32};
        int divider = ggt.calculate(numbers);

        assertEquals(2, divider);
    }


    // --- Test Edge cases
    @Test
    void invalidNumber() {
        int[] numbers = {0, 3, 2, 12};
        int divider = ggt.calculate(numbers);

        assertEquals(0, divider);
    }
}
