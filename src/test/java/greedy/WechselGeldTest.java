package greedy;

import org.junit.jupiter.api.Test;
import supplementary.structures.currency.Currency;
import supplementary.structures.currency.Unit;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class WechselGeldTest {

    WechselGeld change = new WechselGeld();
    Currency currency  = Currency.EUR;


    @Test
    void testLowestAmount() {
        Unit[] actual = change.exchange(20, currency);
        Unit[] expected = new Unit[]{
                new Unit("€", 10),
                new Unit("€", 10),
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void testLowestPlusOne() {
        Unit[] actual = change.exchange(.01, currency);
        Unit[] expected = new Unit[]{new Unit("c", 1, .01)};

        assertArrayEquals(expected, actual);
    }

    @Test
    void borderCaseSecondSmallest() {
        Unit[] actual = change.exchange(.02, currency);
        Unit[] expected = new Unit[]{new Unit("c", 1, .01), new Unit("c", 1, .01)};

        assertArrayEquals(expected, actual);
    }

}
