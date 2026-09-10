public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Modified Kadane's Algorithm for Minimum Subarray Sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solver = new MaximumSumCircularSubarray();
        int[] nums1 = {1, -2, 3, -2};
        int[] nums2 = {5, -3, 5};
        int[] nums3 = {-3, -2, -3};

        System.out.println("Output 1: " + solver.maxSubarraySumCircular(nums1)); // Expected: 3
        System.out.println("Output 2: " + solver.maxSubarraySumCircular(nums2)); // Expected: 10
        System.out.println("Output 3: " + solver.maxSubarraySumCircular(nums3)); // Expected: -2
    }
}