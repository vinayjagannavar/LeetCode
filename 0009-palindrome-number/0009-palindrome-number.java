class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int n=x;
        int reverse=0;

        while(n>0){
            int d=n%10;
            reverse=reverse*10+d;
            n=n/10;
        }

        return x==reverse;
    }   
}