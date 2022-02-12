class Solution {
    
    class Node {
        int num;
        int count;
        
        Node(int n, int c){
            num = n;
            count = c;
        }
    }
    
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2)->p1.count-p2.count);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(int key: map.keySet()){
            pq.add(new Node(key, map.get(key)));
        }
        
        while(!pq.isEmpty() && k >= pq.peek().count){
            Node temp = pq.poll();
            k-=temp.count;
        }
        
        return pq.size();
    }
}