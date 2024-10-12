class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> group = new PriorityQueue<>();

        for(int i=0; i<intervals.length; i++){
            int[] interval = intervals[i];

            if(!group.isEmpty() && interval[0]>group.peek()){
                group.poll();
            }

            group.offer(interval[1]);
        }

        return group.size();
    }
}