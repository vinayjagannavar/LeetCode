class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
//Approach: two pointer and Sliding Window:
            // Its slightly better than prefix sum for this scenario as we are given binary array
        return atMost(nums,goal) - atMost(nums,goal-1);
    }

    private int atMost(int[] nums, int goal){
        if(goal<0){
            return 0;
        }

        int l=0;
        int r=0;
        int count=0;
        int ans=0;

        while(r<nums.length){
            count += nums[r];
            while(count > goal){
                count -= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }

        return ans;
    }

// Approach: Prefix Sum using Map and Array:

        // int[] presum = new int[nums.length+1];
        // int ans = 0;
        // int cnt = 0;

        // presum[0] = 1;

        // for(int num: nums){
        //     cnt += num;
        //     if(cnt - goal >=0 ){
        //         ans += presum[cnt - goal];
        //     }
        //     presum[cnt]++;
        // }

        // return ans;
        // int count = 0;
        // int sum = 0;
        // Map<Integer, Integer> seen = new HashMap<>();

        // for (int num : nums) {
        //     seen.put(sum, seen.getOrDefault(sum, 0) + 1);
        //     sum += num;
        //     count += seen.getOrDefault(sum - goal, 0);
        // }

        // return count;

}
