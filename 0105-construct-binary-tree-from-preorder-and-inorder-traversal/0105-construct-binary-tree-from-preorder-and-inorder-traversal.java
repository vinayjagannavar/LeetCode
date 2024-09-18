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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }

        return split(preorder, map, 0, 0, inorder.length-1);
    }

    private TreeNode split(int[] preorder, Map<Integer,Integer> inorderMap, int rootIndex, int left, int right){
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inorderMap.get(preorder[rootIndex]);

        if(mid>left){
            root.left = split(preorder,inorderMap,rootIndex+1, left,mid-1);
        }

        if(mid<right){
            root.right = split(preorder,inorderMap, rootIndex+mid-left+1, mid+1, right);
        }

        return root;
    }
}