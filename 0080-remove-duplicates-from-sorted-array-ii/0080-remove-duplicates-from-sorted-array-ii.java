class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int size = 0;

        for(int i = 1; i<nums.length; i++){
            if(nums[size]!=nums[i]){
                size++;
                nums[size] = nums[i];
                k=1;
            }
            else if(nums[size]==nums[i] && k<2){
                size++;
                nums[size] = nums[i];
                k++;
            }
        }

        return ++size;
    }
}