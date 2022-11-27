class Solution {
	int n1, n2;
    Integer[][] dp;
	public int util(char[] w1, char[] w2, int i, int j){

		if(i>= n1 && j >= n2){
			return 0;
		}

		if(i >= n1){
			return n2-j;
		}

		if(j >= n2){
			return n1 - i;
		}

        if(dp[i][j] != null)
            return dp[i][j];

		int result;
		if(w1[i] == w2[j]){
			result = util(w1, w2, i+1, j+1);
		}
		else {
			result = Math.min(
				1 + util(w1, w2, i, j+1),
				Math.min(
					1 + util(w1, w2, i+1, j),
					1 + util(w1, w2, i+1, j+1)
				)
			);
		}


		return dp[i][j] = result;

	}
    	public int minDistance(String word1, String word2) {
     		n1 = word1.length();
            n2 = word2.length();
            dp = new Integer[n1+1][n2+1];
            return util(word1.toCharArray(), word2.toCharArray(), 0, 0);
    	}
}


