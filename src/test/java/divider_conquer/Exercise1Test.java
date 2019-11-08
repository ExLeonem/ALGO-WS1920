package divider_conquer;

import org.junit.jupiter.api.Test;
import divide_conquer.Exercises1;

import static org.junit.Assert.assertArrayEquals;

public class Exercise1Test {


    @Test
    void simpleTest() {
        Exercises1 ex = new Exercises1();
        double[] players = new double[]{2.2, 1.1, 4.3, 2.3};
        double[][] result = new double[][]{{1.1, 2.2}, {2.3, 4.3}};

        assertArrayEquals(ex.grinchPartition(players), result);
    }

    @Test
    void testUnsortedSimple() {

        double[] values = new double[]{5.3, 2.2, 4.5, 3.2, 1.5, 6.3};
        double[] result =

        assertArrayEquals();
    }

}
