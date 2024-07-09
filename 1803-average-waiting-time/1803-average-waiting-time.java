class Solution {
    public double averageWaitingTime(int[][] customers) {
        double start;
        double end=0;
        double totalTime = 0;

        for(int[] cust: customers){
            start = cust[0];
            if(start>end){
                end = start;
            }
            end += cust[1];
            totalTime += end-start; 
        }

        return totalTime/customers.length;
    }
}