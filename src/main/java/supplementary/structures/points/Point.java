package supplementary.structures.points;

import java.util.Arrays;
import java.util.Objects;

/**
 * Supplementary structure to work with points of arbitary dimensions.
 *
 * @author Maksim Sandybekov
 * @date 2019-20-11
 */
public class Point implements Comparable<Point> {

    private double[] coordinates;
    private int dim; // Point dimensions
    private PointDistance defaultMetric; // euclidean | manhatten

    public Point() {}

    public Point(int dimensions) {
        this.coordinates = new double[dimensions];
        this.dim = dimensions;
        this.defaultMetric = PointDistance.EUCLIDEAN;
    }

    public Point(double... coordiantes) {
        this.coordinates = coordiantes;
        this.dim = coordinates.length;
        this.defaultMetric = PointDistance.EUCLIDEAN;
    }


    /**
     * Calculate distance between two points use euclidean distance as default metric
     *
     * @param point - the other point
     * @return
     */
    public double distanceTo(Point point) {

        if (point == null) {
            return Double.MAX_VALUE;
        }

        return this.distanceTo(point, this.defaultMetric);
    }


    /**
     * Similar to above method with additional parameter for a specific distance metric.
     *
     * @param point - the other point
     * @param distanceMetric - the distance metric to use for distance calcculation
     * @return
     */
    public double distanceTo(Point point, PointDistance distanceMetric) {

        if (point == null) {
            return Double.MAX_VALUE;
        }

        // Are the two points comparable at all?
        double[] thisCoordinates = this.getCoordinates();
        double[] otherCoordinates = point.getCoordinates();

        return distanceMetric.compute(thisCoordinates, otherCoordinates);
    }



    // --------------------------
    // Utility functions
    // -------------------------

    public double valueAt(int index) {
        return this.coordinates[index];
    }

    public int dimensions() {
        return this.dim;
    }



    // --------------------------
    // Setter/-Getter
    // -------------------------

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    // --------------------------
    // Equal/Hashcode
    // -------------------------

    @Override
    public int compareTo(Point o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return dim == point.dim &&
                Arrays.equals(coordinates, point.coordinates) &&
                defaultMetric == point.defaultMetric;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dim, defaultMetric);
        result = 31 * result + Arrays.hashCode(coordinates);
        return result;
    }

    @Override
    public String toString() {
        String pointDef =  "Point: (Dim: ";

        double[] coords = this.getCoordinates();
        pointDef += coords.length + "| ";
        for (int i = 0; i < coords.length; i++) {

            if (i == coords.length -1) {
                pointDef += coords[i] + ");";
                break;
            }
            pointDef += coords[i] + ", ";
        }

        return pointDef;
    }

}
