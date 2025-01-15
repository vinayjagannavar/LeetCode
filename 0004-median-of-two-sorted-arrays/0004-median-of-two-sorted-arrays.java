class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while(low<=high){
            int midX = (low + high) / 2;
            int midY = (n1+n2+1) / 2 - midX;

            int maxLeftX = (midX == 0)? Integer.MIN_VALUE : nums1[midX-1];
            int minRightX = (midX == n1)? Integer.MAX_VALUE : nums1[midX];

            int maxLeftY = (midY == 0)? Integer.MIN_VALUE : nums2[midY-1];
            int minRightY = (midY == n2)? Integer.MAX_VALUE : nums2[midY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((n1+n2) % 2 == 0){
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
                else{
                    return (double) Math.max(maxLeftX,maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                high = midX - 1;
            }
            else{
                low = midX + 1;
            }
        }

        return -1;
    }
}