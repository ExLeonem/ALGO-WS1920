package divider_conquer;

import divide_conquer.Skyline;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.Assert.assertArrayEquals;


public class SkylineTest {

    Skyline sky = new Skyline();


    @Test
    @DisplayName("Single Building in the skyline")
    void singleBuilding() {

        int[][] input = new int[][]{
                {1, 4, 12}
        };

        int[][] expected = new int[][]{{1,3}, {2,2}};
//        int[][] expected = new int[][]{{1, 0}, {1, 12}, {4, 12}, {4, 0}};
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


    @Nested
    class GenerateShapeCorners {

        @Test
        void simpleTest() {
            int[] shape = {2, 2, 10};
            int[][] expected = {{2,10}, {2,0}};
            int[][] actual = sky.genCornerCoordinates(shape);

            assertArrayEquals(expected, actual);
        }


        @Test
        void randomTest() {

            // Parameters for random number generation
            final int MAX_X_ONE = 50;
            final int MAX_X_TWO = 50;
            final int MAX_Y = 50;

            // Generate Random Values
            Random rand = new Random();
            int xOne = rand.nextInt(MAX_X_ONE);
            int xTwo = rand.nextInt(MAX_X_TWO) + xOne;
            int height = rand.nextInt(MAX_Y) + 1;

            // Setup expected
            int[] shape = {xOne, xTwo, height};
            int[][] expected = new int[2][2];

            expected[0][0] = shape[0];
            expected[0][1] = shape[shape.length - 1];

            expected[1][0] = shape[1];
            expected[1][1] = 0;


            // Verification
            int[][] actual = sky.genCornerCoordinates(shape);
            assertArrayEquals(expected, actual);
        }
    }


    @Nested
    @DisplayName("Test the merge routine for the conquer and divide algorithm")
    class TestCoordinateMerge {

        @Test
        void mergeStatic() {

        }


        @Test
        void randomMerge() {


        }

    }

}
