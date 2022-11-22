class Solution {
    
    public boolean isPerfectSquare(int n){
        int t = (int)Math.sqrt(n);
        return n - t*t == 0;
    }
    
    public int solve(int n){
        
        
        if(isPerfectSquare(n))
            return 1;
        
        if(n < 4)
            return n;
        
        if(dp[n] != null)
            return dp[n];
        
        int ans = n, res;
        for(int i=2; i<=Math.sqrt(n); i++){
            res = 1 + solve(n - i*i);
            ans = Math.min(ans, res);
        }
        
        return dp[n] = ans;
    }
    
    Integer[] dp;
    public int numSquares(int n) {
        dp = new Integer[n+1];
        return solve(n);
    }
}