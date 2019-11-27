package divider_conquer.umlauf;

import org.junit.jupiter.api.Test;
import supplementary.structures.points.Point;
import divide_conquer.umlauf.ClosestPoinPair;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ClosestPointPairTest {

    ClosestPoinPair closestPair = new ClosestPoinPair();


    @Test
    void twoPoints() {
        Point pointA = new Point(5.5, 3.3);
        Point pointB = new Point(7, 3);
        Point[] points = new Point[]{pointA, pointB};
        Point[] result = closestPair.calcuate(points);

        assertArrayEquals(points, result);
    }


    @Test
    void threePoints() {
        Point pointA = new Point();
        Point pointB = new Point();

        assertEquals(1, 1);
    }



    void testRandom() {

        Random rand = new Random();
        int pointDimensions = rand.nextInt(8);
        Point[] points = new Point[rand.nextInt(7)];
        for (int currentPoint = 0; currentPoint < points.length; currentPoint++) {

            double[] coordValues = new double[pointDimensions];
            for (int coord = 0; coord < pointDimensions; coord++) {
                coordValues[coord] = rand.nextDouble();
            }

            points[currentPoint] = new Point(coordValues);
        }

    }

}
