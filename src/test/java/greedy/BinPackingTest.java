package greedy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinPackingTest {


    @Test
    void singleBinFit() {
        BinPacking bins = new BinPacking();
        int[] objects = {5, 3, 12};
        int actual = bins.packable(1, 20, objects);

        assertEquals(1, actual);
    }


    @Test
    void singleBinNotFit() {
        BinPacking bins = new BinPacking();
        int[] objects = {5, 10};
        int actual = bins.packable(1, 10, objects);

        assertEquals(-1, actual);
    }


    @Test
    void multipleBinsFitAll() {
        BinPacking bins = new BinPacking();
        int[] objects = {10, 10, 10};
        int actual = bins.packable(3, 10, objects);

        assertEquals(3, actual);
    }

    @Test
    void multipleBinsOneInUse() {
        BinPacking bins = new BinPacking();
        int[] objects = {2, 2, 2, 2};
        int actual = bins.packable(4, 8, objects);

        assertEquals(1, actual);
    }


}
