class Solution {
    class Pair{
        int diff;
        int profit;

        public Pair(int d, int p){
            this.diff = d;
            this.profit = p;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n= difficulty.length;
        Pair[] job = new Pair[n];

        for(int i=0; i<profit.length; i++){
            job[i] = new Pair(difficulty[i],profit[i]);
        }

        Arrays.sort(job , (a,b) -> a.diff - b.diff);
        Arrays.sort(worker);

        int[] maxProfitAtDiff = new int[n];
        maxProfitAtDiff[0] = job[0].profit;

        for(int i=1; i<n; i++){
            maxProfitAtDiff[i] = Math.max(maxProfitAtDiff[i-1], job[i].profit);
        }

        int maxProfit = 0;

        for(int w: worker){
            int idx = binarySearch(job, w);
            if(idx != -1){
                maxProfit += maxProfitAtDiff[idx];
            }
        }

        return maxProfit;
    }

    private int binarySearch(Pair[] job, int ability){
        int left = 0;
        int right = job.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(job[mid].diff <= ability){
                left = mid+1;
            }
            else{
                right = mid - 1;
            }
        }

        return right;

    }
}