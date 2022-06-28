class Solution {
    
    int[][] dp;
    public int minimumSumSolver(List<List<Integer>> t, int r, int c) {
        
        dp[0][0] = t.get(0).get(0);
        
        for(int i=1;i<r;i++){
            for(int j=0;j<i+1;j++){
                if(j == 0){
                    dp[i][j] = t.get(i).get(j) + dp[i-1][j];
                } else {
                    if(j != t.get(i).size()-1){
                        dp[i][j] = t.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                    } else {
                        dp[i][j] = t.get(i).get(j) +dp[i-1][j-1];
                    }
                    
                }
            }
        }
        
        // for(int i=0;i<r;i++)
        //     System.out.println(Arrays.toString(dp[i]));
        
        int result = Integer.MAX_VALUE;
        for(int j=0;j<t.get(r-1).size();j++){
            result = Math.min(result, dp[r-1][j]);
        }
        
        return result;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int c = triangle.get(r-1).size();
        dp = new int[r][c];
        return minimumSumSolver(triangle, r, c);
        
    }
}