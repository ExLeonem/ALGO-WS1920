package greedy;

import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem ist NP-Vollständig.
 *
 * Gegeben k- Behälter, Größe der Behälter und n- Objekte mit gewichten/größen.
 * Fragestellung: Können die Objekte auf die behälter Aufgeteilt werden ohne das diese überlaufen?
 *
 * @author Maksim Sandybekov
 * @date 2019-12-10
 */
public class BinPacking {


    /**
     * Calculate the amount of bins that are needed to take hold of objects.
     *
     * Greedy-Condition:
     *  - Take object that takes the least space
     *  - Take the bin with most space left for objects
     *
     * @param maxNumberBins - amount of bins that can be used at maximum
     * @param maxBinSpace - the packable height/weight per bin
     * @param objects - array of object weights/heights with only positive values
     * @return true/false depending upon if objects packable into bins
     */
    public int packable(int maxNumberBins, int maxBinSpace, int[] objects) {

        if (maxNumberBins < 1 || maxBinSpace <= 0) {
            return -1;
        }

        // Pre-sort objects descending by needed space
        QuickSort quick = new QuickSort(Order.DESC);
        int[] sortedObjects = quick.sort(objects);

        // Try to fit objects into available bins
        int[] bins = new int[maxNumberBins];
        int binCount = 0;
        int binIndxToUse = -1;
        for (int i = 0; i < sortedObjects.length; i++) {

            binIndxToUse = this.selectNextBin(sortedObjects[i], bins, maxBinSpace);
            if (binIndxToUse < 0) {
                return -1;
            }

            // Track amount of bins in use
            if (binIndxToUse > binCount) {
                binCount = binIndxToUse;
            }

            bins[binIndxToUse] += sortedObjects[i];
        }

        return binCount+1;
    }


    /**
     * Search for the smallest open bin an object fits in.
     *
     * @param objectToPut
     * @param bins
     * @param maxBinSize
     * @return index of bin an object has place in or -1 if no bin was found
     */
    private int selectNextBin(int objectToPut, int[] bins, int maxBinSize) {

        int binIndx = -1;
        int binSize = maxBinSize;
        int nextNewBin = -1;
        for (int i = 0; i < bins.length; i++) {

            // Select smallest bin, which was opened but has enough space for object
            if (bins[i] > 0 && bins[i] <= binSize && (objectToPut + bins[i] <= maxBinSize)) {
                binIndx = i;
                binSize = bins[i];
            }

            // New bin is available and object fits
            if (bins[i] == 0 && nextNewBin == -1 && (bins[i] + objectToPut) <= maxBinSize) {
                nextNewBin = i;
            }
        }

        if (binIndx == -1) {
            return nextNewBin;
        }

        return binIndx;
    }

}
