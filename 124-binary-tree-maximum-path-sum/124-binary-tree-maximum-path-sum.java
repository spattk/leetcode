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
    
    public int util(TreeNode root){
        if(root == null){
            return 0;
        }
        
        
        int lv = util(root.left);
        int rv = util(root.right);
        
        
        int v1 = root.val;
        int v2 = root.val + Math.max(lv, rv);
        int v3 = root.val + lv + rv;
        
        max = Math.max(max, Math.max(v1, Math.max(v2, v3)));
        
        int r1 = root.val + Math.max(lv, rv);
        return Math.max(root.val, r1);
    }
    
    public int maxPathSum(TreeNode root) {
        util(root);
        return max;
    }
}