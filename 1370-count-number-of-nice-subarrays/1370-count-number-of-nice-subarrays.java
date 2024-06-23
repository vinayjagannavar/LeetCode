class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int preSum[] = new int[nums.length + 1];
        int ans = 0;
        int cnt = 0;
        preSum[0]=1;

        for(int num: nums){
            cnt += num & 1;
            if(cnt - k >=0){
                ans += preSum[cnt-k];
            }
            preSum[cnt]++;

        }
        // Map<Integer, Integer> map = new HashMap<>();
        // int preSum = 0;
        // int ans = 0;
        // map.put(0,1);

        // for(int i=0; i<nums.length; i++){
        //     preSum += nums[i] % 2 == 1? 1 : 0;
        //     if(map.containsKey(preSum - k)){
        //         ans += map.get(preSum - k);
        //     }
        //     map.put(preSum,map.getOrDefault(preSum,0)+1);
        // }

        return ans;
    }
}