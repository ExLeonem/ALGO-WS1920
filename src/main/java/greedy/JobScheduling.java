package greedy;

import divide_conquer.Maximum;
import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;
import java.util.PriorityQueue;


/**
 * Time calculation for scheduling of jobs.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-10
 */
public class JobScheduling {


    /**
     * Calculate the total amount of time to execute all jobs on a specific amount of threads.
     *
     * Pre-Steps
     *  - Sort jobs in descending order
     *  - Keep Threads sorted with PriorityQueue (thread which is done the earliest with his task)
     *
     * Greedy Condition(s):
     *  - Select thread which finishes his tasks the earliest
     *  - Select jobs taking shortest time than the others
     *
     * @param jobs - an array of jobs to be executed
     * @param threads - the amount of threads to use
     * @return an integer representing the time it takes to finishes all jobs by the given amount of threads
     */
    public int minimizeMean(int[] jobs, int threads) {

        // initialize thread queue
        PriorityQueue<Integer> threadQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < threads; i++) {
            threadQueue.add(0);
        }

        // Pre-Sort jobs (shortest job first, longest last)
        QuickSort quick = new QuickSort();
        int[] sortedJobs = quick.sort(jobs);
        for (int job : sortedJobs) {

            int smallestThread = threadQueue.remove();
            smallestThread += job;
            threadQueue.add(smallestThread);
        }

        // Empty queue and return longest time
        int threadTime = 0;
        while (!threadQueue.isEmpty()) {
            threadTime = threadQueue.remove();
        }

        return threadTime;
    }
}
