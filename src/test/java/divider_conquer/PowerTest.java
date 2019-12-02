package divider_conquer;

import divide_conquer.Power;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PowerTest {

    Power power = new Power();

    @Test
    void powerToNonZero() {
        int base = 2;
        int exp = 4;

        int expected = 16;
        int actual = power.pow(base, exp);

        assertEquals(expected, actual);
    }


    @Test
    void powerToZero() {
        int base = 0;
        int exp = 5;

        int expected = 0;
        int actual = power.pow(base, exp);

        assertEquals(expected, actual);
    }


    @Test
    void powerToRandom() {

        final int MAX_BASE = 10;
        final int MAX_EXP = 10;
        final int MIN_EXP = 2;

        Random rand = new Random();
        int base = rand.nextInt(MAX_BASE);
        int exp = rand.nextInt(MAX_EXP) + MIN_EXP;

        int expected = 1;
        for (int i = 0; i < exp; i++) {
            expected *= base;
        }

        int actual = power.pow(base, exp);

        assertEquals(expected, actual);
    }
}
