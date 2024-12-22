/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Iterate through the neighbors of the current node
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor if it hasn't been cloned yet
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                // Add the cloned neighbor to the current node's clone's neighbors
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }

        // Return the clone of the root node
        return map.get(node);
    }
}