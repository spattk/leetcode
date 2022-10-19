class Solution {
    
    class Node {
        String str;
        int count;
        
        Node(String str, int count ){
            this.str = str;
            this.count = count;
        }
    }
    
    public static int customComparator(Node n1, Node n2){
        int val = Integer.compare(n1.count, n2.count);
        if(val != 0)
            return val;
        
        return n2.str.compareTo(n1.str);
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Solution::customComparator);
        
        for(String w: words){
            count.put(w, count.getOrDefault(w, 0)+1);
        }
        
        for(String key: count.keySet()){
            pq.add(new Node(key, count.get(key)));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        List<String> answer = new ArrayList<>();
        while(!pq.isEmpty()){
            answer.add(pq.poll().str);
        }
        
        Collections.reverse(answer);
        return answer;
    }
}