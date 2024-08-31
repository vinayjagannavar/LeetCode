class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0); 
        maxProb[start_node] = 1.0; 

        for (int i = 0; i < 9; ++i) {

            for (int j = 0; j < edges.length; ++j) {
                int u = edges[j][0];  
                int v = edges[j][1]; 
                double prob = succProb[j]; 

                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                }

                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                }
            }
        }
        return maxProb[end_node];
    }
}