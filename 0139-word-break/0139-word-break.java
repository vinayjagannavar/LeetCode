class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        Set<String> hashSet = new HashSet<>(wordDict);

        for(int len = 1; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                String str = s.substring(i, j + 1);

                if(hashSet.contains(str)) {
                    dp[i][j] = i;
                    continue;
                }

                for(int k = i + 1; k <= j; k++) {
                    if(dp[i][k - 1] != -1 && dp[k][j] != -1) {
                        dp[i][j] = k;
                        break;
                    }
                }
            }
        }

        return dp[0][n - 1] != -1;
    }
}
