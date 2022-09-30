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
    
    
    int max = 0;
    public void util(TreeNode root, int prev, int count) {
        
        max = Math.max(max, count);
        
        if(root == null) {
            return;
        }
        
        
        if(root.val == 1 + prev){
            util(root.left, root.val, count + 1);
            util(root.right, root.val, count + 1);
        } else {
            util(root.left, root.val, 1);
            util(root.right, root.val, 1);
        }
        
    }
    
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        
        util(root.left, root.val, 1);
        util(root.right, root.val, 1);
        return max;
    }
}