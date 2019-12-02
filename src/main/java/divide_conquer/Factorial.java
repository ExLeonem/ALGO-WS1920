package divide_conquer;

/**
 * Calculation of factorial values.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-2
 */
public class Factorial {


    /**
     * Special case conquer and divide. Problem reduction by one at each step.
     *
     * @param factorialOf
     * @return
     */
    public static int classic(int factorialOf) {

        // Cover negative case
        if (factorialOf < 0) {
            throw new IllegalArgumentException("Can't calculate factorial of negative value");
        }

        // Base Case
        if (factorialOf == 0) {
            return 1;
        }

        // Conquer & Merge
        return factorialOf * Factorial.classic(factorialOf-1);
    }


    /**
     * Alternative divide and conquer proceedure, using an quick-sort like division
     *
     * @param factorialOf
     * @return
     */
    public static int alternative(int factorialOf) {

        // Cover negative case
        if (factorialOf < 0) {
            throw new IllegalArgumentException("Can't calculate factorial of negative value");
        }

        // Base
        if (factorialOf == 0) {
            return 1;
        }

        return Factorial.recurseAlternative(0, factorialOf);
    }


    private static int recurseAlternative(int left, int right) {

        // Base
        if (left >= right) {
            return left > 0 ? left : 1;
        }

        // Divide
        int center = (left + right) / 2;
        int leftSolution = Factorial.recurseAlternative(left, center);
        int rightSolution = Factorial.recurseAlternative(center+1, right);

        // Conquer
        return leftSolution * rightSolution;
    }

}
