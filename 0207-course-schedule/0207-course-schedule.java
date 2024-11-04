class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            adj.get(prereq[0]).add(prereq[1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(dfs(i, adj, recStack, vis)) {
                return false;
            }
        }

        return true;
        
    }

    private boolean dfs(int start, List<List<Integer>> adj, boolean[] recStack, boolean[] vis){
        vis[start] = true;
        recStack[start] = true;

        for(int it: adj.get(start)){
            if(!vis[it]){
                if(dfs(it,adj,recStack,vis)){
                    return true;
                }
            }
             else if (recStack[it]) {
                return true; 
            }
        }

        recStack[start] = false;

        return false;
    }
}