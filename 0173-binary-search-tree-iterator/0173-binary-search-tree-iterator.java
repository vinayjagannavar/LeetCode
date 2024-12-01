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
class BSTIterator {

    List<Integer> inOrder = new ArrayList<>();
    int index;

    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        index=-1;
    }
    
    public int next() {
        return inOrder.get(++index);
    }
    
    public boolean hasNext() {
        if(index+1 < inOrder.size()){
            return true;
        }
        else{
            return false;
        }
        
    }

    private void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }

        inorderTraversal(root.left);
        inOrder.add(root.val);
        inorderTraversal(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */