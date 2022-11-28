class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        pq.addAll(map.values());
        
        int sum = 0;
        while(!pq.isEmpty()){
            List<Integer> curr = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                if(!pq.isEmpty()){
                    curr.add(pq.poll());
                }
            }
            
            for(int num: curr){
                if(--num > 0){
                    pq.add(num);
                }
            }
            
            //if last
            sum += pq.isEmpty() ? curr.size() : n + 1;
        }
        
        return sum;
    }
}