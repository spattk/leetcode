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
    
    List<List<Integer>> result = new ArrayList<>();
    
    public void pathUtil(TreeNode root, int targetSum, List<Integer> path){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null && targetSum == root.val){
            path.add(root.val);
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        
        path.add(root.val);
        pathUtil(root.left, targetSum - root.val, path);
        pathUtil(root.right, targetSum - root.val, path);
        path.remove(path.size()-1);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        pathUtil(root, targetSum, path);
        return result;
    }
}