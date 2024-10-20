class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // Step 1: Find non-circular max subarray sum using Kadane's algorithm
        int maxKadane = kadaneMax(nums);

        // Step 2: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 3: Find the minimum subarray sum using a modified Kadane’s algorithm
        int minSum = kadaneMin(nums);

        // Step 4: Calculate circular max sum and handle the edge case
        int maxCircular = totalSum - minSum;
        if (maxCircular == 0) {
            return maxKadane; // If all elements are negative, the result should be maxKadane
        }

        // Step 5: Return the maximum of non-circular and circular sums
        return Math.max(maxKadane, maxCircular);
    }

    private int kadaneMax(int[] nums) {
        int currentMax = nums[0];
        int overallMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            overallMax = Math.max(overallMax, currentMax);
        }

        return overallMax;
    }

    private int kadaneMin(int[] nums) {
        int currentMin = nums[0];
        int overallMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            overallMin = Math.min(overallMin, currentMin);
        }

        return overallMin;
    }

}