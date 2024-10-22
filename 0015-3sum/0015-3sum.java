class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<n-2 && nums[i]<=0; i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            twoSum(i+1, -nums[i], nums, res);
        }

        return res;
    }

    private void twoSum(int start, int target, int[] nums, List<List<Integer>> res){
        int end = nums.length-1;
        while(start < end){

            if(nums[start] + nums[end] > target){
                end--;
                continue;
            }

            if(nums[start] + nums[end] < target){
                start++;
                continue;
            }

            res.add(Arrays.asList(-target, nums[start], nums[end]));
            start++;
            end--;

            while(start<=end && nums[start] == nums[start-1]){
                start++;
            }
            
        }
    }
}