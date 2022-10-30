/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    static int pos = 0;
    static String treePath;
    
    public int extractNum(String data){
        int num = 0;
        char ch = data.charAt(pos);
        int sign = 1;
        while(Character.isDigit(ch) || ch == '-'){
            if(ch == '-'){
                sign = -1;
            } else {
                num *= 10;
                num += (ch - '0');
            }
            pos++;
            
            if(pos == data.length())
                break;
            ch = data.charAt(pos);
        }
        return num * sign;
    }
    
    public TreeNode buildTree(String data){
        if(pos == data.length() || data == null)
            return null;
        
        if(data.charAt(pos) == ','){
            pos++;
        }
        
        if(data.charAt(pos) == 'N'){
            pos+=2;
            return null;
        }
        
        int num = extractNum(data);
        TreeNode root = new TreeNode(num);
        root.left = buildTree(data);
        root.right = buildTree(data);

        return root;
    }
    
    public void buildString(TreeNode root){
        if(root == null){
            treePath += "N,";
            return;
        }
        
        treePath += root.val+ ",";
        buildString(root.left);
        buildString(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        treePath = "";
        buildString(root);
        return treePath;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        pos = 0;
        return buildTree(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));