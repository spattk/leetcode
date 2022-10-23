class Solution {
	int[][]dx = {{-1, 0}, {1,0}, {0,1}, {0, -1}};
	int r, c;	

	public boolean isSafe(int x, int y){
		return x>=0 && x<r && y>=0 && y<c;
	}

	public void dfs(char[][]board, int i, int j){
		board[i][j] = '.';
		for(int k = 0; k<4; k++){
			int nx = i + dx[k][0];
			int ny = j + dx[k][1];

			if(isSafe(nx, ny) && board[nx][ny] == 'X'){
				dfs(board, nx ,ny);
			}
		}
	}

	public int countBattleships(char[][] board) {
		r = board.length;
		c = board[0].length;

		int count = 0;

		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(board[i][j] == 'X'){
					dfs(board, i, j);count++;
				}
			}
		}

		return count;
	}
}
