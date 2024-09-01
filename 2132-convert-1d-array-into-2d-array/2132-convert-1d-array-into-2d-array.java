class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        if(original.length > m*n || original.length < m*n){
            return new int[][]{};
        }

        int output[][] = new int[m][n];
        int row = 0;
        int col = 0;

        for(int i=0; i<original.length; i++){
            output[row][col] = original[i];
            col++;
            if(col==n){
                row++;
                col=0;
            }
        }

        return output;
    }
}