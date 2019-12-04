package divider_conquer.search_sort;


import divide_conquer.search_sort.BinSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinSearchTest {

    BinSearch bin = new BinSearch();


    @Test
    void searchCenterValue() {
        int[] values = {1, 2, 3, 4, 5};
        int index = bin.search(values, 3);
        int expected = 2;

        assertEquals(expected, index);
    }


    @Test
    void searchOutterLeftValue() {
        int[] values = {1, 2, 3, 4, 5};
        int index = bin.search(values, 1);
        int expected = 0;

        assertEquals(expected, index);
    }


    @Test
    void searchOutterRightValue() {
        int[] values = {1, 2, 3, 4, 5};
        int index = bin.search(values, 5);
        int expected = 4;

        assertEquals(expected, index);
    }


}
