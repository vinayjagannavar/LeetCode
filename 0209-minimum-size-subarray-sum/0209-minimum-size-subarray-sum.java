class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int minSub = Integer.MAX_VALUE;
        int sum=0;

        while(j<nums.length){
            sum += nums[j];
            while(sum>=target){
                minSub = Math.min(minSub,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }

        return minSub==Integer.MAX_VALUE? 0 : minSub;
    }
}