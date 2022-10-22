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
    
    public int findLeavesUtil(TreeNode root, List<Integer> curr){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            curr.add(root.val);
            return 1;
        }
        
        int left = findLeavesUtil(root.left, curr);
        int right = findLeavesUtil(root.right, curr);
        
        if(left == 1){
            root.left = null;
        }
        
        if(right == 1){
            root.right = null;
        }
        
        return 0;
    }
    
    public boolean isLeaf(TreeNode root){
        if(root == null)
            return false;
        
        return root.left == null && root.right == null;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        while(root != null && !isLeaf(root)){
            List<Integer> temp = new ArrayList<>();
            findLeavesUtil(root, temp);
            result.add(temp);
        }
        
        result.add(Arrays.asList(root.val));
        
        return result;
    }
}