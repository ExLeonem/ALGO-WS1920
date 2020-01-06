package divide_conquer;

import supplementary.structures.points.Point;

/**
 *
 *
 * @author Maksim Sandybekov
 * @date 2019-12-16
 */
public class ConvexHull {


    /**
     * Calculate the convex hull given a set of points.
     *
     * @param points - a set of points
     * @return
     */
    public Point[] calculate(Point[] points) {

        // Can't calculate a hull for less than 3 points.
        if (points.length < 3) {
            return null;
        }

        QuickSort<Point> quick = new QuickSort<Point>();


        Point[] convexHull = this.recurse(points, 0, points.length);
        return convexHull;
    }


    private Point[] recurse(Point[] points, int left, int right) {


        return null;
    }


    private Point[] merge() {


        return null;
    }

}
