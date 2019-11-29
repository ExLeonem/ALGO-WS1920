package divider_conquer;

import org.junit.jupiter.api.Test;
import supplementary.structures.points.Point;
import divide_conquer.ClosestPoinPair;
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

        closestPair.printPoints(result);

        assertArrayEquals(points, result);
    }


    @Test
    void fourPoints() {
        Point pointA = new Point(5, 3);
        Point pointB = new Point(12, 6);
        Point pointC = new Point(2, 6);
        Point pointD = new Point(1, 2);

        Point[] points = new Point[]{pointA, pointB, pointC, pointD};
        Point[] result = closestPair.calcuate(points);

        closestPair.printPoints(result);

        assertArrayEquals(new Point[]{pointC, pointD}, result);
    }


    @Test
    void threePoints() {
        Point pointA = new Point(5, 3);
        Point pointB = new Point(12, 6);
        Point pointC = new Point(2, 6);

        Point[] points = new Point[]{pointA, pointB, pointC};
        Point[] result = closestPair.calcuate(points);

        closestPair.printPoints(result);

        assertArrayEquals(new Point[]{pointA, pointC}, result);
    }


    @Test
    void largePointSpace() {

        Point pointA = new Point(5, 2, 1, 3, 2);
        Point pointB = new Point(2, 1, 2, 2, 2);
        Point pointC = new Point(12, 19, 2, 33, 12);
        Point pointD = new Point(15, 12, 2, 1, 2);
        Point pointE = new Point(2, 1, 2, 1, 2);
        Point pointF = new Point(5, 3, 2, 1, 18);
        Point pointX = new Point(12, 22, 12, 22, 888);

        Point[] points = new Point[]{pointA, pointB, pointC, pointD, pointE, pointF, pointX};
        Point[] result = closestPair.calcuate(points);

        Point[] exptected = new Point[]{pointE, pointB};

        assertArrayEquals(result, exptected);
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
