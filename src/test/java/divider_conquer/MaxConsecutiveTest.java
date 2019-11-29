package divider_conquer;

import divide_conquer.MaxConsecutive;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaxConsecutiveTest {

    MaxConsecutive maxConsecutive = new MaxConsecutive();

    @Test
    void singleElementEven() {
        int[] values = {5, 3, 2, 1, -2, -5};
        int maxOrder = maxConsecutive.search(values);

        assertEquals(5, maxOrder);
    }


    @Test
    void singleElement() {
        int[] values = {1};
        int maxOrder = maxConsecutive.search(values);

        assertEquals(1, maxOrder);
    }


    @Test
    void smallestEven() {
        int[] evenElements = {1, 2};
        int maxOrder =  maxConsecutive.search(evenElements);

        assertEquals(2, maxOrder);
    }


    @Test
    void smallestUneven() {
        int[] unevenElements = {1,-1, 5};
        int maxOrder = maxConsecutive.search(unevenElements);

        assertEquals(5, maxOrder);
    }


    @Test
    void random() {

        // Random Number generation setup
        final int MAX_LIST_LENGTH = 50;
        final int MAX_INT_HIGH = 500;
        final int MAX_INT_LOW = 500;

        // Iteration Parameter
        Random rand = new Random();
        int maxOrder = 0;
        int lastElement = 0;
        int[] elements = new int[rand.nextInt(MAX_LIST_LENGTH)];
        int newElement;

        // Generate list of random values
        for (int i = 0; i < elements.length; i++) {
            newElement = rand.nextInt(MAX_INT_HIGH) - MAX_INT_LOW;

            if (newElement > lastElement) {
                maxOrder++;
            } else {
                maxOrder = 1;
            }

            elements[i] = newElement;
            lastElement = newElement;
        }

        int maxOrderCalculated = maxConsecutive.search(elements);
        assertEquals(maxOrder, maxOrderCalculated);
    }

}
