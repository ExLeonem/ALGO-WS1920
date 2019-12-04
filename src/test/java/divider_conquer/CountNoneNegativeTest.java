package divider_conquer;

import divide_conquer.CountNoneNegative;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNoneNegativeTest {

    CountNoneNegative nnCounter = new CountNoneNegative();


    @Test
    void singleElementNegative() {

        int[] numbers = {-1};
        int result = this.nnCounter.count(numbers);
        assertEquals(0, result);
    }


    @Test
    void singleElementNoneNegative() {

        int[] numbers = {1};
        int result = this.nnCounter.count(numbers);
        assertEquals(1, result);
    }


    @Test
    void multipleTest() {

        int[] numbers = {4, -1, 2, 5, -3, 22, -111};
        int result = this.nnCounter.count(numbers);
        assertEquals(4, result);
    }


    @Test
    void randomGen() {

        Random rand = new Random();
        int[] numbers = new int[rand.nextInt(25)+1];
        int nonNegativeCount = 0;

        // Generate random numbers and count them
        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = rand.nextInt(401) - 200; // numbers between -200 and 200
            if (numbers[i] >= 0) {
                nonNegativeCount++;
            }
        }

        int result = this.nnCounter.count(numbers);
        assertEquals(nonNegativeCount, result);
    }
}
