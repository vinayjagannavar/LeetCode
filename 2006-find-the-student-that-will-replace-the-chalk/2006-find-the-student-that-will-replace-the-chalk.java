class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;

        for(int i=0; i<chalk.length; i++){
            sum += chalk[i];
            if(sum>k){
                return i;
            }
        }

        int q = k % sum;

        if(q==0){
            return 0;
        }

        for(int i=0; i<chalk.length; i++){
            q -= chalk[i];
            if(q<0){
                return i;
            }
        }

        return 0;
    }
}