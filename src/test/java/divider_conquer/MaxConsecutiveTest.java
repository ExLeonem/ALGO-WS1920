package divider_conquer;

import supplementary.utils.ArrayUtils;
import divide_conquer.MaxConsecutive;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MaxConsecutiveTest {

    MaxConsecutive maxConsecutive = new MaxConsecutive();
    ArrayUtils utils = new ArrayUtils();


    @Test
    void singleElementEven() {
        int[] values = {5, 3, 2, 1, -2, -5};
        int maxOrder = maxConsecutive.search(values);

        assertEquals(1, maxOrder);
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

        assertEquals(2, maxOrder);
    }


    @Test
    void maxOrderArrayLength() {
        Random rand = new Random();
        final int MAX_ARRAY_LENGTH = 20;
        final int MIN_ARRAY_LENGTH = 2;
        int[] greaterThanArray = new int[rand.nextInt(MAX_ARRAY_LENGTH) + MIN_ARRAY_LENGTH];
        for (int i = 0; i < greaterThanArray.length; i++) {
            greaterThanArray[i] = i+1;
        }

        int maxOrderCalculated = maxConsecutive.search(greaterThanArray);
        int expectedOrder = greaterThanArray.length;

        assertEquals(expectedOrder, maxOrderCalculated);
    }


    @Test
    void random() {

        // Random Number generation setup
        final int MAX_LIST_LENGTH = 49;
        final int MIN_LIST_LENGTH = 2;
        final int MAX_INT_HIGH = 50;
        final int MAX_INT_LOW = 10;

        // Iteration Parameter
        Random rand = new Random();
        int maxOrder = 1;
        int maxOrderIndxStart = 0;
        int lastIndx = 0;
        int newElement;
//        int[] elements = new int[rand.nextInt(MAX_LIST_LENGTH) + MIN_LIST_LENGTH];
        int[] elements = new int[10];
        // Generate list of random values
        for (int i = 0; i < elements.length; i++) {
            newElement = rand.nextInt(MAX_INT_HIGH) - MAX_INT_LOW;
            elements[i] = newElement;

            if (i == 0) {
                continue;
            }

            if (elements[i] > elements[i-1]) {
                if ((i - lastIndx) > maxOrder ) {
                    maxOrder = (i - lastIndx);
                    maxOrderIndxStart = (i - lastIndx);
                    System.out.println("Start: " + lastIndx);
                    System.out.println("End: " + i);
                }
                continue;
            }

            lastIndx = i;
        }

        int maxOrderCalculated = maxConsecutive.search(elements);
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " | ");
        }

        System.out.println("\nOptimal");
        for (int i = maxOrderIndxStart; i < maxOrderIndxStart + maxOrder; i++) {
            System.out.print(elements[i] + " | ");
        }


        System.out.println("\nCalculated: " + maxOrderCalculated);
        System.out.println("Actual: " + maxOrder);
        assertEquals(maxOrder+1, maxOrderCalculated);
    }

}
