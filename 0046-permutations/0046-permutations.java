class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permuteRecur(0, nums, output);
        return output;
    }

    private void permuteRecur(int index, int[] nums, List<List<Integer>> output){

        if(index >= nums.length){

            List<Integer> inner = new ArrayList<>();

            for(int num: nums){
                inner.add(num);
            }
            output.add(new ArrayList<>(inner));
            return;
        }

        for(int i = index; i<nums.length; i++){
            swap(nums, index, i);
            permuteRecur(index+1, nums, output);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        return;
    }
}