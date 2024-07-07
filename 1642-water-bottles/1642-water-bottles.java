class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int q = 0;
        int drank = numBottles;
        while(numBottles/numExchange != 0){
            q = numBottles/numExchange;
            drank += q;
            numBottles = numBottles%numExchange + q;
        }

        return drank;
    }
}