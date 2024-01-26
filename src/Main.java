

public class Main {
    public static void main(String[]args) {
//        int[] arr = {-17, 5, 3, -10, 6, 1, 4, -3, 8, 1, -13, 4};
        int[] arr = {-17, -4, 3};
        int result = getLargestSubset(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    // Get largest subset
    public static int getLargestSubset(int[] array, int i, int j) {
        if (i == j) {
            return array[i];
        }
        else {
            int mid = i + (j - i) / 2;
            int largestSubsetLeft = getLargestSubset(array, i, mid);
            int largestSubsetRight = getLargestSubset(array, mid + 1, j);
            int maximumCrossing = getMaximumCrossing(array, i, mid, j);

            if (maximumCrossing > largestSubsetRight && maximumCrossing > largestSubsetLeft) {
                return maximumCrossing;
            }
            else if (largestSubsetRight > largestSubsetLeft) {
                return largestSubsetRight;
            }
            else {
                return largestSubsetLeft;
            }
        }
    }

    public static int getMaximumCrossing(int[] array, int i, int mid, int j) {
        int largestLeftSum = 0;
        int accumlativeLeftSum = 0;
        for (int k = mid; k >= i && k >= 0; k--) {
            accumlativeLeftSum += array[k];
            if (accumlativeLeftSum >= largestLeftSum) {
                largestLeftSum = accumlativeLeftSum;
            }
        }

        int largestRightSum = 0;
        int accumlativeRightSum = 0;
        for (int k = mid + 1; k <= j && k < array.length; k++) {
            accumlativeRightSum += array[k];
            if (accumlativeRightSum >= largestRightSum) {
                largestRightSum = accumlativeRightSum;
            }
        }

        int result = 0;
        int crossSum = largestRightSum + largestLeftSum;
        if (crossSum > largestRightSum && crossSum > largestLeftSum) {
            return crossSum;
        }
        else if (largestRightSum > largestLeftSum) {
            return largestRightSum;
        }
        else {
            return largestLeftSum;
        }
    }
}
