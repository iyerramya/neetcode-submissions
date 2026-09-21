/*
Definition for a Node.
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
        if(node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            Node currNode = q.poll();
            for(Node n : currNode.neighbors) {
                if(!oldToNew.containsKey(n)) {
                    oldToNew.put(n, new Node(n.val));
                    q.add(n);
                }
                // 1. Get the clone of the current node
                Node clonedCurrNode = oldToNew.get(currNode);
                
                // 2. Get the clone of the neighbor node
                Node clonedNeighbor = oldToNew.get(n);
                
                // 3. Connect them by adding the cloned neighbor to the cloned current node's list
                clonedCurrNode.neighbors.add(clonedNeighbor);
            }
        }
        return oldToNew.get(node);

        // if(visited.containsKey(node)) {
        //     return visited.get(node);
        // }

        // Node newNode = new Node(node.val);
        // visited.put(node, newNode);

        // for(Node neighbor: node.neighbors) {
        //     newNode.neighbors.add(cloneGraph(neighbor));
        // }
        // return newNode;
    }
}