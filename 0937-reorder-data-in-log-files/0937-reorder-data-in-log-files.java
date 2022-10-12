class Solution {
    
    class Node {
        String id;
        String content;
        int idx;
        char type;
        
        Node(String id, String content, int idx, char type){
            this.id = id;
            this.content = content;
            this.idx = idx;
            this.type = type;
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        List<Node> list = new ArrayList<>();
        int k=0;
        for(String log: logs){
            String[] parts = log.split(" ");
            char type = 'l';
            if(Character.isDigit(parts[1].charAt(0)))
                type = 'd';
            list.add(new Node(parts[0], log.substring(parts[0].length()+1), k, type));
            k++;
        }
        
        Collections.sort(list, new Comparator<Node> (){
            public int compare(Node n1, Node n2){
                if(n1.type == n2.type){
                    if(n1.type == 'd') {
                        return Integer.compare(n1.idx, n2.idx);
                    } else {
                        int val = n1.content.compareTo(n2.content);
                        
                        if(val != 0)
                            return val;
                        
                        return n1.id.compareTo(n2.id);
                    }
                } else {
                    if(n1.type == 'd') {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        
        String[] arr = new String[logs.length];
        k = 0;
        for(Node node: list){
            String str = node.id + " " + node.content;
            arr[k++] = str;
        }
        
        return arr;
    }
}