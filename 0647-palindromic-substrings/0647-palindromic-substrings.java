class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][] = new boolean[n][n];
        int count=0;

        for(int l=0; l<n ;l++){
            for(int i=0, j=l; j<n; i++,j++){
                if(l==0){
                    dp[i][j] = true;
                    count++;
                }
                else if(l==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true){
                        dp[i][j] = true;
                        count++;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        return count;
    }
}