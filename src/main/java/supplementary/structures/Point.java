package supplementary.structures;

/**
 * Supplementary structure to work with points of arbitary dimensions.
 *
 * @author Maksim Sandybekov
 * @date 2019-20-11
 */
public class Point {

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
     * @param point -
     * @return
     */
    public double distanceTo(Point point) {

        if (point == null) {
            return Double.MAX_VALUE;
        }

        return this.distanceTo(point, this.defaultMetric);
    }

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
}
