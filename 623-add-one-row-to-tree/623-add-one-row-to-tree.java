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
    
    public void traverse(TreeNode root, int val, int depth){
        if(root == null || depth <= 0)
            return;
        
        if(depth == 1){
            TreeNode left = root.left;
            TreeNode right = root.right;
            
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            
            root.left.left = left;
            root.right.right = right;
            
            return;
        }
        
        traverse(root.left, val, depth - 1);
        traverse(root.right, val, depth - 1);
    }
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        } else {
            traverse(root, val, depth - 1);
            return root;
        }
    }
}