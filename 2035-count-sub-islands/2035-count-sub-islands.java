class Solution {
    boolean isSubIsland;
    
    int m;
    int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length;
        n = grid2[0].length;
        int subIslandCount = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                isSubIsland = true;
                if(grid2[i][j]==1){
                    dfs(grid1, grid2, i, j);

                    if(isSubIsland==true){
                        subIslandCount++;
                    }
                }

            }
        }

        return subIslandCount;
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if((i<0) || (i==m) || (j<0) || (j>=n) || (grid2[i][j]==0)){
            return;
        }

        if(grid1[i][j] != grid2[i][j]){
            isSubIsland = false;
        }

        grid2[i][j] = 0;

        dfs(grid1,grid2,i+1,j);
        dfs(grid1,grid2,i-1,j);
        dfs(grid1,grid2,i,j+1);
        dfs(grid1,grid2,i,j-1);
    }
}