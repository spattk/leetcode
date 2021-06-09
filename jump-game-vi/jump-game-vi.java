class Solution {
    
    class Node {
        int val;
        int idx;
        
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public int maxResult(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.val - a.val);
        
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[n-1] = nums[n-1];
        pq.add(new Node(nums[n-1], n-1));
        
        if (n==1){
            return nums[0];
        } else if (n==2){
            return Math.max(nums[1], nums[0] + nums[1]);
        }
        
        for(int i=n-2;i>=0;i--){
            int min = -1;
            while (!pq.isEmpty()){
                if (pq.peek().idx > (i + k)){
                    pq.poll();
                } else{
                    break;
                }
            }
            dp[i] = nums[i] + pq.peek().val;
            pq.add(new Node(dp[i], i));
        }
        
        return dp[0];
    }
}