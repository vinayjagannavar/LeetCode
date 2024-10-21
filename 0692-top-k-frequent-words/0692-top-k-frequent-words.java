class Solution {
    class Pair{
        String s;
        int count;
        public Pair(String s, int count){
            this.s = s;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.count != b.count){
                return b.count - a.count;
            }
            else{
                return a.s.compareTo(b.s);
            }
        });
        List<String> list = new ArrayList<>();

        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        while(!pq.isEmpty() && k>0){
            Pair pair = pq.poll();
            list.add(pair.s);
            k--;
        }

        return list;
        
    }
}