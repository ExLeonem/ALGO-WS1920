package greedy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HuffmannTest {


    Huffmann huff = new Huffmann("Hello", "World", "HuffHuff", "whatever", "KKKKKKKKKKK");


    @Test
    void checkMostOccurences() {
        String character = "K";
        String actual = huff.encode(character);
        String expected = "10";

        assertEquals(expected, actual);
    }


    @Test
    void checkAll() {
        String alphabet = "helowdhuftvr";
        String actual = huff.encode(alphabet);
        String expected = "00110111000001101101111100000110001001011001001110111";

        assertEquals(expected, actual);
    }


    @Test
    void elementMultiple() {
        String value = "eee";
        String actual = huff.encode(value);
        String expected = "111011101110";

        assertEquals(expected, actual);
    }


    @Test
    void elementWorld() {
        String value = "helwo";
        String actual = huff.encode(value);
        String expected = "0011011100001101110110";

        assertEquals(expected, actual);
    }


    @Test
    void twoElementUnique() {
        String firstString = "Hello";
        String secondString = "Helwo";
        String firstActual = huff.encode(firstString);
        String secondActual = huff.encode(secondString);

        assertNotEquals(firstActual, secondActual);
    }


    @Test
    void singleElementArray() {
        String[] elements = new String[]{"Hello"};
        String[] actual = huff.encode(elements);
        String[] expected = new String[]{"111111100000000110"};

        assertArrayEquals(expected, actual);
    }


    @Test
    void twoElementEncoding() {
        String[] elements = new String[]{"hello", "whatever"};
        String[] actual = huff.encode(elements);
        String[] expected = new String[]{"110111001101101101100111100011111100111", "0011011100000000110"};

        assertArrayEquals(expected, actual);
    }


    @Test
    void checkUniquenessOfEach() {

        String alphabet = "helowduftvr";
        String[] encodings = new String[alphabet.length()];
        for (int i = 0; i < alphabet.length(); i++) {
            encodings[i] = huff.encode(String.valueOf(alphabet.charAt(i)));
        }

        // Compare each encoding with all others
        for (int i = 0; i < encodings.length; i++) {

            for (int j = i+1; j < encodings.length; j++) {
//                System.out.println("Compare i: (" + i + ", encoding: " + encodings[i] + ") to j: (" + j + ", encoding: " + encodings[j] + ")");
                assertNotEquals(encodings[i], encodings[j]);
            }
        }
    }


    @Nested
    class SmallAlphabetTest {

        @Test
        void singleCharacter() {
            String value = "a";
            Huffmann huff = new Huffmann(value);

            String actual = huff.encode(value);
            String expected = "0";

            assertEquals(expected, actual);
        }


        @Test
        void twoCharacters() {
            String alphabet = "ab";
            Huffmann huff = new Huffmann(alphabet);
//            huff.printTree();

            String first = huff.encode("a");
            String second = huff.encode("b");

            assertNotEquals(first, second);
        }


        @Test
        void duplicatesInAlphabet() {
            String alphabet = "abcdBbbB";
            Huffmann huff = new Huffmann(alphabet);
            String actual = huff.encode("b");
            String expected = "0";

            assertEquals(expected, actual);
        }


        @Test
        void encodeCapitalizeCaseNotEqual() {
            String alphabet = "abcdB";
            Huffmann huff = new Huffmann(alphabet);
            String encodeUpper = huff.encode("b");
            String encodeLower = huff.encode("B");

            assertNotEquals(encodeLower, encodeUpper);
        }

    }
}
