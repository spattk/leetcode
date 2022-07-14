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
    
    public static int pIdx = 0;
    
    public int search(int[] inorder, int item){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == item)
                return i;
        }
        
        return -1;
    }
    
    public TreeNode util(int[] preorder, int[] inorder, int inS, int inE) {
        // System.out.println(inS + " :: " + inE);
        if(pIdx >= preorder.length){
            return null;
        }
        
        if(inS == inE)
            return new TreeNode(inorder[inS]);
        
        if(inS > inE){
            pIdx--;
            return null;
        }
        
        int idx = search(inorder, preorder[pIdx]);
        // System.out.println(idx);
        
        TreeNode root = new TreeNode(inorder[idx]);
        pIdx++;
        root.left = util(preorder, inorder, inS, idx - 1);
        pIdx++;
        root.right = util(preorder, inorder, idx +1, inE);
        
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pIdx = 0;
        return util(preorder, inorder, 0 , inorder.length-1);
    }
}