package divider_conquer;

import divide_conquer.UnimodalMax;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnimodalMaxTest {

    UnimodalMax uniMax = new UnimodalMax();


    @Test
    void twoElements() {
        int[] values = {2, 1};
        int actual = uniMax.search(values);
        int expected = 2;

        assertEquals(expected, actual);
    }


    @Test
    void twoElementsReversed() {
        int[] values = {1, 2};
        int actual = uniMax.search(values);
        int expected = 2;

        assertEquals(expected, actual);
    }


    @Test
    void threeElements() {
        int[] values = {3, 2, 1};
        int actual = uniMax.search(values);
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    void threeElementsReversed() {
        int[] values = {1,2,3};
        int actual = uniMax.search(values);
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    void aroundCenterTwo() {
        int[] values = {1,2,3,1};
        int actual = uniMax.search(values);
        int expected = 3;

        assertEquals(expected, actual);
    }


    @Test
    void aroundCenterOne() {
        int[] values = {1,4,2,1};
        int actual = uniMax.search(values);
        int expected = 4;

        assertEquals(expected, actual);
    }


    @Test
    void multiValueCentered() {
        int[] values = {4, 5, 8, 9, 10, 11, 7, 3, 2, 1};
        int actual = uniMax.search(values);
        int expected = 11;

        assertEquals(expected, actual);
    }


    @Test
    void multiValueLeftBorder() {
        int[] values = {11, 9, 8, 7, 5, 4, 3, 2, 1};
        int actual = uniMax.search(values);
        int expected = 11;

        assertEquals(expected, actual);
    }


    @Test
    void multiValueRightBorder() {
        int[] values = {1, 2, 3, 4, 5, 7, 8, 9, 11};
        int actual = uniMax.search(values);
        int expected = 11;

        assertEquals(expected, actual);
    }


    @Test
    void random() {

        final int MAX_VALUE = 50;
        final int MIN_VALUE = 50;

        Random rand = new Random();
        int[] values = new int[5]; // At least length 2
        values[0] = rand.nextInt(MAX_VALUE) - rand.nextInt(MIN_VALUE);
        int expected = values[0];
        int temp;
        boolean unimodalBreak = false;
        for (int i = 1; i < values.length;i++) {

            temp = rand.nextInt(MAX_VALUE) - rand.nextInt(MIN_VALUE);
            if((!unimodalBreak && values[i-1] >= temp) || (unimodalBreak && values[i-1] <= temp) || temp == 0) {
                // array doesen't fullfill unimodal array criterion
                i--;
                continue;
            }

            values[i] = temp;
            if (!unimodalBreak) {
                unimodalBreak = rand.nextGaussian() > 0.5? true : false;
            }

            // Set new max value
            if (temp > expected) {
                expected = temp;
            }
        }

        System.out.print("+++++++++++++++++++\n| ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " | ");
        }

        int actual = uniMax.search(values);
        assertEquals(expected, actual);
    }
}
