class Solution {
    class Pair implements Comparable<Pair>{
        int diff;
        int profit;

        public Pair(int d, int p){
            this.diff = d;
            this.profit = p;
        }

        public int compareTo(Pair p2){
            return this.diff-p2.diff;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Pair[] jobs = new Pair[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Pair(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs);
        Arrays.sort(worker);

        int maxProfit = 0;
        int i = 0;
        int best = 0;

        for (int ability : worker) {
            while (i < n && ability >= jobs[i].diff) {
                best = Math.max(best, jobs[i].profit);
                i++;
            }
            maxProfit += best;
        }

        return maxProfit;

    }
}