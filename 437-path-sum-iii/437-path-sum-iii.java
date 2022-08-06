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
    
    int result = 0;
    public void innerDfs(TreeNode root, long curr, int targetSum){
        if(root == null)
            return;
        
        curr += root.val;
        if(curr == targetSum)
            result++;
        
        innerDfs(root.left, curr, targetSum);
        innerDfs(root.right, curr, targetSum);
        
    }
    
    public void outerDfs(TreeNode node, int targetSum){
        
        if(node == null)
            return;
        
        innerDfs(node, 0, targetSum);
        outerDfs(node.left, targetSum);
        outerDfs(node.right, targetSum);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        
        outerDfs(root, targetSum);
        return result;
    }
}