class Solution {
	public void computeLeft(int n, long[] dp, long[] left){
		for(int j=0; j<n; j++){
			if(j == 0){
				left[j] = dp[j];
			}
			else {
				left[j] = Math.max(left[j-1] - 1, dp[j]);
			}
		}
	}

	public void computeRight(int n, long[] dp, long[] right){
		for(int j=n-1; j>=0; j--){
			if(j == n-1){
				right[j] = dp[j];
			}
			else {
				right[j] = Math.max(right[j+1] - 1, dp[j]);
			}
		}

	}

	public long maxDp(long[] dp){
        long max = Long.MIN_VALUE;
        for(long num: dp){
            max = Math.max(max, num);
        }
        
        return max;
	}

   	public long maxPoints(int[][] points) {
		int r = points.length;
		int c = points[0].length;

		long[] dp = new long[c];
		long[] left = new long[c];
		long[] right = new long[c];

		for(int j=0; j<c; j++){
			dp[j] = points[0][j];
		}        

		for(int i=1; i<r; i++){
			//left
			computeLeft(c, dp, left);

			//right
			computeRight(c, dp, right);

			for(int j=0; j<c; j++){
				dp[j] = points[i][j] + Math.max(left[j], right[j]);
			}
		}

		return maxDp(dp);
    	}
}


