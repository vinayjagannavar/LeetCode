class Solution {
    public int minSubarray(int[] nums, int p) {
        // Step 1: Calculate the total sum of the array
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p; // Total sum modulo p
        }

        // Step 2: Calculate the remainder r that needs to be removed
        int r = sum % p;

        // If the sum is already divisible by p, no need to remove any subarray
        if (r == 0) {
            return 0;
        }

        // Step 3: Initialize a hashmap to track prefix sums modulo p
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);  // To handle cases where the subarray starts from index 0

        int prefixSum = 0;
        int minLength = nums.length;

        // Step 4: Iterate through the array and calculate prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixSum = (prefixSum + nums[i]) % p; // Update prefix sum modulo p
            
            // Calculate the target prefix sum that we need to match
            int target = (prefixSum - r + p) % p;

            // Step 5: If the target is found in the map, calculate subarray length
            if (prefixMap.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixMap.get(target));
            }

            // Step 6: Store the current prefix sum in the map
            prefixMap.put(prefixSum, i);
        }

        // Step 7: If no valid subarray is found, return -1, else return the minimum length found
        return minLength == nums.length ? -1 : minLength;
    }
}