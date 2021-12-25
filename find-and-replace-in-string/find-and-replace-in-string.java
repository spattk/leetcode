class Solution {
    
    class Node {
        int index;
        String source;
        String target;
        
        Node(int i, String s, String t){
            index = i;
            source = s;
            target = t;
        }
        
        public String toString(){
            return "[" + this.index + " " + this.source + " " + this.target + "]";
        }
    }
    
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<String> list = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        int n = s.length();
        
        for(int i=0;i<indices.length;i++){
            nodes.add(new Node(indices[i], sources[i], targets[i]));
        }
        
        nodes.sort((a,b)->a.index-b.index);
        // System.out.println(nodes);
        
        int i=0, k = 0;
        
        
        while(i < n){
            // System.out.println("i " + i + " k " + k);
            if(k < indices.length && nodes.get(k).index == i){
                int len = nodes.get(k).source.length();
                if(s.substring(i, i+len).equals(nodes.get(k).source)){
                    i+= nodes.get(k).source.length();
                    // System.out.println(nodes.get(k).target);
                    list.add(nodes.get(k).target);
                    k++;
                } else {
                    list.add("" + s.charAt(i));
                    // System.out.println(s.charAt(i));
                    i++;
                    k++;
                }
            } else{
                list.add("" + s.charAt(i));
                // System.out.println(s.charAt(i));
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String st: list){
            sb.append(st);
        }
        
        return sb.toString();
    }
}