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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        TreeNode left = root, right = root;
        int height = 0;
        while(right != null){
            left = left.left;
            right = right.right;
            height++;
        }
        
        if(left == null){
            return (1 << height) - 1;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}