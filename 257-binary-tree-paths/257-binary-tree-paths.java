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
    
    List<String> result;
    
    public String toString(List<Integer> path){
        StringBuilder sb = new StringBuilder();
        for(int num: path){
            sb.append(num + "->");
        }
        
        if(sb.length() > 0){
            sb.setLength(sb.length()-2);
        }
        return sb.toString();
    }
    public void util(TreeNode root, List<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            
            result.add(toString(path));
            path.remove(path.size()-1);
            return;
        }
        
        util(root.left, path);
        util(root.right, path);
        
        path.remove(path.size()-1);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        result = new ArrayList<>();
        util(root, path);
        return result;
    }
}