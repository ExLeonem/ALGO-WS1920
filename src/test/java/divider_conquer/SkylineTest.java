package divider_conquer;

import divide_conquer.Skyline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

public class SkylineTest {

    Skyline sky = new Skyline();


    @Test
    @DisplayName("Single Building in the skyline")
    void singleBuilding() {
        int[][] input = {{1, 4, 12}};
        int[][] expected = {{1, 12}, {4, 0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Overlap, first one is higher")
    void overlap() {
        int[][] input = {{2, 6, 6}, {4, 7, 3}};
        int[][] expected = {{2, 6}, {6,3}, {7,0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Overlap, second one is higher")
    void overlapSec() {
        int[][] input = {{2, 6, 3}, {4, 7, 7}};
        int[][] expected = {{2,3}, {4, 7}, {7, 0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Non-Overlapping")
    void nonOverlap() {
        int[][] input = {{2, 6, 3}, {7, 10, 2}};
        int[][] expected = {{2, 3}, {6, 0}, {7, 2}, {10, 0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Surrounded, outter is below inner")
    void surrounderTop() {
        int[][] input = {{2, 10, 2}, {5, 9, 6}};
        int[][] expected = {{2,2}, {5, 6}, {9, 2}, {10, 0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Surrounded, inner below outter")
    void surrounderInner() {
        int[][] input = {{2, 10, 6}, {5, 9, 2}};
        int[][] expected = {{2, 6}, {10, 0}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Test no buildings existing in the skyline. Countryside?")
    void noBuildings() {

        int[][] input = new int[][]{};
        int[][] expected = new int[][]{};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Test skyline generation for multi building setups")
    void multiBuildings() {

        int[][] input = new int[][]{{1, 12, 5}, {5, 8, 8}, {6, 15, 2}};
        int[][] expected = new int[][]{{2, 2}, {5, 3}, {8, 3}, {12, 2}};
        int[][] actual = sky.calculate(input);

        assertArrayEquals(expected, actual);
    }


    @Test
    @DisplayName("Random towers")
    void randomBuildings() {
        // Generates random buildings and track skyline.

        // Test parameters
//            final int MAX_SHAPES = 50;
//            final int MAX_SIZE = 20;
//            final int MIN_SIZE = 2;
//            final int MAX_END = 10;

        // Setup
//            Random rand = new Random();
//            int[][] shape = new int[rand.nextInt(MAX_SHAPES - 2) + 2][2];
//            for (int i = 0; i < shape.length; i++) {
//
//
//                for (int j = 0; j < shape[i].length; j++) {
//
//                }
//            }
    }
}
