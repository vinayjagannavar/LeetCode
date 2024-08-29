class Solution {
    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];

            for (int i = 0; i <= size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int findPar(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findPar(parent[node]);
        }

        public void unionByRank(int x, int y) {
            int parent_x = findPar(x);
            int parent_y = findPar(y);

            if (parent_x == parent_y) {
                return;
            }

            if (rank[parent_x] > rank[parent_y]) {
                parent[parent_y] = parent_x;
            } else if (rank[parent_x] < rank[parent_y]) {
                parent[parent_x] = parent_y;
            } else {
                parent[parent_y] = parent_x;
                rank[parent_x]++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        int max_row = 0;
        int max_col = 0;

        for (int[] cor : stones) {
            max_row = Math.max(max_row, cor[0]);
            max_col = Math.max(max_col, cor[1]);
        }

        DisjointSet ds = new DisjointSet(max_row + max_col + 2);

        Map<Integer, Integer> stoneNodes = new HashMap<>();

        for (int[] cor : stones) {
            int nodeRow = cor[0];
            int nodeCol = cor[1] + max_row + 1;

            ds.unionByRank(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
            if (ds.findPar(it.getKey()) == it.getKey()) {
                count++;
            }
        }

        return stones.length - count;
    }
}
