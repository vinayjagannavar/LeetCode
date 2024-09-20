class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        // Start the backtracking process from the first row
        backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return count;
    }

    private void backtrack(int n, int row, Set<Integer> cols, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // If we've placed queens in all rows, it's a valid solution
        if (row == n) {
            count++;      
            return;       
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // Calculate the two types of diagonals for the current position
            int diagonal1 = row - col;  // "/" diagonal
            int diagonal2 = row + col;  // "\" diagonal

            // Check if the column or diagonals are already occupied
            if (cols.contains(col) || diagonals1.contains(diagonal1) || diagonals2.contains(diagonal2)) {
                continue;
            }

            // Add the current position to the sets marking used columns and diagonals
            cols.add(col);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);

            // Move to the next row
            backtrack(n, row + 1, cols, diagonals1, diagonals2);

            // Backtrack: remove the queen and try a new position
            cols.remove(col);
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }
}
