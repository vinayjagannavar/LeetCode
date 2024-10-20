class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //nums = [1,-2,3,-2]
        int n = nums.length;
        int maxsum = nums[0];   //1
        int minsum = 0;
        int currmax = 0;
        int currmin = 0;
        int totalsum=0;
        for(int num : nums){
            currmax = Math.max(currmax+num, num);
            maxsum = Math.max(maxsum, currmax);
            currmin = Math.min(currmin+num, num);
            minsum = Math.min(minsum, currmin);
            totalsum = totalsum + num;
        }
        if(maxsum > 0){
            return Math.max(maxsum, totalsum-minsum);
        }
        return maxsum;
        
    }
}
//tc: O(n)