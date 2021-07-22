class Solution {
    class Node {
        int left;
        int right;
        
        Node(int l, int r){
            this.left = l;
            this.right =r;
        }
    }
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int lastleft = -1;
        Node[] arr = new Node[n];
        for(int i=0;i<n;i++){
            arr[i] = new Node(-1,-1);
        }
        
        int lastLeft = -1, lastRight = -1;
        
        for(int i=n-1;i>=0;i--){
            char ch = dominoes.charAt(i);
            if (ch == '.') {
                if (lastLeft == -1){
                    continue;
                } else {
                    arr[i].left = Math.abs(lastLeft-i);
                }
            }
            else if (ch == 'L') {
                lastLeft = i;
                arr[i].left = Math.abs(lastLeft-i);
            } else {
                lastLeft = -1;
                continue;
            }
        }
        
        for(int i=0;i<n;i++){
            char ch = dominoes.charAt(i);
            if (ch == '.') {
                if (lastRight == -1){
                    continue;
                } else {
                    arr[i].right = Math.abs(lastRight-i);
                }
            }
            else if (ch == 'R') {
                lastRight = i;
                arr[i].right = Math.abs(lastRight-i);
            } else {
                lastRight = -1;
                continue;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            Node temp = arr[i];
            
            if (temp.left == -1 && temp.right == -1){
                sb.append(".");
            } else if (temp.left != -1 && temp.right != -1) {
                if (temp.left < temp.right){
                    sb.append("L");
                } else if (temp.left > temp.right){
                    sb.append("R");
                } else {
                    sb.append(".");
                }
            } else if (temp.left == -1) {
                sb.append("R");
            } else if (temp.right == -1){
                sb.append("L");
            }
        }
        
        return sb.toString();
    }
}