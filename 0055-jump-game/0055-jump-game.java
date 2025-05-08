class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int i=0;

        while(i<=maxReach){
            maxReach =  Math.max(maxReach, i+nums[i]);
            if(maxReach>= nums.length-1){
                return true;
            }
            i++;
        }

        return false;   
    }
}