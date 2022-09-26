class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //(num, idx)
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)-> (q[0]-p[0]));
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for(int i=0; i<k; i++){
            pq.add(new int[]{nums[i], i});
        }
        
        ans[0] = pq.peek()[0];
        for(int i=k; i<n; i++){
            pq.add(new int[]{nums[i], i});
            while(!pq.isEmpty() && pq.peek()[1] <= i - k){
                pq.poll();
            }
            
            ans[i-k + 1] = pq.peek()[0];
        }
        
        return ans;
    }
}