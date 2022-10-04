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
    
    boolean result = false;
    
    public void hasPathSumUtil(TreeNode root, int targetSum){
        if(root == null)
            return;
        
        if(result)
            return;
        
        if(root.left == null && root.right == null && targetSum == root.val){
            result = true;
            return;
        }
            
        hasPathSumUtil(root.left, targetSum - root.val);
        hasPathSumUtil(root.right, targetSum - root.val);
        
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        hasPathSumUtil(root, targetSum);
        return result;
    }
}