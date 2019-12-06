package supplementary.structures.currency;

import java.util.Objects;

/**
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public class Unit implements Comparable<Unit>, Cloneable {

    private String symbol;
    private int printableValue;
    private double actualValue;


    public Unit(String symbol, int printableValue, double actualValue) {
        this.symbol = symbol;
        this.printableValue = printableValue;
        this.actualValue = actualValue;
    }

    public Unit(String symbol, double value) {
        this.symbol = symbol;
        this.printableValue = (int) value;
        this.actualValue = value;
    }


    /**
     * Creates a deep copy of this object
     * @return a copy of this object
     */
    @Override
    public Unit clone() {
        return new Unit(this.getSymbol(), this.getPrintableValue(), this.getValue());
    }


    @Override
    public String toString() {
        return this.printableValue + this.symbol;
    }


    /**
     * Allows for comparison of different unit objects.
     * @param o - the other unit objects
     * @return 1 | 0 | -1
     */
    @Override
    public int compareTo(Unit o) {

        double oValue = o.getValue();
        double value = this.getValue();

        if (oValue == value) {
            return 0;
        } else if(oValue < value) {
            return 1;
        }

        return -1;
    }


    /**
     * Two objects of type unit are the same?
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return printableValue == unit.printableValue &&
                Double.compare(unit.actualValue, actualValue) == 0 &&
                Objects.equals(symbol, unit.symbol);
    }


    // -----------------------------------
    // Setter/-Getter
    // -----------------------------------

    public String getSymbol() { return this.symbol; }
    public int getPrintableValue() { return this.printableValue; }
    public double getValue() {
        return this.actualValue;
    }
}
