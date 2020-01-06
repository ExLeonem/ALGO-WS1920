package divide_conquer;

/**
 * (1 + x + 3x2 - 4x3)(1 + 2x - 5x2 - 3x3) = (1 + 3x - 6x3 - 26x4 + 11x5 + 12x6).
 *
 * @author Maksim Sandybekov
 * @date 2019-12-13
 */
public class PolyMult {


    /**
     *
     *
     * @param first
     * @param second
     * @return
     */
    public int[] mult(int[] first, int[] second) {

        return first;
    }


    private int[] recurseMult(int[] first, int[] second, int left, int right) {

        if (left >= right) {
            return this.recurseInnerMult(first[left], left, second, 0, second.length);
        }


        int center = (left + right) / 2;
        int[] leftSub = this.recurseMult(first, second, left, center);
        int[] rightSub = this.recurseMult(first, second, center+1, right);


        return first;
    }


    private int[] recurseInnerMult(int base, int grad, int[] second, int left, int right) {




        return second;
    }


    // Calculate a the new polynom
    public int[] add(int[] firstPoly, int[] secondPoly) {

        // Catch edge cases
        if (firstPoly.length < 1) {
            return secondPoly;
        } else if (secondPoly.length < 1) {
            return firstPoly;
        }

        int smallerLength = 0;
        int biggerLength = 0;
        if (firstPoly.length >= secondPoly.length) {
            biggerLength = firstPoly.length;
            smallerLength = secondPoly.length;
        } else {
            biggerLength = secondPoly.length;
            smallerLength = firstPoly.length;
        }

        int[] newPoly = new int[biggerLength];
        this.recurse(newPoly, firstPoly, secondPoly, 0, smallerLength-1);

        return newPoly;
    }


    /**
     * Adds two polynomials to one using an divide and conquer approach.
     *
     * @param newPoly - a new polynomial that aggregates values of the other two
     * @param first - first polynomial to add
     * @param second - second polynomial to add
     * @param left - left border
     * @param right - right border
     */
    private void recurse(int[] newPoly, int[] first, int[] second, int left, int right) {

        // Base & Conquer (Merge)
        if (left >= right) {

            if (first.length >= left) {
                newPoly[left] += first[left];
            }

            if (second.length >= left) {
                newPoly[left] += second[left];
            }
            return;
        }

        // Divide
        int center = (left + right) / 2;
        this.recurse(newPoly, first, second, left, center);
        this.recurse(newPoly, first, second, center+1, right);
    }


    /**
     * Print the polynomial to the console.
     *
     * @param ply - polynomial represented as an array of integer values
     */
    private void printPolynomial(int[] ply) {

        int exp = 0;
        int maxPoly = ply.length;
        String[] plyParts = new String[ply.length];

        for (int i = 0; i < ply.length; i++, maxPoly--) {
            plyParts[i] = ply[i] + "x^" + maxPoly;
        }
    }
}
