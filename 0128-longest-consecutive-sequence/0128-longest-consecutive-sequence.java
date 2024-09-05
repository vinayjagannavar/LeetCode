class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        if(nums.length == 0){
            return 0;
        }

        for(int num: nums){
            set.add(num);
        }

        int longest = 1;

        for(int it: set){
            if(!set.contains(it-1)){
                int cnt = 1;
                int x = it;

                while(set.contains(x+1)){
                    x = x+1;
                    cnt++;
                }

                longest = Math.max(longest, cnt);
            }
        }

        return longest;

    }
}