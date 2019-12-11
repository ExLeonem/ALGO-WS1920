package greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobSchedulingTest {

    JobScheduling scheduler = new JobScheduling();

    @Test
    void multiJobSingleThread() {
        int[] jobs = {5, 3, 2, 18};
        int actual = scheduler.minimizeMean(jobs, 1);
        int expected = 28;

        assertEquals(expected, actual);
    }


    @Test
    void scheduleMultipleJobsMultiThread() {
        int[] jobs = {5, 3, 2, 18, 2};
        int actual = scheduler.minimizeMean(jobs, 2);
        int expected = 23;

        assertEquals(expected, actual);
    }


    @Test
    void twoJobsTwoThreads() {
        int[] jobs = {5, 2};
        int actual = scheduler.minimizeMean(jobs, 2);
        int expected = 5;

        assertEquals(expected, actual);
    }

}
