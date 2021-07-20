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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    
        int f, s;
        if (p.val <= q.val){
            f = p.val;
            s = q.val;
        } else {
            f = q.val;
            s = p.val;
        }
        
        System.out.println(f + " " + s);
        
        if (root.val > f && root.val > s)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < f && root.val < s) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
            
    }
}