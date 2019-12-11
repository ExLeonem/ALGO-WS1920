package greedy;

import divide_conquer.search_sort.Order;
import divide_conquer.search_sort.QuickSort;
import supplementary.structures.currency.Currency;
import supplementary.structures.currency.Unit;
import supplementary.utils.ArrayUtils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Maksim Sandybekov
 * @date 2019-12-4
 */
public class WechselGeld {


    /**
     * Calculates the exchange for a given amount of money.
     * Searching for minimal amount of change.
     * Greedy condition: Select biggest change smaller
     *
     * @param value - the amount of money.
     * @return array of actual exchange
     */
    public Unit[] exchange(double value, Currency currency) {

        QuickSort<Unit> quick = new QuickSort<Unit>(Order.DESC);
        Unit[] units = quick.sort(currency.getUnits());

        LinkedList<Unit> change = new LinkedList<Unit>();
        double restValue = value;
        int times = 0; // How many times value can be divided by a currency value
        boolean divided = false;
        for (Unit unit: units) {

            // Skip: unit equals change value except for 1 or higher unit values
            if ((unit.getValue() > restValue) || (unit.getValue() == restValue && !divided && unit.getValue() != .01)) {
                continue;
            }

            // Update variables to keep to current amount of change and value to be changed
            if (unit.getValue() <= restValue) {

                times = (int) (restValue / unit.getValue());
                restValue %= unit.getValue();
                System.out.println("Rest: " + restValue);

                // Add the amount of units into the linked list
                for (int i = 0; i < times; i++) {
                    change.add(unit.clone());
                }

                // Needed if restValue equals the unit value (was it divided at least a single time?)
                if (!divided) {
                    divided = true;
                }
            }
        }


        return this.listToArray(change);
    }

    public Unit[] exchange(int value, Currency currency) {
        return this.exchange((double) value, currency);
    }


    public void printExchange(double toExchange, double exchangeValues, Currency currency) {
        System.out.println("Change: " + toExchange + " to...\n---------------\n");

    }


    /**
     * LinkedList to Array conversion.
     *
     * @param change - a linked list of currency units
     * @return array of unit values
     */
    private Unit[] listToArray(LinkedList<Unit> change) {
        // Copy change into actual array to return
        Iterator<Unit> changeIterator  = change.iterator();
        Unit[] changeUnits = new Unit[change.size()];
        for (int i = 0; i < changeUnits.length; i++) {
            changeUnits[i] = changeIterator.next();
        }

        return changeUnits;
    }


}
