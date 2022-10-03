class Solution {
    
    int k;
    int n;
    Integer[][] dp;
    long mod = (long)(1e9 + 7);
    public int solve(int idx, int target) {
        
        
        if(target < 0 || idx > n)
            return 0;
        
        if(target == 0 && idx == n)
            return 1;
        
        if(target == 0)
            return 0;
        
        if(dp[idx][target] != null)
            return dp[idx][target];
        
        long sum = 0;
        for(int i=1; i<=k; i++){
            sum = (sum + solve(idx + 1, target - i)) % mod;
        }
        
        return dp[idx][target] = (int)sum;
    }
    
    public int numRollsToTarget(int N, int K, int target) {
        this.k = K;
        this.n = N;
        dp = new Integer[N+1][target+1];
        return solve(0, target);
    }
}