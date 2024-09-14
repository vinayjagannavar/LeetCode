class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
