package divider_conquer;


import divide_conquer.Exchanges;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangesTest {


    @Test
    void testSingle() {
        Exchanges ex = new Exchanges();
        int[] numbers = {1};
        int result = ex.count(numbers);

        assertEquals(0, result);
    }


    @Test
    void singleExchange() {
        Exchanges ex = new Exchanges();
        int[] numbers = {2, 1};
        int result = ex.count(numbers);

        assertEquals(2, result);
    }


    @Test
    void twoExchanges() {
        Exchanges ex = new Exchanges();
        int[] numbers = {3, 2, 1};
        int result = ex.count(numbers);

        assertEquals(3, result);
    }


    @Test
    void multipleExchanges() {
        Exchanges ex = new Exchanges();
        int[] numbers = {5,3, 21, 3, 1, 5, 2};
        int[] sorted = {1, 2, 3, 3, 5, 5, 21};

        int changes = ex.count(numbers);
        int[] solution = ex.getSorted();

//        assertEquals(3, changes);
        assertArrayEquals(sorted, ex.getSorted());
    }

}
