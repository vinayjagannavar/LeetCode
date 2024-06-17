class Solution {
    public boolean judgeSquareSum(int c) {
        long max = (int) Math.sqrt(c);

        long left=0;
        long right=max;

        while(left<=right){
            long sum = left * left + right * right;
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