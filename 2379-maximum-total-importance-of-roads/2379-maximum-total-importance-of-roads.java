class Solution {
    class NodeCount {
        int node;
        int count;
        public NodeCount(int n, int c) {
            this.node = n;
            this.count = c;
        }
    }

    public long maximumImportance(int n, int[][] roads) {
        int[] count = new int[n];
        for (int i = 0; i < roads.length; i++) {
            count[roads[i][0]]++;
            count[roads[i][1]]++;
        }

        NodeCount[] nodes = new NodeCount[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new NodeCount(i, count[i]);
        }

        Arrays.sort(nodes, (a, b) -> b.count - a.count);

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[nodes[i].node] = n - i;
        }

        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += values[road[0]] + values[road[1]];
        }

        return totalImportance;
    }
}