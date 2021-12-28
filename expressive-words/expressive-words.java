class Solution {
    class Node {
        char ch;
        int count;
        
        Node(char ch){
            this.ch = ch;
        }
        
        Node(char ch, int count ){
            this.ch = ch;
            this.count = count;
        }
        
        public String toString(){
            return this.ch + " " + this.count;
        }
    }
    
    public boolean helper(List<Node> sNode, List<Node> wNode){
        int n1 = sNode.size(), n2 = wNode.size();
        if(n1 != n2)
            return false;
        
        for(int i=0;i<n1;i++){
            Node t1 = sNode.get(i);
            Node t2 = wNode.get(i);
            
            if(t1.ch != t2.ch){
                return false;
            }
            
            if(t1.count != t2.count){
                if(t1.count < 3 || t1.count < t2.count)
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean isExpressive(List<Node> sNode, String word){
        List<Node> wNode = new ArrayList<>();
        for(char ch: word.toCharArray()){
            if(wNode.size() == 0){
                wNode.add(new Node(ch, 1));
            } else{
                if(wNode.get(wNode.size()-1).ch == ch){
                    Node temp = wNode.get(wNode.size()-1);
                    temp.count += 1;
                } else {
                    wNode.add(new Node(ch, 1));
                }
            }
        }
        
        return helper(sNode, wNode);
    }
    
    public int expressiveWords(String s, String[] words) {
        List<Node> sNode = new ArrayList<>();
        for(char ch: s.toCharArray()){
            if(sNode.size() == 0){
                sNode.add(new Node(ch, 1));
            } else{
                if(sNode.get(sNode.size()-1).ch == ch){
                    Node temp = sNode.get(sNode.size()-1);
                    temp.count += 1;
                } else {
                    sNode.add(new Node(ch, 1));
                }
            }
        }
        
        // System.out.println(sNode);
        int count = 0;
        for(String word: words)
            if(isExpressive(sNode, word))
                count++;
        
        return count;
    }
}