package divider_conquer;

import divide_conquer.ConvexHull;
import org.junit.jupiter.api.Test;
import supplementary.structures.points.Point;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvexHullTest {

    ConvexHull convexHull = new ConvexHull();

    @Test
    void simpleTest() {
        Point[] points = new Point[]{new Point(2,2), new Point(4, 5), new Point(1, 5)};
        Point[] actual = convexHull.calculate(points);
        Point[] expected = new Point[]{new Point(1, 5), new Point(2, 2), new Point(4, 5)};

        assertArrayEquals(expected, actual);
    }


    @Test
    void random() {

    }

}
