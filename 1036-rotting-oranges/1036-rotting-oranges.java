class Solution {
    public int orangesRotting(int[][] grid) {
        int moves[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int row = grid.length;
        int col = grid[0].length;
        int freshCount = 0;
        int mins = 0;

        var queue = new ArrayDeque<int[]>();
        //boolean[][] visited = new boolean[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    freshCount++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                    grid[i][j]=0;
                    //visited[i][j]=true;
                }
            }
        }

        if(queue.isEmpty() && freshCount>0){
            return -1;
        }
        if(queue.isEmpty()){
            return 0;
        }

        for(mins = 0; !queue.isEmpty(); mins++){
            for(int i=queue.size(); i>0; i--){
                var val = queue.poll();

                for(var move : moves){
                    var x = move[0] + val[0];
                    var y = move[1] + val[1];

                    if(x>=0 && x<row && y>=0 && y<col && grid[x][y] == 1){
                        freshCount--;
                        grid[x][y]=0;
                        queue.offer(new int[]{x,y});
                    }
                }
            }
        }

        return freshCount>0? -1: mins-1;

    }
}