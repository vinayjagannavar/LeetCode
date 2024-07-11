class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while( i < j){
            int minHeight = Math.min(height[i],height[j]);
            max = Math.max(max,(j-i)*minHeight);
            while(i < j && minHeight >= height[i]) {
                i++;
            }
            while(i < j && minHeight >= height[j]) {
                j--;
            }
        }
        return max;
    }
}