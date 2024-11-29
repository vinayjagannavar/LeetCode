/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root==null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){ // 
            int size = q.size(); // 3
            Node curr = q.poll(); // 4

            for(int i=0; i<size; i++){ // 2
                Node prev = curr; // 7

                if(curr.left!=null){
                    q.offer(curr.left);
                }

                if(curr.right != null){
                    q.offer(curr.right);
                }

                if(i<size-1){
                    curr = q.poll(); // 7
                }
                else{
                    curr = null;
                }
                prev.next = curr; // 2->3->null
                                    // 4->5->7
            }
        }

        return root;
    }
}