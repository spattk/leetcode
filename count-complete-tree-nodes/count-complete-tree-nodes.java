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
    
    public int leftLevel(TreeNode root){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        return 1 + leftLevel(root.left);
    }
    
    public int rightLevel(TreeNode root){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        return 1 + rightLevel(root.right);
    }
    
    int count = 0;
    
    
    public int countNodes(TreeNode root) {
        if(root == null)
            return count;
        
        int left = leftLevel(root);
        int right = rightLevel(root);
        
        if(left == right){
            return count + (int)Math.pow(2,left)- 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}