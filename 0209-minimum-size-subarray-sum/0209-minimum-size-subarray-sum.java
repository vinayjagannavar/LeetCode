class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int k = n+1;
        int left = 0;
        int sum=0;

        for( int right=0; right<n; right++){
            sum += nums[right];
            while(sum >= target){
                k = Math.min(k, right-left+1);
                sum -= nums[left];
                left++;
            }
        }

        return k==n + 1 ? 0 : k;
    }
}