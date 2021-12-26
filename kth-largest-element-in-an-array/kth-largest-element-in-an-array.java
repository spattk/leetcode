class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            if(pq.isEmpty()){
                pq.add(num);
            } else {
                if(num > pq.peek()){
                    if(pq.size() == k){
                        pq.poll();
                    }
                    pq.add(num);
                } else {
                    if(pq.size()<k)
                        pq.add(num);
                }
            }
        }
        
        return pq.peek();
    }
}