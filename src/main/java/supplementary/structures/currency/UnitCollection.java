package supplementary.structures.currency;

import java.util.Iterator;
import java.util.PriorityQueue;


/**
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public class UnitCollection implements Comparable<UnitCollection>{

    private String collectionSymbol;
    private PriorityQueue<Unit> units;
    private Iterator<Unit> unitIterator;
    private double max;


    // Actual unit value equals printable value
    public UnitCollection(String symbol, double... values) {

        this.collectionSymbol = symbol;

        // Add units to priority list for more convinient processing
        this.units = new PriorityQueue<Unit>();
        double max = Double.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {

            // No currencies with negative values
            if (values[i] <= 0) {
                throw new IllegalArgumentException("Can't add a currency unit with a value of 0 or less.");
            }

            if (values[i] > max) {
                max = values[i];
            }

            this.units.add(new Unit(symbol, (int) values[i], values[i]));
        }

        this.max = max;
        this.unitIterator = this.units.iterator();
    }


    // Actual unit value is different from printable value
    public UnitCollection(String symbol, double[][] unitValues) {

        this.collectionSymbol = symbol;

        // Put values in priority list for more convinient processing
        this.units = new PriorityQueue<Unit>();
        double max = Double.MIN_VALUE;
        for (int i = 0; i < unitValues.length; i++) {

            // No negative currency values
            if (unitValues[i][0] <= 0 || unitValues[i][1] <= 0) {
                throw new IllegalArgumentException("Can't add a currency unit with a value of 0 or less.");
            }

            this.units.add(new Unit(symbol, (int) unitValues[i][0], unitValues[i][1]));
        }

        this.max = max;
        this.unitIterator = this.units.iterator();
    }


    /**
     * Get next element from Iterator.
     *
     * @return
     */
    public Unit nextElement() {
        Iterator<Unit> it = this.unitIterator;

        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }


    /**
     * Iterator still has elements left?
     *
     * @return
     */
    public boolean hasNext() {
        return this.unitIterator.hasNext();
    }


    /**
     * Allows for comparing of UnitCollection objects.
     * @param o
     * @return 1 | 0 | -1
     */
    @Override
    public int compareTo(UnitCollection o) {

        double oMax = o.getMax();
        double max = this.getMax();
        if (oMax < max) {
            return 1;
        } else if (oMax == max) {
            return 0;
        }

        return -1;
    }


    // -------------------------------------
    // Setter/-Getter
    // ------------------------------------

    public double getMax() {
        return this.max;
    }

}
