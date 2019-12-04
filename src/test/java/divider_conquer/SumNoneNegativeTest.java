package divider_conquer;

import divide_conquer.SumNoneNegative;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SumNoneNegativeTest {


    SumNoneNegative noneNegative = new SumNoneNegative();


    @Test
    void noValues() {
        int[] values = {};
        int actual = noneNegative.calculate(values);
        int expected = 0;

        assertEquals(expected, actual);
    }


    @Test
    void singlePositive() {
        int[] values = {3};
        int actual = noneNegative.calculate(values);
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    void singleNegative() {
        int[] values = {-3};
        int actual = noneNegative.calculate(values);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void mixedEven() {
        int[] values = {12, -3};
        int actual = noneNegative.calculate(values);
        int expected = 12;

        assertEquals(expected, actual);
    }


    @Test
    void mixedUneven() {
        int[] values = {12, 5, -3};
        int actual = noneNegative.calculate(values);
        int expected = 17;

        assertEquals(expected, actual);
    }


    @Test
    void random() {

        // Constants to use for calculation
        final int MAX_ARRAY_LENGTH = 20;
        final int NEGATIVE_MAX = 50;
        final int POSITIVE_MAX = 50;

        // Testcase setup
        Random rand = new Random();
        int[] values = new int[rand.nextInt(MAX_ARRAY_LENGTH)];
        int expected = 0;
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(POSITIVE_MAX) + rand.nextInt(NEGATIVE_MAX);

            // Sum generated random numbers to get expected value
            if (values[i] > 0) {
                expected += values[i];
            }
        }

        int actual = noneNegative.calculate(values);
        assertEquals(expected, actual);
    }
}
