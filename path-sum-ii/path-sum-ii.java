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
    
    public void util(TreeNode root,int sum, List<Integer> path, List<List<Integer>> res) {
        
        if (root == null){
            return;
        }
        
        if (sum == 0 && root.left ==null && root.right ==null){
            res.add(new ArrayList<>(path));
            return;
        }
        
        if (root.left != null) {
            path.add(root.left.val);
            util(root.left, sum-root.left.val, path, res);
            path.remove(path.size()-1);
        }
        
        if (root.right != null) {
            path.add(root.right.val);
            util(root.right, sum-root.right.val, path, res);
            path.remove(path.size()-1);
        }
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null){
            return res;
        }
        path.add(root.val);
        util(root, targetSum-root.val, path, res);
        return res;
    }
}