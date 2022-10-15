class Solution {
    
    Long[][][] dp;
    public int solve(int late, int abs, int n, int len){
        if(n == len){
            return 1;
        }
        
        long mod = (long)(1e9 + 7);
        
        
        if(dp[abs][late][n] != null)
            return (int)(dp[abs][late][n] % mod);
        
        long total = 0;
        
        if(abs == 0){
            total = (total + solve(0, 1, n+1, len))%mod;
        }
        
        if(late < 2){
            total = (total + solve(late + 1, abs, n+1, len))%mod;
        }
        
        total = (total + solve(0, abs, n+1, len))%mod;
        
        
        dp[abs][late][n] = total;
        return (int)total;
    }
    
    public int checkRecord(int n) {
        //0 -> A, 1 -> L, 2->P
        dp = new Long[1+1][2+1][n+1];
        return solve(0, 0, 0, n);
        
    }
}