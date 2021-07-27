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
    
    public TreeNode buildTree(int l, int r, int [] nums){
        if (l > r){
            return null;
        }
        
        if (l == r){
            return new TreeNode(nums[l]);
        }
        
        int mid = l + (r - l )/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(l, mid-1, nums);
        root.right = buildTree(mid+1, r, nums);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length-1, nums);
    }
}