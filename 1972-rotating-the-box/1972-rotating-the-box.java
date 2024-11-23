class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Simulate gravity for each row
        for (int i = 0; i < m; i++) {
            int emptySpot = n - 1; // Start from the rightmost column
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Obstacle: reset emptySpot to just left of '*'
                    emptySpot = j - 1;
                } else if (box[i][j] == '#') {
                    // Stone: move it to the next empty spot
                    box[i][j] = '.';
                    box[i][emptySpot--] = '#';
                }
            }
        }
        
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = box[i][j];
            }
        }

        return result;

    }
}

//floor = 4
//stone = 0;