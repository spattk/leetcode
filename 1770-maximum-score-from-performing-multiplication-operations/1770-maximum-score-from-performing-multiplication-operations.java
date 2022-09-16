class Solution {
    
    //recursive function to give me maxScore with i and j
    Integer[][] dp;
    public int solve(int[] nums, int [] mul, int i, int p){
        
        
        if(dp[i][p] != null)
            return dp[i][p];
        
        int j = nums.length - ( p - i) - 1;
        
        
        if(i > j || p >= mul.length)
            return 0;
        
        int ans1 = solve(nums, mul, i+1,p+1) + mul[p] * nums[i];
        int ans2 = solve(nums, mul, i,p+1) + mul[p] * nums[j] ;
        
        return dp[i][p] = Math.max(ans1, ans2);
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new Integer[1001][1001];
        // for(int i=0; i<dp.length; i++)
        //     Arrays.fill(dp[i], -1);
        return solve(nums, multipliers, 0, 0);
    }
}