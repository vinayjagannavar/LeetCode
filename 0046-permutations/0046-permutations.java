class Solution {
    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(new ArrayList(), ans, nums);
        return ans;
    }

    private void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if(curr.size()==nums.length) ans.add(new ArrayList<>(curr));
        else{
            for(int num : nums) {
                if(!curr.contains(num)) {
                    curr.add(num);
                    backtrack(curr, ans, nums);
                    curr.removeLast();
                }
            }
        }
    }
}