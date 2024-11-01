class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubseq(0,new ArrayList<>(), nums);
        return output;
    }

    private void findSubseq(int i, List<Integer> subset, int[] nums){
        if(i>=nums.length){
            output.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        findSubseq(i+1,subset, nums);
        subset.remove(subset.size()-1);
        findSubseq(i+1,subset, nums);

        return;
    }
}