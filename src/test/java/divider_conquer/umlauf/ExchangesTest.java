package divider_conquer.umlauf;


import divide_conquer.umlauf.Exchanges;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExchangesTest {

    Exchanges ex = new Exchanges();

    @Test
    void testSingle() {
        int[] numbers = {1};
        int result = ex.count(numbers);

        assertEquals(0, result);
    }


}
