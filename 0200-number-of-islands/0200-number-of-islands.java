class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int land = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j]=='1'){
                    land++;
                    bfs(grid,i,j,row,col);
                }
            }
        }

        return land;
    }

    private void bfs(char[][] grid, int x, int y, int r, int c){
        if(x<0 || x>=r || y<0 || y>=c || grid[x][y]!='1')
            return;

        grid[x][y] = '0';
        bfs(grid,x-1,y,r,c);
        bfs(grid,x,y+1,r,c);
        bfs(grid,x+1,y,r,c);
        bfs(grid,x,y-1,r,c);
    }
}
        
