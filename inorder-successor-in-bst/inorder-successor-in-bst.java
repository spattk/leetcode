/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode prev = null;
    TreeNode ans = null;
    public void solve(TreeNode root, TreeNode p){
        if(root == null)
            return;
        
        if(ans != null)
            return;
        
        
        
        solve(root.left, p);
        
        if(prev == p && ans == null) {
            ans = root;
            return;
        }
        
        prev = root;
        solve(root.right, p);
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        solve(root, p);
        return ans;
    }
}