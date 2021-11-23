class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int num: stones)
            sum += num;
        boolean[][] dp = new boolean[stones.length+1][sum+1];
        
        int r = stones.length + 1;
        int c = sum + 1;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i == 0 && j!=0){
                    dp[i][j] = false;
                }
                else if(j == 0){
                    dp[i][j] = true;
                }
                else {
                    if(stones[i-1]>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                    }
                }
            }
        }
        
        int result = stones[0];
        
        for(int j=1;j<=c/2;j++){
            if(dp[r-1][j]){
                result = Math.min(result, Math.abs(sum - 2*j));
            }
        }
        
        return result;
    }
}