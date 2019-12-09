package greedy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HuffmannTest {


    Huffmann huff = new Huffmann("Hello", "World", "HuffHuff", "whatever");


    @Test
    void checkAll() {
        String alphabet = "helowdhuftvr";
        String actual = huff.encode(alphabet);
        String expected = "1";

        assertEquals(expected, actual);
    }

    @Test
    void elementHello() {
        String value = "hello";
        String actual = huff.encode(value);
        String expected = "0101";

        assertEquals(expected, actual);
    }

    @Test
    void elementWorld() {
        String value = "helwo";
        String actual = huff.encode(value);
        String expected = "0101";

        assertEquals(expected, actual);
    }


    @Test
    void twoElementUnique() {
        String firstString = "Hello";
        String secondString = "helwo";
        String firstActual = huff.encode(firstString);
        String secondActual = huff.encode(secondString);

        assertNotEquals(firstActual, secondActual);
    }


    @Test
    void singleElementArray() {
        String[] elements = new String[]{"Hello"};
        String[] actual = huff.encode(elements);
        String[] expected = new String[]{"001"};

        assertArrayEquals(expected, actual);
    }


    @Test
    void twoElementEncoding() {
        String[] elements = new String[]{"hello", "whatever"};
        String[] actual = huff.encode(elements);
        String[] expected = new String[]{"0101010", "02101"};

        assertArrayEquals(expected, actual);
    }


    @Nested
    class SmallAlphabetTest {

        @Test
        class singleCharacter() {
            String value =
        }

    }
}
