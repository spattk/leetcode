class Solution {

	int r;
	int c;
	int n;

	
	public boolean checkDown(int i, int j, char[][] board, char[] chs){
		for(int k=0; k<chs.length; k++){
			if(!(board[i][j] == ' ' || board[i][j] == chs[k])){
				return false;
			}
			i++;
		}

		return true;
	}

	public boolean checkUp(int i, int j, char[][] board, char[] chs){
		for(int k=0; k<chs.length; k++){
			if(!(board[i][j] == ' ' || board[i][j] == chs[n-k-1])){
				return false;
			}
			i++;
		}

		return true;
	}

	public boolean checkForward(int i, int j, char[][] board, char[] chs){
		for(int k=0; k<chs.length; k++){
			if(!(board[i][j] == ' ' || board[i][j] == chs[k])){
				return false;
			}
			j++;
		}

		return true;
	}

	public boolean checkRev(int i, int j, char[][] board, char[] chs){
		for(int k=0; k<chs.length; k++){
			if(!(board[i][j] == ' ' || board[i][j] == chs[n-k-1])){
				return false;
			}
			j++;
		}

		return true;
	}

	public void fillDownUp(char[][]board, int [][] down, int [][]right){
		for(int i=r-1; i>=0; i--){
			for(int j=c-1; j>=0; j--){
				if(board[i][j] != '#'){
					down[i][j] = 1;
					right[i][j] = 1;

					if(i + 1 < r){
						down[i][j] += down[i+1][j];
					}

					if(j + 1 < c){
						right[i][j] += right[i][j+1];
					}
				}

				
			}

		}
	}
		

    	public boolean placeWordInCrossword(char[][] board, String word) {
		r = board.length;
		c = board[0].length;
		n = word.length();
		char[] chs = word.toCharArray();
		
     		int[][] down = new int[r][c];
		int[][] right = new int[r][c];

		fillDownUp(board, down, right);
		
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if((i == 0 || board[i-1][j] == '#') && down[i][j] == n){
					if(checkDown(i, j, board, chs) || checkUp(i,j, board, chs)){
						return true;
					}
				}

				if((j==0 || board[i][j-1] == '#') && right[i][j] == n){
					if(checkForward(i,j, board, chs) || checkRev(i,j, board, chs)){
						return true;
					}
				}
			}
		}

		return false;
		
    	}
}


