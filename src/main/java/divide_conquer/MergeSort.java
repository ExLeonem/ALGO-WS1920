package divide_conquer;

/**
 * @author maksim sandybekov
 * @date 2019-11-06
 */
public class MergeSort {

    public static int[] sort(int[] elements) {

        int arrLength = elements.length;
        if (arrLength == 0 || arrLength == 1) {
            return elements;
        }

        return MergeSort.recurse(elements, 0, elements.length-1);
    }

    public static int[] recurse(int[] elements, int left, int right) {

        // Base case, single element
        if (left >= right) {
            return new int[]{elements[right]};
        }

        // Divide into two parts
        int center = (left + right) / 2;
        int[] leftPart = MergeSort.recurse(elements, left, center);
        int[] rightPart = MergeSort. recurse(elements, center+1, right);

        // Merge and return result
        return MergeSort.merge(leftPart, rightPart);
    }


    public static int[] merge(int[] left, int[] right) {

        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        boolean leftInside, rightInside;
        for(int i = 0; i < merged.length; i++) {
            leftInside = leftIndex < left.length;
            rightInside = rightIndex < right.length;

            if (leftInside) {

                if(rightInside && left[leftIndex] > right[rightIndex]) {
                    merged[i] = right[rightIndex];
                    rightIndex++;
                } else if (rightInside && left[leftIndex] < right[rightIndex]) {
                    merged[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    merged[i] = left[leftIndex];
                    leftIndex++;
                }

            } else {
                merged[i] = right[rightIndex];
                rightIndex++;
            }
        }

        return merged;
    }



}
