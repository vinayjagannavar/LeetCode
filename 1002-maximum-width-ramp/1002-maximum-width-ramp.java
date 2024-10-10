class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> indexes = new Stack<>();
        indexes.push(0);

        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[indexes.peek()]){
                indexes.push(i);
            }
        }

        int maxWidth = 0;
        for(int i=nums.length-1; i>=0; i--){
            while(!indexes.isEmpty() && nums[i]>=nums[indexes.peek()]){
                maxWidth = Math.max(maxWidth,i-indexes.peek());
                indexes.pop();
            }
        }

        return maxWidth;
    }
}