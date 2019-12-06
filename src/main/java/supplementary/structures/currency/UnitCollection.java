package supplementary.structures.currency;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;


/**
 * Acts as an container for mass init.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public class UnitCollection {

    private Unit[] units;


    // Actual unit value equals printable value
    public UnitCollection(String symbol, double... values) {
        this.units = new Unit[values.length];
        for (int i = 0; i < this.units.length; i++) {
            this.units[i] = new Unit(symbol, (int) values[i], values[i]);
        }
    }


    // Actual unit value is different from printable value
    public UnitCollection(String symbol, double[][] values) {
        this.units = new Unit[values.length];
        for (int i = 0; i < this.units.length; i++) {
            this.units[i] = new Unit(symbol, (int) values[i][0], values[i][1]);
        }
    }


    // -------------------------------
    // Setter/-Getter
    // -------------------------------

    public Unit[] getUnits() {
        return this.units;
    }
}
