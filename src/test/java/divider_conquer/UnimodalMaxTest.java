package divider_conquer;

import divide_conquer.UnimodalMax;
import org.junit.jupiter.api.Test;

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

    }
}
