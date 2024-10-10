class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,0,s,dp,new HashSet<>(wordDict));
    }

    private boolean solve(int start, int end,String s, int dp[][], Set<String> wd){
        
        if(dp[start][end] != -1){
            return dp[start][end]==1? true:false;
        }

        if(end == s.length()-1){
            if(wd.contains(s.substring(start, end+1))){
                return true;
            }
            else{
                return false;
            }
        }

        if(wd.contains(s.substring(start, end+1))){
            if(solve(end+1,end+1,s,dp,wd)){
                return true;
            }
        }

        boolean ans = solve(start,end+1,s,dp,wd);
        dp[start][end] = ans? 1 : 0;
        return ans;
    }
}

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         int[][] dp = new int[n][n];

//         for(int i = 0; i < dp.length; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         Set<String> hashSet = new HashSet<>(wordDict);

//         for(int len = 1; len <= n; len++) {
//             for(int i = 0; i < n - len + 1; i++) {
//                 int j = i + len - 1;
//                 String str = s.substring(i, j + 1);

//                 if(hashSet.contains(str)) {
//                     dp[i][j] = i;
//                     continue;
//                 }

//                 for(int k = i + 1; k <= j; k++) {
//                     if(dp[i][k - 1] != -1 && dp[k][j] != -1) {
//                         dp[i][j] = k;
//                         break;
//                     }
//                 }
//             }
//         }

//         return dp[0][n - 1] != -1;
//     }
// }
