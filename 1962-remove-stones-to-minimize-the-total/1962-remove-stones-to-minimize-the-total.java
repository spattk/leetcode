class Solution {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((p,q)->q-p);
        
        for(int pile: piles){
            sum += pile;
            pq.add(pile);
        }
        
        while(k-->0){
            int curr = pq.poll();
            sum -= curr;
            int remove = (int) Math.floor(curr/2.0);
            curr -= remove;
            sum += curr;
            
            pq.add(curr);
        }
        
        return sum;
    }
}