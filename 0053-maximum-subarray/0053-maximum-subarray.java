class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = nums[0];          
        int overall_sum = nums[0];      

        for(int i=1; i<nums.length; i++){
            if(curr_sum >= 0){
                curr_sum += nums[i];
            }
            else{
                curr_sum = nums[i];
            }

            if(curr_sum > overall_sum){
                overall_sum = curr_sum;
            }
        }

        return overall_sum;
    }
}