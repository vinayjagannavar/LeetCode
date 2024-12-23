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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0 ;
        while(!q.isEmpty()){
            int n=q.size();
            int[] levelNodes = new int[n];
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                levelNodes[i] = curr.val;

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res+=minSwaps(levelNodes, n);
        }

        return res;
    }
    private int minSwaps(int[] nodes, int n){
        int res =0;
        int[] clone = nodes.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(nodes[i], i);
        }
        for(int i=0;i<n;i++){
            if(nodes[i]!=clone[i]) {
                res++;
                int tmp = pos.get(clone[i]);
                pos.put(nodes[i],tmp);
                nodes[tmp]=nodes[i];
            }
        }
        return res;
    }
}