class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //number, idx
        int [] result = new int[nums.length-k + 1];
        int z = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->q[0]-p[0]);
        for(int i=0; i<k; i++){
            pq.add(new int[]{nums[i], i});
        }
        result[z++] = pq.peek()[0];
        
        int n = nums.length;
        
        for(int i=k; i<n; i++){
            while(!pq.isEmpty() && pq.peek()[1] <= i-k){
                pq.poll();
            }
            pq.add(new int[]{nums[i], i});
            result[z++] = pq.peek()[0];
        }
        
        return result;
    }
}