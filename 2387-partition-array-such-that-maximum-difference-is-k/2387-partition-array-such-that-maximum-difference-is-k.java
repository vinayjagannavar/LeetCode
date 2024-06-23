class Solution {
    public int partitionArray(int[] nums, int k) {
        int result = 0;
        int idx = 0;
        Arrays.sort(nums);
        int start = nums[0];
        while(idx < nums.length) {
            if(nums[idx] - start > k) {
                result ++;
                start = nums[idx];
            }
            idx ++;
        } 
        result ++;    
        return result;
    }
}