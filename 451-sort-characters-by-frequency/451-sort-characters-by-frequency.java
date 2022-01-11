class Solution {
    class Node {
        int c;
        char ch;
        
        Node(int c, char ch){
            this.c = c;
            this.ch = ch;
        }
    }
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->b.c-a.c);
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(new Node( entry.getValue(), entry.getKey()));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            while(temp.c-->0){
                sb.append(temp.ch);
            }
        }
        
        return sb.toString();
    }
}