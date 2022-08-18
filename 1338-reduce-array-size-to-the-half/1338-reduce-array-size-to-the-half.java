class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: arr){
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q) -> q-p);
        for(int key: map.keySet()){
            pq.add(map.get(key));
        }
        
        int m = n;
        int count = 0;
        while(!pq.isEmpty()){
            m -= pq.poll();
            count++;
            
            if(m <= n/2)
                return count;
        }
        
        return -1;
    }
}