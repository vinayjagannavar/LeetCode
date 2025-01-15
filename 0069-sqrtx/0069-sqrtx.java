class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;
        while(low < high) {
            int mid = (low+high)/2 + 1;
            if(mid*mid == x) return mid;
            if(mid > x/mid) {
                high = mid -1;
            } else {
                low = mid;
            }
        }

        return low;
    }
}