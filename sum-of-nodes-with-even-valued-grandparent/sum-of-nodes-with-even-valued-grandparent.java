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

class Node {
    TreeNode node;
    boolean grandparent;
    boolean parent;
    
    Node(TreeNode node, boolean gp, boolean p){
        this.node = node;
        this.grandparent = gp;
        this.parent = p;
    }
}

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, false, false));
        int sum = 0;
        while(!q.isEmpty()){
            Node temp = q.remove();
            if (temp.grandparent){
                sum += temp.node.val;
            }
            if (temp.node.left != null){
                q.add(new Node(temp.node.left, temp.parent, temp.node.val%2==0));
            }
            if (temp.node.right != null){
                q.add(new Node(temp.node.right, temp.parent, temp.node.val%2==0));
            }
        }
        return sum;
    }
}