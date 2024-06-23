class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        map.put(0,1);

        for(int i=0; i<nums.length; i++){
            preSum += nums[i] % 2 == 1? 1 : 0;
            if(map.containsKey(preSum - k)){
                ans += map.get(preSum - k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }

        return ans;
    }
}