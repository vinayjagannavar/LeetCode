class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] merged = new int[n1+n2];

        int i=0;
        int j=0;
        int k=0;

        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                merged[k] = nums1[i];
                k++;
                i++; 
            }
            else{
                merged[k] = nums2[j];
                k++;
                j++; 
            }
        }

        while(i<n1){
            merged[k] = nums1[i];
            k++;
            i++; 
        }

        while(j<n2){
            merged[k] = nums2[j];
            k++;
            j++; 
        }

        if((n1+n2) % 2 == 0){
            return (double) (merged[(n1+n2)/2] + merged[((n1+n2)/2) - 1]) / 2;
        }
        else{
            return (double) merged[(n1+n2)/2];
        }
    }
}