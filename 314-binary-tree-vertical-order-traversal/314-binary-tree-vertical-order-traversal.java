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
    
    class Node {
        TreeNode tNode;
        int level;
        
        Node(TreeNode tNode, int l) {
            this.tNode = tNode;
            this.level = l;
        }
            
    }
    
    Map<Integer, List<Integer>> mapLevel;
    List<List<Integer>> list;

    
    public void sortMapLevel(){
        List<Integer> key = new ArrayList<>(mapLevel.keySet());
        Collections.sort(key);
        
        for(int k: key){
            list.add(mapLevel.get(k));
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        list = new ArrayList<>();
        if(root == null)
            return list;
        
        mapLevel = new HashMap<>();   
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root,0));
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Integer> temp = mapLevel.getOrDefault(curr.level, new ArrayList<>());
            temp.add(curr.tNode.val);
            mapLevel.put(curr.level, temp);
            
            if(curr.tNode.left != null){
                q.add(new Node(curr.tNode.left, curr.level-1));
            }
            
            if(curr.tNode.right != null){
                q.add(new Node(curr.tNode.right, curr.level+1));
            }
        }
        
        sortMapLevel();
        
        return list;
    }
}