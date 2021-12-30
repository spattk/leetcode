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
    
    int max = Integer.MIN_VALUE;
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int temp = root.val;
        if(left > 0){
            temp += left;
        }
        
        if(right > 0){
            temp += right;
        }
        
        max = Math.max(max, temp);
        
        return Math.max(root.val, root.val+Math.max(left, right));
    }
    
    public int maxPathSum(TreeNode root) {
        int temp = helper(root);
        return Math.max(temp, max);
    }
}