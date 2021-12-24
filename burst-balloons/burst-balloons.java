class Solution {
    
    
    // Map<String, Integer> map = new HashMap<>();
    int[][] dp;
    int solve(int[] arr, int i, int j){
        if(i>j)
            return 0;
        
        // String key = i +"," + j;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = Integer.MIN_VALUE;
        
        for(int k=i;k<=j;k++){
            int product = arr[k];
            if(i-1>=0)
                product *= arr[i-1];
            
            if(j+1 < arr.length)
                product *= arr[j+1];
            
            int tempAns = solve(arr, i, k-1) + solve(arr, k+1, j) + product;
            ans = Math.max(ans, tempAns);
        }
        
        dp[i][j] = ans;
        return ans;
    }
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                dp[i][j] = -1;
        }
        return solve(nums, 0, n-1);
    }
}