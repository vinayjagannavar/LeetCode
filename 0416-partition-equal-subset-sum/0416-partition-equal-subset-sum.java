class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        // If the total sum is odd, it's not possible to partition it into two equal subsets
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true; // We can always make a sum of 0
        
        // Iterate through the numbers and update the dp array
        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[targetSum];
    }
}


// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int totalSum = 0;

//         for (int num : nums) {
//             totalSum += num;
//         }

//         if (totalSum % 2 != 0) {
//             return false;
//         }

//         int target = totalSum / 2;

//         boolean dp[][] = new boolean[n + 1][target + 1];

//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = true;
//         }

//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < target + 1; j++) {
//                 if (j < nums[i-1]) {
//                     dp[i][j] = dp[i - 1][j];
//                 } else {
//                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
//                 }
//             }
//         }

//         return dp[n][target];
//     }
// }