import java.util.*;

class Solution {
    class Edge {
        int src;
        int dest;
        int dist;

        public Edge(int src, int dest, int dist) {
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }
    }

    class Pair implements Comparable<Pair> {
        int node;
        int dist;
        int stops;

        public Pair(int node, int dist, int stops) {
            this.node = node;
            this.dist = dist;
            this.stops = stops;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            graph[flight[0]].add(new Edge(flight[0], flight[1], flight[2]));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(src, 0, 0));

        int[][] minDist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        minDist[src][0] = 0;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (curr.node == dst) {
                return curr.dist;
            }

            if (curr.stops > k) {
                continue;
            }

            for (Edge e : graph[curr.node]) {
                int newDist = curr.dist + e.dist;
                if (newDist < minDist[e.dest][curr.stops + 1]) {
                    minDist[e.dest][curr.stops + 1] = newDist;
                    queue.add(new Pair(e.dest, newDist, curr.stops + 1));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            answer = Math.min(answer, minDist[dst][i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
