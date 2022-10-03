class Solution {
    
    int n;
    Integer[][] dp;
    
    public int solve(String colors, int[] time, int idx, int prev){
        if(idx >= n)
            return 0;
        
        int ch = colors.charAt(idx) - 'a' + 1 ;
        
        if(dp[idx][prev] != null)
            return dp[idx][prev];
        
        //last
        if(idx == n-1){
            int result = 0;
            if(prev != ch) {
                result= 0;
            } else {
                result = time[idx];
            }
            
            return dp[idx][prev] = result;
            
        } else {
            int next = colors.charAt(idx + 1) - 'a' + 1 ;
            int result = 0;
            if(ch != prev && ch != next){
                //no need to remove
                result =  solve(colors, time, idx+1, ch);
            } else if(ch == prev) {
                //must remove current char
                result = time[idx] + solve(colors, time, idx+1, prev);
            } else if ( ch == next) {
                result= Math.min(
                    time[idx] + solve(colors, time, idx+1, prev),
                    solve(colors, time, idx+1, ch)
                );
            }
            
            return dp[idx][prev] = result;
        }
    }
    
    public int minCost(String colors, int[] neededTime) {
        n = colors.length();
        dp = new Integer[n+1][27];
        return solve(colors, neededTime, 0, 0);
    }
}