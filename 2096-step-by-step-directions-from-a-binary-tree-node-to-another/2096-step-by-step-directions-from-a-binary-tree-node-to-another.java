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
    
    public TreeNode findLCA(TreeNode root, int start, int end) {
        if(root == null)
            return null;

        if(root.val == start || root.val == end) {
            return root;
        }

        TreeNode left = findLCA(root.left, start, end);
        TreeNode right = findLCA(root.right, start, end);

        if(left!= null && right !=null)
            return root;

        return left == null ? right: left;
    }

    public boolean traverse(TreeNode root, int start, StringBuilder sb) {
        if(root == null)
            return false;

        if(root.val == start)
            return true;

        sb.append('L');
        if(traverse(root.left, start, sb))
            return true;
        sb.setLength(sb.length()-1);


        sb.append('R');
        if(traverse(root.right, start, sb))
            return true;
        sb.setLength(sb.length()-1);

        return false;	
    }

    public String getDirections(TreeNode root, int start, int dest) {
        TreeNode lca = findLCA(root, start, dest);

        StringBuilder toStart = new StringBuilder();
        StringBuilder toEnd = new StringBuilder();

        traverse(lca, start, toStart);
        traverse(lca, dest, toEnd);

        StringBuilder result = new StringBuilder();
        for(char ch: toStart.toString().toCharArray()){
            result.append('U');
        }

        for(char ch: toEnd.toString().toCharArray()){
            result.append(ch);
        }

        return result.toString();

    }


}