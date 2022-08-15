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
    
    int maxDia = 0;
    
    public int diameter(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return 0;
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        
        
        int adder = 0;
        if(root.left != null)
            adder++;
        
        if(root.right != null)
            adder++;
        
        
        maxDia = Math.max(maxDia, adder + ld + rd);
        
        return 1 + Math.max(ld, rd);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int temp = diameter(root);
        return Math.max(temp, maxDia);
    }
}