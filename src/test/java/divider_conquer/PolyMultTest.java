package divider_conquer;

import divide_conquer.PolyMult;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class PolyMultTest {

    PolyMult pmult = new PolyMult();

    @Test
    void nullPolynomial() {
        int[] first = new int[]{};
        int[] second = new int[]{};
        int[] actual = pmult.mult(first, second);
        int[] expected = new int[]{5,3};

        assertArrayEquals(expected, actual);
    }


    @Test
    void gradFivePolynomial() {
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{1, 2, 3, 4, 5};
        int[] actual = pmult.mult(first, second);
        int[] expected = new int[]{2, 4, 6, 8, 10};

        assertArrayEquals(expected, actual);
    }


    @Nested
    class TestEqualsLength {


        @Test
        void zeroGradPoly() {
            int[] plyFirst = new int[]{1};
            int[] plySec = new int[]{2};
            int[] actual = pmult.mult(plyFirst, plySec);
            int[] expected = new int[]{3};

            assertArrayEquals(expected, actual);
        }


        @Test
        void testGradOne() {
            int[] plyFirst = new int[]{2, 3};
            int[] plySec = new int[]{2, 1};
            int[] actual = pmult.mult(plyFirst, plySec);
            int[] expected = new int[]{4, 4};

            assertArrayEquals(expected, actual);
        }


        @Test
        void testGradFour() {
            int[] first = new int[]{5, 4, 6, 3};
            int[] sec = new int[]{2, 6, 3, 7};
            int[] actual = pmult.mult(first, sec);
            int[] expected = new int[]{7, 10, 9, 10};

            assertArrayEquals(expected, actual);
        }
    }
}
