// class Solution {
//     class DisjointSet {
//         int[] parent;
//         int[] rank;

//         public DisjointSet(int size) {
//             parent = new int[size + 1];
//             rank = new int[size + 1];

//             for (int i = 0; i <= size; i++) {
//                 parent[i] = i;
//                 rank[i] = 1;
//             }
//         }

//         public int findPar(int node) {
//             if (parent[node] == node) {
//                 return node;
//             }
//             return parent[node] = findPar(parent[node]);
//         }

//         public void unionByRank(int x, int y) {
//             int parent_x = findPar(x);
//             int parent_y = findPar(y);

//             if (parent_x == parent_y) {
//                 return;
//             }

//             if (rank[parent_x] > rank[parent_y]) {
//                 parent[parent_y] = parent_x;
//             } else if (rank[parent_x] < rank[parent_y]) {
//                 parent[parent_x] = parent_y;
//             } else {
//                 parent[parent_y] = parent_x;
//                 rank[parent_x]++;
//             }
//         }
//     }

//     public int removeStones(int[][] stones) {
//         int max_row = 0;
//         int max_col = 0;

//         for (int[] cor : stones) {
//             max_row = Math.max(max_row, cor[0]);
//             max_col = Math.max(max_col, cor[1]);
//         }

//         DisjointSet ds = new DisjointSet(max_row + max_col + 2);

//         Map<Integer, Integer> stoneNodes = new HashMap<>();

//         for (int[] cor : stones) {
//             int nodeRow = cor[0];
//             int nodeCol = cor[1] + max_row + 1;

//             ds.unionByRank(nodeRow, nodeCol);
//             stoneNodes.put(nodeRow, 1);
//             stoneNodes.put(nodeCol, 1);
//         }

//         int count = 0;

//         for (Map.Entry<Integer, Integer> it : stoneNodes.entrySet()) {
//             if (ds.findPar(it.getKey()) == it.getKey()) {
//                 count++;
//             }
//         }

//         return stones.length - count;
//     }
// }

class Solution {
    class DisjointSet {
        int[] parent;
        int[] size;

        public DisjointSet(int maxSize) {
            parent = new int[maxSize + 1];
            size = new int[maxSize + 1];

            for (int i = 0; i <= maxSize; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);  
            }
            return parent[node];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
            }
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;

            ds.union(nodeRow, nodeCol);
        }

        int uniqueComponents = 0;
        boolean[] visited = new boolean[maxRow + maxCol + 2];

        for (int[] stone : stones) {
            int node = ds.find(stone[0]);
            if (!visited[node]) {
                visited[node] = true;
                uniqueComponents++;
            }
        }

        return stones.length - uniqueComponents;
    }
}

