class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->p-q);
        int n = capacity.length;
        
        for(int i=0; i<n; i++){
            int diff = capacity[i] - rocks[i];
            pq.add(diff);
        }
        
        int count = 0;
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr <= additionalRocks){
                count++;
                additionalRocks -= curr;
            } else {
                break;
            }
        }
        
        return count;
    }
}