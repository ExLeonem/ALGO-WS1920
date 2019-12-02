package divider_conquer;

import divide_conquer.SumOfEntries;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfEntriesTest {

    SumOfEntries entries = new SumOfEntries();

    @Test
    void emptyArray() {
        int[] values = {};
        int actual = entries.calculate(values);
        int expected = 0;

        assertEquals(expected, actual);
    }


    @Test
    void singleValue() {
        int[] values = {12};
        int actual = entries.calculate(values);
        int expected = 12;

        assertEquals(expected, actual);
    }


    @Test
    void multiValues() {
        int[] values = {15, -2, 12, 5, 13, -9};
        int actual = entries.calculate(values);
        int expected = 34;

        assertEquals(expected, actual);
    }


    @Test
    void randomValues() {

        // Parameter setup
        final int MAX_ARRAY_SIZE = 20;
        final int NEGATIVE_MAX = 50;
        final int POSTIIVE_MAX = 50;

        // Testcase setup
        Random rand = new Random();
        int[] values = new int[rand.nextInt(MAX_ARRAY_SIZE)];
        int expected = 0;
        for (int i = 0; i < values.length; i++) {

            values[i] = rand.nextInt(POSTIIVE_MAX) + rand.nextInt(NEGATIVE_MAX);
            expected += values[i];
        }

        int actual = entries.calculate(values);
        assertEquals(expected, actual);
    }

}
