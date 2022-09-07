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
    
    public void preorder(TreeNode root, List<String> path) {
    
        //root
        //left
        //right
        if(root == null)
            return;
        
        path.add("" + root.val);
        
        if(root.left == null && root.right == null)
            return;
        
        if(root.left != null || root.right != null) {
            path.add("(");
            preorder(root.left, path);
            path.add(")");
        }
        
        if(root.right != null){
            path.add("(");
            preorder(root.right, path);
            path.add(")");
        }
        
    }
    
    public String tree2str(TreeNode root) {
        List<String> path = new ArrayList<>();
        preorder(root, path);
        return String.join("", path);
    }
}