class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> graph[] = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] pre: prerequisites){
            graph[pre[1]].add(pre[0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean recurVisited[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(visited[i]==false){
                boolean possible = dfs(graph, visited, recurVisited, i);
                if(possible){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<Integer> graph[], boolean visited[], boolean recurVisited[], int curr){
        visited[curr] = true;
        recurVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            int neighbour = graph[curr].get(i);
            if(recurVisited[neighbour]==true){
                return true;
            }
            else if(!visited[neighbour] && dfs(graph, visited, recurVisited, neighbour)){
                return true;
            }
        }

        recurVisited[curr] = false;
        return false;
    }
}