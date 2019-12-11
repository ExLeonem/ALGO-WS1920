package dynamic_programming;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class KnapSackTest {



    @Nested
    class DefaultSize {

        KnapSack sack = new KnapSack();

        @Test
        void regularTest() {
            int[][] items = new int[][]{{2, 10}, {1, 12}, {8, 20}};
            int[] actual = sack.fit(items);
            int[] expected = {0, 5};

            assertArrayEquals(expected, actual);
        }


        @Test
        void itemsDontFit() {
            int[][] items = new int[][]{{6, 10}, {9, 10}, {20, 12}};
            int[] actual = sack.fit(items);
            int[] expected = {2};

            assertArrayEquals(expected, actual);
        }


        @Test
        void singleItemFits() {
            int[][] items = new int[][]{{6, 10}, {7, 12}, {5, 3}, {21, 5}, {7,13}};
            int[] actual = sack.fit(items);
            int[] expected = {12};

            assertArrayEquals(expected, actual);
        }
    }
}
