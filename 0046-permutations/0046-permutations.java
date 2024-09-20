class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result, new HashSet<>());
        return result;
    }

    private void backtrack(int[] nums, List<Integer> inner, List<List<Integer>> result,Set<Integer> set){
        if(inner.size()==nums.length){
            result.add(new ArrayList<>(inner));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                inner.add(nums[i]);
                set.add(nums[i]);
                backtrack(nums,inner, result, set); 
                inner.remove(inner.size()-1); 
                set.remove(nums[i]); 
            }
            
        }
    }
}