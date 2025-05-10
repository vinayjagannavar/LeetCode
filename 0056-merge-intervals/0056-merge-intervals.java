class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] currentInterval = intervals[0];

        for(int i=1; i< intervals.length; i++){
            if(currentInterval[1] >= intervals[i][0]){
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }
            else{
                ans.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        ans.add(currentInterval);

        return ans.toArray(new int[ans.size()][]);
    }
}