package supplementary.structures.trees;

import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MinHeapTest {


    @Test
    void emptyHeapNoMax() {
        MinHeap heap = new MinHeap();

        // Check max-value
        int actualMax = heap.max();
        int expectedMax = 0;
        assertEquals(expectedMax, actualMax);

        // Check min-value
        int actualMin =
                heap.min();
        int expectedMin = 0;
        assertEquals(expectedMin, actualMin);
    }


    @Test
    void checkParentRetention() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(5);
        heap.insert(4);

        int actualLeft = heap.parent(1);
        int actualRight = heap.parent(2);
        int expected = 4;

        assertEquals(actualLeft, actualRight);
        assertEquals(expected, heap.get(actualLeft));
    }


    @Test
    void checkChildrenRetention() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(5);
        heap.insert(4);

        int leftChild = heap.leftChild(0);
        int rightChild = heap.rightChild(0);

        int leftExpected = 7;
        int rightExpected = 5;

        assertEquals(leftExpected, heap.get(leftChild));
        assertEquals(rightExpected, heap.get(rightChild));
    }


    @Test
    void singleInsertion() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        int actual = heap.max();
        int expected = 7;

        assertEquals(expected, actual);
    }


    @Test
    void multiInsert() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(5);
        heap.insert(6);
        heap.insert(12);

        int actualSize = heap.getSize();
        int expectedSize = 4;
        assertEquals(expectedSize, actualSize);

        int actualMaxSize = heap.getMaxSize();
        int expectedMaxSize = 5;
        assertEquals(expectedMaxSize, actualMaxSize);
    }


    @Test
    void insertOversize() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(10);
        heap.insert(5);
        heap.insert(2);
        heap.insert(5);
        heap.insert(10);

        int actualSize = heap.getSize();
        int expectedSize = 6;
        assertEquals(expectedSize, actualSize);

        int actualMaxSize = heap.getMaxSize();
        int expecteMaxSize = 6;
        assertEquals(expecteMaxSize, actualMaxSize);
    }


    @Test
    void testHeapifyOfElements() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(6);
        heap.insert(10);
        heap.insert(15);
        int actual = heap.max();
        int expected = 15;

        assertEquals(expected, actual);
    }


    @Test
    void testMinMaxRetention() {
        MinHeap heap = new MinHeap();
        heap.insert(7);
        heap.insert(8);
        heap.insert(15);
        heap.insert(20);
        heap.insert(4);

        // Check max retention
        int actual = heap.max();
        int expected = 20;
        assertEquals(expected, actual);

        // Check min retention
        int actualMin = heap.min();
        int expectedMin = 4;
        assertEquals(expectedMin, actualMin);
    }


    @Test
    void random() {

        final int HEAP_SIZE_MAX = 100;
        final int HEAP_SIZE_MIN = 10;
        final int VALUE_MIN = -50;
        final int VALUE_MAX = 50;

        Random rand = new Random();
        int max = 0;
        int min = 0;

        int[] heapValues = new int[rand.nextInt(HEAP_SIZE_MAX - HEAP_SIZE_MIN) + HEAP_SIZE_MIN];
        for (int i = 0; i < heapValues.length; i++) {

            int nextInt = rand.nextInt(VALUE_MAX - VALUE_MIN) + VALUE_MIN;
            heapValues[i] = nextInt;

            // Update maximum value
            if (max < nextInt) {
                max = nextInt;
            }

            if( min > nextInt) {
                min = nextInt;
            }
        }

        // Compare max
        MinHeap heap = new MinHeap(heapValues);

        int actualMax = heap.max();
        assertEquals(max, actualMax);

        // Copare min values
        int actualMin = heap.min();
        assertEquals(min, actualMin);

        // Compare Sizes
        int actualSize = heap.getSize();
        assertEquals(heapValues.length, actualSize);
    }

}
