class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (lis.isEmpty() || lis.get(lis.size() - 1) < nums[i]) {
                lis.add(nums[i]);
            } else {
                int position = binarySearch(lis, nums[i]);
                lis.set(position, nums[i]);
            }
        }

        return lis.size();
    }

    private int binarySearch(List<Integer> lis, int num) {
        int left = 0;
        int right = lis.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) == num) {
                return mid;
            } else if (lis.get(mid) > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int dp[] = new int[nums.length];
//         Arrays.fill(dp,1);

//         for(int i=1; i<nums.length; i++){
//             for(int j=0; j<i ; j++){
//                 if(nums[i] > nums[j]){
//                     dp[i] = Math.max(dp[i], dp[j]+1);
//                 }
//             }
//         }

//         int max = 0;
//         for(int i : dp){
//             max = Math.max(max,i);
//         }

//         return max;
//     }
// }