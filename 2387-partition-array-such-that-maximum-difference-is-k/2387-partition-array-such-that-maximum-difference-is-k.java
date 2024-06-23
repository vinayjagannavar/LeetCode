class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);  
        int count = 0;      
        int l = 0;          

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] - nums[l] > k) {
                
                l = r;
                count++;
            }
        }
        
        count++;

        return count;
    }
}
