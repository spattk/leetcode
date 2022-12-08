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
    
    public boolean compareLeaves(List<Integer> leaves1, List<Integer> leaves2){
        if(leaves1.size() != leaves2.size())
            return false;
        
        for(int i=0; i<leaves1.size(); i++){
            if(leaves1.get(i) != leaves2.get(i))
                return false;
        }
        
        return true;
    }
    
    public void getLeaves(List<Integer> leaves, TreeNode root){
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            leaves.add(root.val);
        
        getLeaves(leaves, root.left);
        getLeaves(leaves, root.right);
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        getLeaves(leaves1, root1);
        getLeaves(leaves2, root2);
        
        return compareLeaves(leaves1, leaves2);
    }
}