class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        
        int[] output = new int[k];
        int i=0;

        while(!pq.isEmpty() && k>0){
            int[] pair = pq.poll();
            output[i] = pair[0];
            k--;
            i++;
        }

        return output;
    }
}