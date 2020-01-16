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

        return this.recurse(input, 0, input.length-1);
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
     * Merge the sub-solution of the recursion step
     *
     * @param leftSubSolution - left sub-solution from left recursion
     * @param rightSubSolution - right sub-solution from right recursion
     * @return
     */
    public int[][] mergeCoordinates(int[][] leftSubSolution, int[][] rightSubSolution) {

        LinkedList<Point> newOptim = new LinkedList<Point>();
        int i = 0, j = 0;

        char firstElementType = this.whichTypeNext(i, leftSubSolution, j, rightSubSolution);
        if (firstElementType == 'l') {
            newOptim.add(new Point('l', leftSubSolution[i]));
            i++;
        } else {
            newOptim.add(new Point('r', rightSubSolution[j]));
            j++;
        }

        // Iterate over rest and merge
        while (i < leftSubSolution.length && j < rightSubSolution.length) {

            Point toAdd;
            Point nextPoint;

            char type = this.whichTypeNext(i, leftSubSolution, j, rightSubSolution);
            if (type == 'l') {
                
            } else {

            }


            // Select the next point to add
            if (leftSubSolution[i][0] == rightSubSolution[j][0]) {
                if (leftSubSolution[i][1] > rightSubSolution[j][1]) {
                    toAdd = new Point('l', leftSubSolution[i]);
                    i++;
                } else {
                    toAdd = new Point('r', rightSubSolution[j]);
                    j++;
                }

            } else if (leftSubSolution[i][0] < rightSubSolution[j][0]) {
                toAdd = new Point('l', leftSubSolution[i]);
                i++;

            } else {
                toAdd = new Point('r', rightSubSolution[j]);
                j++;

            }

            // Merge
            Point lastPoint = newOptim.peekFirst();
            if (lastPoint.compareY(toAdd) >= 0) {
                newOptim.add(toAdd);
                continue;
            }

            // Different point types && both stop
            if (toAdd.isStop() && lastPoint.isStop() && !lastPoint.compareType(toAdd)) {
                lastPoint = newOptim.poll(); // Retrieve last element for comparison

                // Search for point last inserted with other point


            }

            // toAdd is below lastAdded point

        }

        // Use up the remaining points from the right sub solution
        while (j < rightSubSolution.length) {
            newOptim.add(new Point('r', rightSubSolution[j]));
            j++;
            break;
        }

        return this.listToArray(newOptim);
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


    private char whichTypeNext(int leftIndx, int[][] pointsLeft, int rightIndx, int[][] pointsRight) {

        char type = 'l';

        if (pointsLeft[leftIndx][0] == pointsRight[rightIndx][0] && pointsLeft[leftIndx][1] < pointsRight[rightIndx][1]) {
            // Same x-coordinates and higher y-coordinate in right points
            type = 'r';

        } else if (pointsLeft[leftIndx][0] > pointsRight[rightIndx][0]) {
            // higher x-coordinate in right point
            type = 'r';

        }

        return type;
    }

    /**
     * Transform list of points from a skyline shape into
     *
     * @param elements
     * @return
     */
    private int[][] listToArray(LinkedList<Point> elements) {

        // Copy values into optimum array
        int[][] optim = new int[elements.size()][2];
        for (int k = 0; k < optim.length && !elements.isEmpty(); k++) {
            optim[k] = elements.poll().getCoords();
        }

        return optim;
    }



    // Container class to save point into && compare
    private class Point {

        private char type; // Indicates if point is of left or right sub-solution
        private int[] coords;


        public Point(char type, int... points) {
            this.type = type;
            this.coords = points;
        }


        public Point(char type, int x, int y) {
            this.type = type;
            this.coords = new int[2];
            this.coords[0] = x;
            this.coords[1] = y;
        }



        // ----------------------
        // Utilites
        // ----------------------

        /**
         * Compares the x-coordinates of the current point to another point.
         *  1: other point is bigger in x
         *  0: points equal in x-coordinate
         *  -1: current point is bigger in x
         *
         * @param oPoint - the other point for coordinate comparison
         * @return integer representing the comparison
         */
        public int compareX(Point oPoint) {

            int[] oPointCoords = oPoint.getCoords();
            int[] currentPointCoords = this.getCoords();

            if (oPointCoords[0] == currentPointCoords[0]) {
                return 0;
            } else if (oPointCoords[0] > currentPointCoords[0]) {
                return 1;
            }

            return -1;
        }


        /**
         * Compares the y-coordinates of the current point to another point.
         *  1: other point is bigger in y
         *  0: points equal in y
         *  -1: current point is bigger in y
         *
         * @param oPoint - the other point for coordinate comparison
         * @return
         */
        public int compareY(Point oPoint) {

            int[] oPointCoords = oPoint.getCoords();
            int[] currentPointCoords = this.getCoords();

            if (oPointCoords[1] == currentPointCoords[1]) {
                return 0;
            } else if (oPointCoords[1] > currentPointCoords[1]) {
                return 1;
            }

            return -1;
        }


        /**
         * Compare two types of points.
         *
         * @param oPoint - the other point to use type of
         * @return true | false (equal or not)
         */
        public boolean compareType(Point oPoint) {

            char oPointType = oPoint.getType();
            char currentType = this.getType();

            if (oPointType == currentType) {
                return true;
            }

            return false;
        }


        /**
         * Check if the current point represents a stop point for a skyline shape (y-coordinate is zero)
         *
         * @return true | false
         */
        public boolean isStop() {

            int[] coords = this.getCoords();
            if (coords[1] == 0) {
                return true;
            }

            return false;
        }



        // -------------
        // Getter
        // -------------

        public int[] getCoords() {
            return this.coords;
        }

        public char getType() {
            return this.type;
        }

        public int getX() {
            return this.coords[0];
        }

        public int getY() {
            return this.coords[1];
        }
    }



}
