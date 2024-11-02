class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        String[][] board = new String[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(board[i],".");
        }

        int[] upperDaig = new int[2*n-1];
        int[] lowerDaig = new int[2*n-1];
        int[] leftRow = new int[n];

        solve(0,output,board,upperDaig,lowerDaig,leftRow, n);

        return output;

    }

    private void solve(int col, List<List<String>> output, String[][] board, int[] upperDaig, int[] lowerDaig, int[] leftRow, int n){
        if (col >= n) {
            List<String> inner = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                inner.add(sb.toString());
            }
            output.add(inner);
            return;
        }

        for(int row = 0; row < n; row++){
            if(isSafe(col, row, upperDaig, lowerDaig, leftRow, n)){
                board[row][col] = "Q";
                leftRow[row] = 1;
                lowerDaig[row+col] = 1;
                upperDaig[(n-1) + (col-row)] = 1;
                solve(col+1,output,board,upperDaig,lowerDaig,leftRow, n);
                board[row][col] = ".";
                leftRow[row] = 0;
                lowerDaig[row+col] = 0;
                upperDaig[(n-1) + (col-row)] = 0;
            }
        }
    }

    private boolean isSafe(int col, int row, int[] upperDaig, int[] lowerDaig, int[] leftRow, int n){
        if(leftRow[row]==1 || lowerDaig[col+row]==1 || upperDaig[(n-1) + (col-row)]==1){
            return false;
        }

        return true;
    }
}