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
    
    public boolean isValidBSTUtil(TreeNode root, double min, double max){
        
        
        if(root == null)
            return true;
        
//         System.out.println(min + " " + max + "::" + root.val + " ** " + (root.val > min) + " ** " +  (root.val < max));
        
        
        return ((root.val > min && root.val < max) && isValidBSTUtil(root.left, min, root.val) && isValidBSTUtil(root.right, root.val, max));
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        if(root.left == null && root.right == null)
            return true;
        
        return isValidBSTUtil(root, -Float.MAX_VALUE, Float.MAX_VALUE);
    }
}