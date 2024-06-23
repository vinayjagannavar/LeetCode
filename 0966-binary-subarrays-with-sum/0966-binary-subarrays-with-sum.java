class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int[] presum = new int[nums.length+1];
        int ans = 0;
        int cnt = 0;

        presum[0] = 1;

        for(int num: nums){
            cnt += num;
            if(cnt - goal >=0 ){
                ans += presum[cnt - goal];
            }
            presum[cnt]++;
        }

        return ans;
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
}
