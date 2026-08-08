import java.util.Random;

public class Kthsmallest {

    // Global Random object to minimize seed instantiation overhead
    private static final Random random = new Random();

    /**
     * Partitions the array segment around a randomly selected pivot.
     * Elements smaller than the pivot go left; larger elements go right.
     */
    private static int partition(int[] arr, int left, int right) {
        // Pick a random pivot index and swap it with the rightmost element
        int pivotIdx = left + random.nextInt(right - left + 1);
        swap(arr, pivotIdx, right);

        int pivotValue = arr[right];
        int storeIdx = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIdx, i);
                storeIdx++;
            }
        }

        // Place pivot into its correct, final sorted position
        swap(arr, storeIdx, right);
        return storeIdx;
    }

    /**
     * Swaps two elements in an array in-place.
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Finds and returns the kth smallest element (1-indexed) in the array.
     */
    public static int findKthSmallest(int[] arr, int k) {
        // Boundary validation
        if (arr == null || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("k is out of bounds for the given array.");
        }

        int left = 0;
        int right = arr.length - 1;
        int targetIdx = k - 1; // Convert 1-indexed k to 0-indexed index

        while (left <= right) {
            // Optimization: If single element remaining, it must be the target
            if (left == right) {
                return arr[left];
            }

            int pivotIdx = partition(arr, left, right);

            // Narrow down search boundaries dynamically
            if (pivotIdx == targetIdx) {
                return arr[pivotIdx];
            } else if (pivotIdx > targetIdx) {
                right = pivotIdx - 1; // Narrow search to left partition
            } else {
                left = pivotIdx + 1;  // Narrow search to right partition
            }
        }

        return -1;
    }

    // --- Driver Program for Verification ---
    public static void main(String[] args) {
        int[] exampleArr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        // Sorted view: [3, 4, 7, 10, 15, 20]
        // 3rd smallest element is 7
        try {
            int result = findKthSmallest(exampleArr, k);
            System.out.println("The " + k + "rd smallest element is: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
