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
    
    public boolean isLeaf(TreeNode root){
        if(root == null)
            return false;
        
        return root.left == null && root.right == null;
    }
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        
        if(root1 == null || root2 == null)
            return false;
        
        // System.out.println(root1.val + " " + root2.val);
        
        if(root1.val != root2.val){
            return false;
        }
        
        if(isLeaf(root1) && isLeaf(root2))
            return true;
        
        if((root1.left != null && root2.left != null && root1.left.val != root2.left.val) || (root1.right != null && root2.right != null && root1.right.val != root2.right.val)){
            boolean temp=  flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            // System.out.println(temp);
            return temp;
        }
        
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
        
    }
}