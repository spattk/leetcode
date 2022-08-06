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
    Map<Node, Node> clonedMap = new HashMap<>();
    
    //recursive function, that clones a node and returns the cloned node
    public Node clone(Node node){
        if(node == null)
            return null;
        
        if(clonedMap.get(node) != null)
            return clonedMap.get(node);
        
        Node copy = new Node(node.val);
        clonedMap.put(node, copy);
        for(Node nei: node.neighbors){
            copy.neighbors.add(clone(nei));
        }
        return copy;
    }
    
    public Node cloneGraph(Node node) {
        //make a map, oldNode-> newNode
        //make a recursive call which clones the current node
        return clone(node);
        
    }
}