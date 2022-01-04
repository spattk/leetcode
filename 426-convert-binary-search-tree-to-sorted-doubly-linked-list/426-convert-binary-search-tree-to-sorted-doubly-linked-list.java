/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    Node curr = null, first = null, last = null, head = null;
    public void helper(Node root){
        if(root == null)
            return;
        
        helper(root.left);
        //print(root.val);
        if(last != null){
            last.right = root;
            root.left = last;
        }
        
        if(first == null){
            first = root;
        }
        last = root;
        
        
        helper(root.right);
    }
    public Node treeToDoublyList(Node root) {
        helper(root);
        if(root == null)
            return root;
        
        
        last.right = first;
        first.left = last;
        return first;
    }
}