class Solution {
	Integer [][] dp;
	int n;
	//no of steps to make s a palindrome
	public int getMinUtil(char[] s, int i, int j){
		if(i == j){
			return 0;
		}
	
		if( i == j-1){
			if(s[i] == s[j])
			return 0;

			return 1;
		}

		if(dp[i][j] != null){
			return dp[i][j];
		}
		
		int result = 0;
		if(s[i] == s[j]){
			result = getMinUtil(s, i+1, j-1);
		}
		else {
			result= 1 + Math.min(getMinUtil(s, i+1, j), getMinUtil(s, i, j-1));
		}

		return dp[i][j] = result;
		
	}

    public boolean isValidPalindrome(String s, int k) {
		n = s.length();
     	dp = new Integer[n+1][n+1];

		int min = getMinUtil(s.toCharArray(), 0, n-1);
		return min<=k;
    }
}


