class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Mark boundary-connected 'O's using DFS
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, moves);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i, moves);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, moves);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col - 1, moves);
            }
        }

        // Flip all unmarked 'O's to 'X' and revert 'Y' back to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, int[][] moves) {
        board[r][c] = 'Y'; // Mark the cell as visited by changing it to 'Y'

        for (int[] move : moves) {
            int x = r + move[0];
            int y = c + move[1];

            // Check if the new position is within bounds and is an 'O'
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                dfs(board, x, y, moves);
            }
        }
    }
}
