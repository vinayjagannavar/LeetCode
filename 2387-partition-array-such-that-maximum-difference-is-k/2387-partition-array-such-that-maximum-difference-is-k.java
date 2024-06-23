class Solution {
    public int partitionArray(int[] nums, int k) {
        int count = 0;

        Arrays.sort(nums);
        int l = nums[0];
        int r = 0;

        while(r < nums.length) {
            if(nums[r] - l > k) {
                count++;
                l = nums[r];
            }
            r++;
        } 
        count++;    
        return count;
    }
}