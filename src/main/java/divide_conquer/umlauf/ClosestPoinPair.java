package divide_conquer.umlauf;

import supplementary.structures.pointcloud.Point;

/**
 * Algorithm to calculate the closest point pair.
 *
 * @author Maksim Sandybekov
 * @date 2019-20-11
 */
public class ClosestPoinPair {

    public Point[] calcuate(Point[] pointsInSpace) {

        if (pointsInSpace.length < 2) {
            throw new IllegalArgumentException("Can't closest pair of points for less than 2 Points.");
        }

        return this.recurse(pointsInSpace, 0, pointsInSpace.length);
    }


    private Point[] recurse(Point[] pointsInSpace, int left, int right) {

        // Base Case (two points), return Points with distance 0
        if (left >= right) {
            return new Point[]{pointsInSpace[right], null};
        }

        // Divide (each recursion returns always pair of length 2 and first element always != null)
        int center = (left + right) / 2;
        Point[] leftPointPair = this.recurse(pointsInSpace, left, center);
        Point[] rightPointPair = this.recurse(pointsInSpace, center+1, right);



        // Conquer (Merge)
        double rightDistance = rightPointPair[0].distanceTo(rightPointPair[1]);
        double leftDistance = leftPointPair[0].distanceTo(leftPointPair[1]);

        double minDistance = leftDistance < rightDistance? leftDistance : rightDistance;
        Point[] minPoints = leftDistance < rightDistance? leftPointPair : rightPointPair;
        int crossIndx = 0;
        for (int i = 0; i < leftPointPair.length; i++) {
            crossIndx = (1 + i) % 2; // 0 -> 1 && 1 -> 0

            if (leftPointPair[i] == null) {
                continue;
            }

            if (leftPointPair[i].distanceTo(rightPointPair[crossIndx]) < minDistance) {
                minPoints[crossIndx] = rightPointPair[crossIndx];
            }

            if (leftPointPair[i].distanceTo(rightPointPair[i]) < minDistance) {
                minPoints[crossIndx] = rightPointPair[i];
            }
        }

        return minPoints;
    }

}
