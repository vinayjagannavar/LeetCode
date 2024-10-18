class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge case: if there is only one house, return its value.
        if (n == 1) {
            return nums[0];
        }
        
        // Edge case: if there are two houses, return the maximum of the two.
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        // Solve two scenarios:
        // 1. Rob houses from the first to the second-to-last (index 0 to n-2)
        // 2. Rob houses from the second to the last (index 1 to n-1)
        return Math.max(rob_linear(nums, 0, n - 2), rob_linear(nums, 1, n - 1));
    }

    // Helper function to perform DP on a linear sequence of houses
    private int rob_linear(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n];
        
        // Initialize the first two elements
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        
        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        
        // The last element of dp contains the maximum amount we can rob
        return dp[n - 1];
    }
}
