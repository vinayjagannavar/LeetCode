class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numCourses; i++){
            if (!vis[i]) {
                if (dfs(i, adj, vis, recStack, stack)) {
                    return new int[0];
                }
            }
        }

        int[] order = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            order[index++] = stack.pop();
        }
        
        return order;
        
    }

    private boolean dfs(int start, List<List<Integer>> adj, boolean[] vis, boolean[] recStack, Stack<Integer> stack){
        vis[start] = true;
        recStack[start] = true;

        for(int it: adj.get(start)){
            if(!vis[it]){
                if(dfs(it,adj,vis,recStack,stack)){
                    return true;
                }
            }
             else if (recStack[it]) {
                return true; 
            }
        }

        recStack[start] = false;
        stack.push(start);

        return false;
    }
}