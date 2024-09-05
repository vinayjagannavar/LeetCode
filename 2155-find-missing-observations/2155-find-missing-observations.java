class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumM = 0;
        int[] rollsN = new int[n];

        for(int roll: rolls){
            sumM += roll;
        }

        int nm = rolls.length+n;

        int sumN = (mean * nm) - sumM;

        if(sumN > n * 6 || sumN < n * 1){
            return new int[]{};
        }
        else{
            int avg = sumN / n;
            int k = sumN - avg * n;
            for(int i=0; i<n; i++){
                if(i<n-k){
                    rollsN[i]=avg;
                }
                else{
                    rollsN[i]=avg+1;
                }
                
            }
        }

        return rollsN;
    }
}