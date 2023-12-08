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
    
    StringBuilder sb = new StringBuilder();
    
    public void treeUtil(TreeNode root, StringBuilder sb, boolean isOpen) {
        
        sb.append("(");
        sb.append("" + root.val);
        
        
        if(root.left == null && root.right == null) {
            if(isOpen) {
                sb.append(")");
            }
            return;
        }
        
        if(root.left == null && root.right != null){
            sb.append("()");
        }
        
        if(root.left != null) {
            treeUtil(root.left, sb, true);
        }
        
        if(root.right != null) {
            treeUtil(root.right, sb, true);
        }
        
        sb.append(")");
    }
    
    public String tree2str(TreeNode root) {
        treeUtil(root, sb, true);
        
        String str= sb.toString();
        return str.substring(1, str.length()-1);
    }
}