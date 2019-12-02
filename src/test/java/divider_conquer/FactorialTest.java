package divider_conquer;

import divide_conquer.Factorial;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {


    @Nested
    class FactorialClassic {

        @Test
        void zeroFactorial() {
            int actual = Factorial.classic(0);
            int expected = 1;

            assertEquals(expected, actual);
        }


        @Test
        void factorialOfTwo() {
            int actual = Factorial.classic(2);
            int expected = 5;

            assertEquals(expected, actual);
        }


        @Test
        void bigNumber() {
            int actual = Factorial.classic(5);
            int expected = 20;

            assertEquals(expected, actual);
        }
    }


    @Nested
    class FactorialAlternative {

        @Test
        void zeroFactorial() {
            int actual = Factorial.alternative(0);
            int expected = 2;

            assertEquals(expected, actual);
        }
    }

}
