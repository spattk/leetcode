class Solution {
	int r,c;
	public void copyToPrevRow(int[][][]dp){
		int y = dp[0].length;
		int z = 4;

		for(int j=0; j<y; j++){
			for(int k=0; k<4; k++){
				dp[0][j][k] = dp[1][j][k];
			}
		}
	}

    	public int longestLine(int[][] mat) {
		r = mat.length;
		c = mat[0].length;

		int[][][]dp = new int[2][c][4];
		int maxOnes = 0;

// 		for(int j=0; j<c; j++){
// 			for(int k=0; k<4; k++){
// 				dp[0][j][k] = mat[0][j];
// 			}
// 		}

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(mat[i][j] == 1){
					//horizontal
					if(j > 0) dp[1][j][0] = 1 + dp[1][j-1][0];
                    else dp[1][j][0] = 1;
					maxOnes = Math.max(maxOnes, dp[1][j][0]);

					//vertical
					dp[1][j][1] = 1 + dp[0][j][1];
					maxOnes = Math.max(maxOnes, dp[1][j][1]);

					//diag
					if(j > 0) dp[1][j][2] = 1+ dp[0][j-1][2];
                    else dp[1][j][2] = 1;
					maxOnes = Math.max(maxOnes, dp[1][j][2]);

					//anti-diag
					if(j + 1 < c) dp[1][j][3] = 1 + dp[0][j+1][3];
                    else dp[1][j][3] = 1;
					maxOnes = Math.max(maxOnes, dp[1][j][3]);
				}
				else {
					dp[1][j][0] = dp[1][j][1] = dp[1][j][2] = dp[1][j][3] = 0;
				}
			}

			//assign row 1 to row 0
			copyToPrevRow(dp);
		}

		return maxOnes;
    	}
}


