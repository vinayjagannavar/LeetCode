class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int unique = 200;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == unique){
                continue;
            }
            else{
                nums[k] = nums[i];
                k++;
                unique = nums[i];
            }
        }

        return k;
    }
}