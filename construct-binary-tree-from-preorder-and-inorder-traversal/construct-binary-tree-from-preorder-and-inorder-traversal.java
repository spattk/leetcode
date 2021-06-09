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
    
    static int pre;
    
    public TreeNode buildTreeUtil(int[] preorder, int [] inorder, int iS, int iE) {
        if (iS > iE){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[pre++]);
        
        if (iS == iE){
            return node;
        }
        
        int in = search(inorder, node.val, iS, iE);
        
        node.left = buildTreeUtil(preorder, inorder, iS, in-1);
        node.right = buildTreeUtil(preorder, inorder, in+1, iE);
        
        return node;
    }
    
    public int search(int[] inorder, int val, int start, int end) {
        for(int i=start;i<=end;i++){
            if (inorder[i]==val){
                return i;
            }
        }
        
        return -1;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        return buildTreeUtil(preorder, inorder, 0, inorder.length-1);
    }
}