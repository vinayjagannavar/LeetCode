class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int start=0;
        int end=0;
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++,j++){
                if(g==0){
                    dp[i][j] = true;
                }
                else if(g==1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }

                if(dp[i][j]){
                    start=i;
                    end=j;
                }
            }
        }

        return s.substring(start,end+1);
        
    }
}