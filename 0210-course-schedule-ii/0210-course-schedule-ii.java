class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            for(int neigh: adj.get(i)){
                indegree[neigh]++;
            }
        }

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] topo = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[index++] = node;

            for(int neigh: adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }                
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        
        return topo;
    }
}