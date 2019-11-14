package divider_conquer;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import divide_conquer.Exercises1;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;

public class Exercise1Test {

    @Rule
    private ExpectedException exception = ExpectedException.none();
    private Exercises1 ex = new Exercises1();

    @Nested
    class GrinchPart {

        @Test
        void someValidNumbers() {
            double[] players = new double[]{2.2, 1.1, 4.3, 2.3};
            double[][] result = new double[][]{{1.1, 2.2}, {2.3, 4.3}};

            assertArrayEquals(ex.grinchPartition(players), result);
        }

//        @Test
//        void invalidUneven() throws IllegalArgumentException{
//            double[] players = new double[]{3.3};
//
//            exception.expect(IllegalArgumentException.class);
//
//            ex.grinchPartition(players);
//        }

        @Test
        void simpleTwoPlayers() {
            double[] players = new double[]{3.3, 2.1};
            double[][] result = new double[][]{{2.1}, {3.3}};

            assertArrayEquals(ex.grinchPartition(players), result);
        }

    }


    @Nested
    @DisplayName("Test exercise 4-2 unsorted and max pair")
    class UnsortedMaxPair {

        @Test
        void testLongerUneven() {

            int[] values = new int[]{12, 4, 3, 6, 2, 1, 8, 10, 2};
            int[] result = new int[]{1, 12};

            assertArrayEquals(ex.maximizeUnsortedPair(values), result);
        }

        @Test
        void simpleThreeElements() {
            int[] values = {3,2,1};
            int[] result = new int[]{1,3};

            assertArrayEquals(ex.maximizeUnsortedPair(values), result);
        }

        @Test
        void testBase() {
            int[] values = {3, 2};
            assertArrayEquals(ex.maximizeUnsortedPair(values), new int[]{2,3});
        }
    }

    @Nested
    class SortedMaxPair {


    }

}
