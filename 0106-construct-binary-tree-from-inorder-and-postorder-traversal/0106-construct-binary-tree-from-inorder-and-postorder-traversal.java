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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();

        for(int i=0; i< inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        return split(inorderMap, postorder, postorder.length-1, 0, postorder.length-1);
    }

    private TreeNode split(Map<Integer,Integer> inorderMap, int[] postorder , int rootIndex, int left, int right){
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int mid = inorderMap.get(postorder[rootIndex]);

        if(mid>left){
            root.left = split(inorderMap, postorder, rootIndex - (right - mid) - 1, left, mid-1);
        }

        if(mid<right){
            root.right = split(inorderMap, postorder, rootIndex-1, mid+1, right);
        }

        return root;
    }
}