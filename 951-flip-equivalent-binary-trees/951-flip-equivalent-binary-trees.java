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
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 == null || root2 == null)
            return false;
        
        // System.out.println(root1.val + " " + root2.val);
        
        if(root1.val != root2.val){
            return false;
        }
        
        boolean temp1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean temp2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return temp1 || temp2;
    }
}