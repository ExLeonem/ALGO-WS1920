package divide_conquer.search_sort;

/**
 * Switch for sorting algorithms to regulate sorting order.
 *
 * @author Maksim Sandybekov
 * @date 2019-12-4
 */
public enum Order {
    ASC {

        public boolean inOrder(int left, int right) {
            return left > right? false : true;
        }

        public boolean inOrder(int[] left, int[] right, int checkIndx) {
            return left[checkIndx] > right[checkIndx]? false : true;
        }

    },
    DESC {

        public boolean inOrder(int left, int right) {
            return left > right? true : false;
        }

        public boolean inOrder(int[] left, int[] right, int checkIndx) {
            return left[checkIndx] > right[checkIndx]? true : false;
        }

    };

    public abstract boolean inOrder(int left, int right);
    public abstract boolean inOrder(int[] left, int right[], int checkIndx);
}
