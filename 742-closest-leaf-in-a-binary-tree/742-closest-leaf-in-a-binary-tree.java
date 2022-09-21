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
    
    public void convertToGraph(Map<Integer, Set<Integer>> adj, TreeNode node, TreeNode parent) {
        if(node == null)
            return;
        
        Set<Integer> curr = adj.getOrDefault(node.val, new HashSet<>());
        if(parent != null)
            curr.add(parent.val);
        
        if(node.left != null)
            curr.add(node.left.val);
        
        if(node.right != null)
            curr.add(node.right.val);
        
        adj.put(node.val, curr);
        
        convertToGraph(adj, node.left, node);
        convertToGraph(adj, node.right, node);
    }
    
    public int bfs(Map<Integer, Set<Integer>> adj, int curr, Set<Integer> leaves){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        Set<Integer> visited = new HashSet<>();
        visited.add(curr);
        
        while(!q.isEmpty()){
            int temp = q.poll();
            if(leaves.contains(temp))
                return temp;
            
            for(int nei: adj.getOrDefault(temp, new HashSet<>())){
                if(!visited.contains(nei)){
                    visited.add(nei);
                    q.add(nei);
                }
            }
        }
        
        return 0;
    }
    
    public void findLeaves(TreeNode root, Set<Integer> leaves){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }
        
        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
    }
    
    public int findClosestLeaf(TreeNode root, int k) {
        Set<Integer> leaves = new HashSet<>();
        findLeaves(root, leaves);
        
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        convertToGraph(adj, root, null);
        
        // System.out.println(adj);
        return bfs(adj, k, leaves);
    }
}