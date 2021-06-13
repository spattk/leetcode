class Solution {

    
    int result = 0;
    int[][] dp;
    public int solve(int[] stones, int i, int j, int sum) {
        
        if (i==j)
            return 0;
        
        if(j-i==1)
            return Math.max(stones[j], stones[i]);
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int temp = Math.max(sum - stones[i] - solve(stones, i+1, j, sum-stones[i]),sum - stones[j] - solve(stones, i, j-1, sum-stones[j]));
        
        dp[i][j]=temp;
        return temp;
        
    }
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        int sum = 0;
        for(int stone: stones){
            sum+= stone;
        }
        return solve(stones, 0, stones.length-1, sum);
    }
}