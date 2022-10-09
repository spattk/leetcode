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
    
    Set<Integer> set = new HashSet<>();
    boolean result = false;
    public void traversal(TreeNode node, int k) {
        if(node == null || result)
            return;
        
        if(set.contains(k - node.val)) {
            result = true;
        }
        
        set.add(node.val);
        traversal(node.left, k);
        traversal(node.right, k);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        
        traversal(root, k);
        return result;
    }
}