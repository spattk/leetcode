/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node temp = q.poll();
                list.add(temp.val);
                
                for(Node node: temp.children){
                    q.add(node);
                }
            }
            result.add(list);
        }
        
        
        return result;
    }
}