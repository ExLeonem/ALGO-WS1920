package divider_conquer;

import divide_conquer.Maximum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumTest {

    Maximum max = new Maximum();


    @Test
    void mixedValues() {
        int[] values = {2, 5, -2, 33, 12, 1000, 2, -6};
        int maxValue = max.search(values);
        int expected = 1000;

        assertEquals(expected, maxValue);
    }


    @Test
    void testRandom() {

        final int MAX_AR_LENGTH = 50;
        final int MIN_AR_LENGTH = 5;
        final int MAX_AR_VALUE = 500;
        final int MIN_AR_VALUE = 250;


        Random rand = new Random();
        int[] values = new int[rand.nextInt(MAX_AR_LENGTH) + MIN_AR_LENGTH];
        int expectedMax = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(MAX_AR_VALUE) - rand.nextInt(MIN_AR_VALUE);

            // Track current max value
            if (values[i] > expectedMax) {
                expectedMax = values[i];
            }
        }

        int actualMax = max.search(values);
        assertEquals(expectedMax, actualMax);
    }


    @Nested
    @DisplayName("Test base cases")
    class BaseCaseTest {

        @Test
        void singleValue() {
            int[] values = {2};
            int maxValue = max.search(values);
            int expected = 2;


            assertEquals(expected, maxValue);
        }


        @Test
        void twoValues() {
            int[] values = {3, 6};
            int actual = max.search(values);
            int exptected = 6;

            assertEquals(exptected, actual);
        }
    }
}
