package supplementary.structures;

public enum DistanceMetric{
    EUCLIDEAN(0), MANHATTEN(1);

    // Indicates which method to use
    private int calculationScheme;

    private DistanceMetric(int calculationScheme) {
        this.calculationScheme = calculationScheme;
    }


    /**
     * Takes two arrays and calculates the distance
     *
     * @param firstArray
     * @param secondArray
     * @return
     */
    public double compute(double[] firstArray, double[] secondArray) {

        switch(this.calculationScheme) {

            case 0: {
                // euclidean distance

                break;
            }
            case 1: {
                // manhatten distance

                break;
            }
        }
        return 0.0;
    }

}
