package supplementary.structures.currency;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Defines currencies that can be used for xchange calculation.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public enum Currency implements Cloneable {

    EUR(
            new UnitCollection("€", new double[]{1, 2, 5, 10, 20, 50, 100, 200, 500}),
            new UnitCollection("c", new double[][]{{1, .01}, {2, .02}, {5, .05}, {10, .1}, {20, .2}, {50, .5}})
    ),
    USD(
            new UnitCollection("$", new double[]{1, 2, 2.5, 3, 5, 10, 20, 50, 100, 500, 1000, 5000, 10000}),
            new UnitCollection("¢", new double[][]{{1, .01}, {2, .02}, {3, .03}, {5, .05}, {10, .1}, {20, .2}, {25, .25}})
    ),
    RUR(
            new UnitCollection("₽", new double[]{1, 2, 5, 10, 50, 100, 200, 500, 1000, 2000, 5000}),
            new UnitCollection("коп.", new double[][]{{1, .01}, {5, .05}, {10, .1}, {50, .5}})
    );


    private Unit[] currencyUnits;


    Currency(UnitCollection... unitCollections) {

        // Get length of all currency units
        int totalLength = 0;
        for (int i = 0; i < unitCollections.length; i++) {
            totalLength += unitCollections[i].getUnits().length;
        }

        //
        this.currencyUnits = new Unit[totalLength];
        int currencyIndx = 0;
        for (int i = 0; i < unitCollections.length; i++) {

            Unit[] units = unitCollections[i].getUnits();
            for (int j = 0; j < units.length; j++) {
                this.currencyUnits[currencyIndx] = units[j];
                currencyIndx++;
            }
        }
    }


    // ------------------------------
    // Setter/-Getter
    // -----------------------------

    public Unit[] getUnits() {
        return this.currencyUnits;
    }


    /**
     * @return comparator to compare unit elements
     */
    public Comparator<Unit> getUnitComparator() {
        return new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                if (o2.getValue() < o1.getValue()) {
                    return -1;
                } else if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return 1;
            }
        };
    }
}
