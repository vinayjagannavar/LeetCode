/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return balancedTree(0,list.size() - 1);   
    }

    private TreeNode balancedTree(int start, int end){
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode newRoot = new TreeNode(list.get(mid));
        newRoot.left = balancedTree(start,mid-1);
        newRoot.right = balancedTree(mid+1,end);

        return newRoot;
    }

    private void inOrder(TreeNode root){
        if(root==null){
            return;
        }

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);

        return;
    }
}