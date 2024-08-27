class Solution {

    class Pair{
        int node;
        double prob;

        Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }

        double[] bestProbEachNode = new double[n];
        Arrays.fill(bestProbEachNode, 0.0);
        bestProbEachNode[start_node] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_node);

        while(!queue.isEmpty()){
            int curr_node = queue.poll();
            List<Pair> neighbors_list = graph.get(curr_node);

            for(Pair pair: neighbors_list){
                double new_prob = bestProbEachNode[curr_node]*pair.prob;
                if(new_prob > bestProbEachNode[pair.node]){
                    bestProbEachNode[pair.node] = new_prob;
                    queue.add(pair.node);
                }
            }

        }

        return bestProbEachNode[end_node];
    }
}