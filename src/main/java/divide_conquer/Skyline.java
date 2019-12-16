package divide_conquer;


import java.util.LinkedList;

/**
 * Calculates a skyline for a given input array of building dimensions
 *
 * Assumptions:
 * - List of buildings is already sorted
 * - buidlings are flatted on the ground
 * - Input-Array is 2D
 *
 * @author Maksim Sandybekov
 * @date 2019-12-2
 */
public class Skyline {


    /**
     * Calculates the skyline shape for a given 2D input array of form [[li, ri, hi], ...] where
     *
     * li: left bottom border coordinate
     * ri: right bottom border coordinate
     * hi: height of the building
     *
     * @param input - 2D-Array of building dimensions of form [li, ri, hi]
     * @return - calculated skyline as multidimensional array. Each array entry represents an point in 2D-Euclidean space.
     */
    public int[][] calculate(int[][] input) {

        // Special case (empty input array)
        if (input.length == 0) {
            return new int[][]{};
        }

        return new int[][]{};
    }


    /**
     * Conquer and divide
     *
     * @param input - array of building dimensions
     * @return
     */
    public int[][] recurse(int[][] input, int left, int right) {

        // Base
        if (left >= right) {
            return this.genCornerCoordinates(input[left]);
        }


        // Divide
        int center = (left + right) / 2;
        int[][] leftSubProblem = this.recurse(input, left, center);
        int[][] rightSubProblem = this.recurse(input, center+1, right);

        // Conquer (Eliminate enclosed points)
        return this.mergeCoordinates(leftSubProblem, rightSubProblem);
    }


    /**
     * Generate initial coordinates for a given building shape.
     *
     * @param buildingShape -
     * @return coordinates for building
     */
    public int[][] genCornerCoordinates(int[] buildingShape) {

        int[][] coordinates = new int[2][2];

        coordinates[0][0] = buildingShape[0];
        coordinates[0][1] = buildingShape[buildingShape.length - 1];

        coordinates[1][0] = buildingShape[1];
        coordinates[1][1] = 0;

        return coordinates;
    }


    /**
     * Elimination of enclosed coordinates. Separated merge step for given DQ algorithm.
     *
     * @param leftSub - coordinates of left sub-array
     * @param rightSub - coordinates of right sub-array
     * @return
     */
    public int[][] mergeCoordinates(int[][] leftSub, int[][] rightSub) {

        LinkedList<int[]> skylineCoords = new LinkedList<int[]>();

        // Check all coordinates and merge into coord list
        int leftIndx = 0;
        int rightIndx = 0;
        int[] previouslyAdd;
        int[] coordToAdd;
        int toAddIndx;
        boolean leftSmaller; // which side was taken  ? left: true, right: false


        while (leftIndx < leftSub.length && rightIndx < rightSub.length) {

            if (leftSub[leftIndx][0] < rightSub[rightIndx][0]) {
                leftSmaller = true;
                coordToAdd = leftSub[leftIndx];
            }

            leftSmaller = leftSub[leftIndx][0] < rightSub[rightIndx][0]? true : false;
            coordToAdd = leftSmaller? leftSub[leftIndx] : rightSub[rightIndx];
            toAddIndx = leftSmaller? leftIndx : rightIndx;

            // Add first element to the list
            if (skylineCoords.isEmpty()) {
                if (leftSub[leftIndx][0] < rightSub[rightIndx][0]) {
                    skylineCoords.add(leftSub[leftIndx]);
                    leftIndx++;
                    continue;
                }

                // Building shapes begin at the same indx.
                skylineCoords.add(leftSub[leftIndx][1] < rightSub[rightIndx][1]? rightSub[rightIndx] : leftSub[leftIndx]);
                leftIndx++;
                rightIndx++;
            }

            previouslyAdd = skylineCoords.peek(); // previous coordinate
        }

        return this.listToArray(skylineCoords);
    }


    /**
     * Transform list of points from a skyline shape into
     *
     * @param elements
     * @return
     */
    private int[][] listToArray(LinkedList<int[]> elements) {

        // Copy collected elements into an array
        int listLength = elements.size();
        int[][] arrayElements = new int[listLength][2];
        for (int i = 0; i < arrayElements.length; i++) {
            arrayElements[i] = elements.get(i);
            elements.pop();
        }

        return arrayElements;
    }
}
