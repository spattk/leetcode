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
    int ans = 0;

    public void goodNodesUtil(TreeNode root, int maxTillNow){
        if(root == null)
            return;
        
        if(root.val >= maxTillNow)
            ans++;
        
        goodNodesUtil(root.left, Math.max(maxTillNow, root.val));
        goodNodesUtil(root.right, Math.max(maxTillNow, root.val));
    }
    
    public int goodNodes(TreeNode root) {
        goodNodesUtil(root, Integer.MIN_VALUE);
        return ans;
    }
}