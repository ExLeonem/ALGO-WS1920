package supplementary.structures.currency;

/**
 * @author Maksim Sandybekov
 * @date 2019-12-5
 */
public class Unit implements Comparable<Unit> {

    private String symbol;
    private int printableValue;
    private double actualValue;


    public Unit(String symbol, int printableValue, double actualValue) {
        this.symbol = symbol;
        this.printableValue = printableValue;
        this.actualValue = actualValue;
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


    // -----------------------------------
    // Setter/-Getter
    // -----------------------------------

    public double getValue() {
        return this.actualValue;
    }
}
