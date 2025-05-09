import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
       int n=nums.length;
       if(n==0) return 0;
       Arrays.sort(nums);
       int ans=1;
       int maxi=1;
       for(int i=1;i<n;i++){
        if(nums[i]==nums[i-1]){
            continue;
        }
        if(nums[i]==nums[i-1]+1){
            ans++;
        }
        else{
            maxi=Math.max(maxi,ans);
            ans=1;
        }
       }
       return Math.max(ans,maxi);
    }
}