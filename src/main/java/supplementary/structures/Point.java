package supplementary.structures;

/**
 * Represents an arbitary point in n-th space
 */
public class Point {

    private double[] coordinates;
    private int dim; // Point dimensions
    private DistanceMetric default_metric;

    public Point(int dimensions) {
        this.coordinates = new double[dimensions];
        this.dim = dimensions;
    }

    public Point(double... coordiantes) {
        this.coordinates = coordiantes;
        this.dim = coordinates.length;
    }


    /**
     * Calculate distance between two points use euclidean distance as default metric
     *
     * @param point -
     * @return
     */
    public double distance(Point point) {


        return .0;
    }

    public double distance(Point point, DistanceMetric distanceMetric) {

        // Are the two points comparable at all?
        double[] thisCoordinates = this.getCoordinates();
        double[] otherCoordinates = point.getCoordinates();
        if (thisCoordinates.length != point.dimensions()) {
            throw new IllegalArgumentException("Point's differ in dimensionality and therefore not comparable.");
        }

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
