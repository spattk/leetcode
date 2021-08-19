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
    
    public void dfs(Node curr, Node node, Node[] created) {
        
        for(Node ele: curr.neighbors){
            if (created[ele.val] == null){
                Node newNode = new Node(ele.val);
                created[ele.val] = newNode;
                node.neighbors.add(newNode);
                dfs(ele, newNode, created);
            } else {
                node.neighbors.add(created[ele.val]);
            }
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        // List<Node> created = new ArrayList<>();
        Node[] created = new Node[1000];
        
        Node clone = new Node(node.val);
        created[node.val] = clone;
        
        for(Node curr: node.neighbors){
            if(created[curr.val] == null){
                Node newNode = new Node(curr.val);
                created[curr.val] = newNode;
                clone.neighbors.add(newNode);
                dfs(curr, newNode, created);
            } else {
                clone.neighbors.add(created[curr.val]);
            }
        }
        
        return clone;
    }
}