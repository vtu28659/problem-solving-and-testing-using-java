public class CircularSubarraySolution {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's Algorithm for Maximum Subarray Sum
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Modified Kadane's Algorithm for Minimum Subarray Sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, return the maximum single element
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the maximum of non-circular sum and circular sum
        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        int result = maxSubarraySumCircular(nums);
        System.out.println("Maximum Circular Subarray Sum: " + result);
    }
}