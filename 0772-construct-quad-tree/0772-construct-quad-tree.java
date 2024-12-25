class Solution {
    public Node construct(int[][] grid) {
        return subDivide(grid, 0, 0, grid.length);
    }

    private Node subDivide(int[][] grid, int startRow, int startCol, int size) {
        // Base case: if the grid is a single cell, create a leaf node
        if (size == 1) {
            return new Node(grid[startRow][startCol] == 1, true);
        }

        int halfSize = size / 2;

        // Recursively divide the grid into four quadrants
        Node topLeft = subDivide(grid, startRow, startCol, halfSize);
        Node topRight = subDivide(grid, startRow, startCol + halfSize, halfSize);
        Node bottomLeft = subDivide(grid, startRow + halfSize, startCol, halfSize);
        Node bottomRight = subDivide(grid, startRow + halfSize, startCol + halfSize, halfSize);

        // Check if all four quadrants are leaf nodes with the same value
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            // Merge the nodes into a single leaf node
            return new Node(topLeft.val, true);
        }

        // Otherwise, create a parent node with these four children
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
