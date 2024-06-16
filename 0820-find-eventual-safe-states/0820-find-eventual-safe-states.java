class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        boolean[] detectCycle = new boolean[n];
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(!visited[i]){
                hasCycle(graph, visited, recStack, detectCycle, i);
            }
        }

        for(int i=0; i<n; i++){
            if(!detectCycle[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean hasCycle(int[][] graph, boolean[] visited, boolean[] recStack, boolean[] detectCycle, int curr){
        visited[curr] = true;
        recStack[curr] = true;

        for(int i=0; i<graph[curr].length; i++){
            int neighbor = graph[curr][i];
            if(recStack[neighbor]){
                return detectCycle[curr] = true;
            }
            else if(!visited[neighbor] && hasCycle(graph, visited, recStack, detectCycle, neighbor)){
                return detectCycle[curr] = true;
            }
        }

        recStack[curr] = false;
        return detectCycle[curr] = false;
    }
}