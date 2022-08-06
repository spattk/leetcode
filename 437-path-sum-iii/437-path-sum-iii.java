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
    Map<Long, Integer> prefixCount;
    int result;
    
    public void dfs(TreeNode root, long targetSum, long prevSum) {
        if(root == null)
            return;
        
        long currSum = prevSum + root.val;
        
        result += prefixCount.getOrDefault(currSum - targetSum, 0);
        
        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) + 1);
        
        dfs(root.left, targetSum, currSum);
        dfs(root.right, targetSum, currSum);
        
        prefixCount.put(currSum, prefixCount.getOrDefault(currSum, 0) - 1);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        prefixCount = new HashMap<>();
        prefixCount.put(0L,1);
        result = 0;
        dfs(root, targetSum, 0);
        return result;
    }
}