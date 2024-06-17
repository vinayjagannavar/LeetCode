class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);

        int left=0;
        int right=max;

        while(left<=right){
            long sum = (long)left * left + (long)right * right;
            if(sum==c){
                return true;
            }
            else if(sum>c){
                right--;
            }
            else{
                left++;
            }
        }

        return false;
    }
}