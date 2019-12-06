package supplementary.structures.currency;

import java.util.PriorityQueue;

/**
 * Defines currencies that can be used for xchange calculation.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public enum Currency {

    DE(
            new UnitCollection("€", new double[]{1, 2, 5, 10, 20, 50, 100, 200, 500}),
            new UnitCollection("c", new double[][]{{1, .01}, {2, .02}, {5, .05}, {10, .1}, {20, .2}, {50, .5}})
    ),
    US(
            new UnitCollection("$", new double[]{1, 2, 2.5, 3, 5, 10, 20, 50, 100, 500, 1000, 5000, 10000}),
            new UnitCollection("¢", new double[][]{{1, .01}, {2, .02}, {3, .03}, {5, .05}, {10, .1}, {20, .2}, {25, .25}})
    ),
    RU(
            new UnitCollection("₽", new double[]{1, 2, 5, 10, 50, 100, 200, 500, 1000, 2000, 5000}),
            new UnitCollection("коп.", new double[][]{{1, .01}, {5, .05}, {10, .1}, {50, .5}})
    );


    private PriorityQueue<UnitCollection> currencyUnits;


    Currency(UnitCollection... currencyUnits) {
        this.currencyUnits = new PriorityQueue<UnitCollection>();
        for (int i = 0; i < currencyUnits.length; i++) {
            this.currencyUnits.add(currencyUnits[i]);
        }
    }


    /**
     * Returns the length of available unit types.
     *
     * @return
     */
    public int unitTypes() {
        return this.currencyUnits.size();
    }
}
