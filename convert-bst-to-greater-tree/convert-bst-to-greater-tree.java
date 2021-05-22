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
    int totalSum = 0;
    public void setTreeNode(TreeNode root){
        if (root == null){
            return;
        }
        setTreeNode(root.right);
        totalSum += root.val;
        root.val = totalSum;
        setTreeNode(root.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        setTreeNode(root);
        return root;
    }
}