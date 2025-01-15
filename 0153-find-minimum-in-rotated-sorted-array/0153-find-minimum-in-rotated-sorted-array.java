class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid element is greater than the right element, the pivot is on the right side
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } 
            // Otherwise, the pivot is on the left side (including mid)
            else {
                r = mid;
            }
        }

        // At the end of the loop, l == r and points to the smallest element
        return nums[l];
    }
}
