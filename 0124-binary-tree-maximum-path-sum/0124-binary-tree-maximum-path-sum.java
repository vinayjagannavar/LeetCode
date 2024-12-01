class Solution {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        // Initialize maxSum to root value (or Integer.MIN_VALUE for safety)
        maxSum = root != null ? root.val : Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }

    private int pathSum(TreeNode root) {
        // Base case: null node contributes 0 to the path sum
        if (root == null) {
            return 0;
        }

        // Recursively calculate max path sum for left and right subtrees
        int leftSum = Math.max(0, pathSum(root.left));  // Ignore negative paths
        int rightSum = Math.max(0, pathSum(root.right)); // Ignore negative paths

        // Update global maxSum if current path is better
        maxSum = Math.max(maxSum, leftSum + root.val + rightSum);

        // Return max gain from either subtree plus the current node value
        return Math.max(leftSum + root.val, rightSum + root.val);
    }
}
