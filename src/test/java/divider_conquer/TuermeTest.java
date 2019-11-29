package divider_conquer;

import divide_conquer.TuermeHanoi;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TuermeTest {


    @Test
    void standardField() {
        TuermeHanoi hanoi = new TuermeHanoi();
        int totalRounds = hanoi.solve();

        assertEquals(12, totalRounds);
    }


    @Test
    void singleField() {

    }

}
