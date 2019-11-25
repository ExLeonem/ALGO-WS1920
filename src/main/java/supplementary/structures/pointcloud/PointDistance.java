package supplementary.structures.pointcloud;

import java.util.function.Function;

/**
 *
 * @author Maksim Sandybekov
 * @date 2019-20-11
 */
public enum PointDistance {

    EUCLIDEAN {
        /**
         * Compute the euclidean distance between two points, given as two double arrays.
         *
         * @param arrayA - first point
         * @param arrayB - second point
         * @return the distance
         */
        @Override
        public double compute(double[] arrayA, double[] arrayB) {

            // Check if distance is computeable
            if (arrayA.length != arrayB.length) {
                throw new IllegalArgumentException("Can't compute euclidean distance because dimensions of points don't match");
            }

            double summedValues = 0;
            double difference = 0;
            for (int i = 0; i < arrayA.length; i++) {
                difference = arrayA[i] - arrayB[i];
                summedValues += (difference * difference); // raise to power 2
            }

            return Math.sqrt(summedValues);
        }
    },
    MANHATTEN {
        /**
         * Computes the manhatten distance between two points
         *
         * @param arrayA - first point
         * @param arrayB - second point
         *
         * @return
         */
        @Override
        public double compute(double[] arrayA,  double[] arrayB) {

            double distance = 0;
            for (int i = 0; i < arrayA.length; i++) {
                distance += Math.abs(arrayA[i] - arrayB[i]);
            }

            return distance;
        }
    };



    // Compute between the distance between two different entities
    public abstract double compute(double[] arrayA, double[] arrayB);
}
