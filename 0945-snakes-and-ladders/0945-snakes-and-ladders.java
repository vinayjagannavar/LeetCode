public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int nSquare = n * n;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nSquare + 1]; // To avoid revisiting cells
        q.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            moves++;

            for (int i = 0; i < size; i++) {
                int curr = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if (next > nSquare) break;

                    // Calculate row and column based on the board's zigzag pattern
                    int row = n - (next - 1) / n - 1;
                    int col = ((n - row) % 2 == 1) ? (next - 1) % n : n - 1 - (next - 1) % n;

                    if (board[row][col] != -1) {
                        next = board[row][col]; // Move to the destination cell if ladder or snake exists
                    }

                    if (next == nSquare) {
                        return moves; // Reached the final cell
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return -1; // If the end is unreachable
    }
}