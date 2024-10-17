class Solution {
    class Pair{
        char c;
        int count;
        public Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        // Priority queue to store characters with their counts in descending order
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.count - x.count);

        // Add pairs only if the count is greater than zero
        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            
            Pair first = pq.poll();

            if (result.length() >= 2 && result.charAt(result.length() - 1) == first.c && result.charAt(result.length() - 2) == first.c) {
                if (pq.isEmpty()) {
                    break;
                }

                Pair second = pq.poll();
                result.append(second.c);
                second.count--;
               
                if (second.count > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            } else {
                
                result.append(first.c);
                first.count--;

                if (first.count > 0) {
                    pq.offer(first);
                }
            }
        }

        return result.toString();
    }
}