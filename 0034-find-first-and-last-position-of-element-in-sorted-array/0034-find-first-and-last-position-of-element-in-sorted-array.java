class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findBound(nums, target, true);   // Find first occurrence
        int end = findBound(nums, target, false);    // Find last occurrence
        return new int[]{start, end};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int l = 0;
        int r = nums.length - 1;
        int bound = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    r = mid - 1;  // Search towards the left side
                } else {
                    l = mid + 1;  // Search towards the right side
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return bound;
    }
}
