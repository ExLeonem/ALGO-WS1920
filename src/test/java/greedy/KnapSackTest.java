package greedy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class KnapSackTest {

    KnapSack sack = new KnapSack();

    @Nested
    class NonFractonal {

        @Test
        void twoItems() {
            int[][] items = new int[][]{{2,10},{1,12},{8,20}};
            int[] actual = sack.maxValues(items);
            int[] expected = new int[]{12,10};

            assertArrayEquals(expected, actual);
        }


        @Test
        void nothingFits() {
            int[][] items = new int[][]{{6,10},{8,12},{7,20},{6,33}};
            int[] actual = sack.maxValues(items);
            int[] expected = new int[]{};

            assertArrayEquals(expected, actual);
        }


        @Test
        void singleOneFits() {
            int[][] items = new int[][]{{5,20}};
            int[] actual = sack.maxValues(items);
            int[] expected = new int[]{20};

            assertArrayEquals(expected, actual);
        }
    }


    @Nested
    class FractionTest {


        @Test
        void noItems() {
            int[][] items = new int[][]{};
            double[][] actual = sack.maxFractional(items);
            double[][] expected = new double[][]{};

            assertArrayEquals(expected, actual);
        }


        @Test
        void singleItemFits() {
            int[][] items = new int[][]{{1, 12}};
            double[][] actual = sack.maxFractional(items);
            double[][] expected = new double[][]{{0, 1}};

            assertArrayEquals(expected, actual);
        }


        @Test
        void singleItemNoFit() {
            int[][] items = new int[][]{{8, 12}};
            double[][] actual = sack.maxFractional(items);
            double[][] expected = new double[][]{{0, .625}};

            assertArrayEquals(expected, actual);
        }
    }

}
