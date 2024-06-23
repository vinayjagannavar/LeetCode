class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int l=0,r=0;

        while(r<nums.length){
            if(l == r){
                count++;
            }
            
            if(nums[r] - nums[l] > k){
                l = r;
            }
            else{
                r++;
            }
        }

        return count;
    }
}