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
    int maxlevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if(root == null){
            return rightView;
        }

        rightView.add(root.val);

        traversal(root.right,0, rightView);
        traversal(root.left,0, rightView);

        return rightView;

    }


    private void traversal(TreeNode root, int level, List<Integer> rightView){
        if(root==null){
            return;
        }

        level++;

        if(level>maxlevel){
            rightView.add(root.val);
        }
        
        maxlevel = Math.max(maxlevel, level);

        traversal(root.right, level, rightView);
        traversal(root.left, level, rightView);

    }
}

