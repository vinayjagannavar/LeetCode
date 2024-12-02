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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> output = new ArrayList<>();

        boolean leftToRight = true;

        Deque<TreeNode> deque = new LinkedList<>();

        if(root==null){
            return output;
        }

        deque.addLast(root);

        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> inner = new ArrayList<>();
            for(int i=0; i<size; i++){
                if(leftToRight){
                    TreeNode curr = deque.pollFirst();
                    inner.add(curr.val);
                    if(curr.left != null){
                        deque.addLast(curr.left);
                    }

                    if(curr.right != null){
                        deque.addLast(curr.right);
                    }
                }
                else{
                    TreeNode curr = deque.pollLast();
                    inner.add(curr.val);

                    if(curr.right != null){
                        deque.addFirst(curr.right);
                    }
                    if(curr.left != null){
                        deque.addFirst(curr.left);
                    }
                }
            }
            leftToRight = !leftToRight;
            output.add(inner);
        }

        return output;
    }
}
//[15,7,5,11]