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
    
    public boolean isPalindrome(int[] arr){
        int odd = 0, even = 0;
        int total = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2== 0)
                even++;
            else 
                odd++;
            
            total += arr[i];
        }
        
        if(odd > 1)
            return false;
        
        return true;
    }
    
    int count = 0;
    
    public void pathUtil(TreeNode root, int[] arr) {
        if(root == null) {
            return;
        }
        
        arr[root.val]++;
        
        if(root.left == null && root.right == null){
            if(isPalindrome(arr))
                count++;
        }
        
        pathUtil(root.left, arr);
        pathUtil(root.right, arr);
        
        arr[root.val]--;
        
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        pathUtil(root, arr);
        
        return count;
    }
}