package divide_conquer;

public class Power {

    /**
     * Calculate a number raised to a specific power.
     *
     * @param base
     * @param exp
     * @return
     */
    public int pow(int base, int exp) {

        // Cover special cases
        if (exp < 0) {
            throw new IllegalArgumentException("Can't raise base to power of a negative number");
        }

        if (exp == 0) {
            return 1;
        }

        // Conquer and divide solution
        return this.recurse(base, exp);
    }


    /**
     * Conquer and divide to raise base to power
     * Reccurence formular T(b,e) = T(b, e/2 * T(b, e/2)
     *
     * @param base - base to use
     * @param power - power to raise base to
     * @return base raised to given power
     */
    private int recurse(int base, int power) {

        // Base Case
        if (power == 1) {
            return base;
        }

        if (power % 2 != 0) {
            return this.recurse(base, power/2) * this.recurse(base, (power/2)+1);
        }
        return this.recurse(base, power/2) * this.recurse(base, (power/2));
    }

}
