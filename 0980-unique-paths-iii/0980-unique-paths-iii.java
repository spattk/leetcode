class Solution {
	boolean[][] visited;
	int r,c;
	int[] start;
	int[][] dir = {{-1,0}, {0, -1}, {0, 1}, {1, 0}};
    int ans = 0;
    int empty = 0;
	
	//figures the start and the end
	public void init(int[][] grid){
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(grid[i][j] == 1) start = new int[]{i,j};
                
                if(grid[i][j] == 0) empty++;
			}
		}
	}

	public boolean isSafe(int x, int y){
		return x>=0 && x<r && y >=0 && y<c;
	}

	public void pathCounter(int x, int y, int [][] grid, boolean[][] visited){

        if(!isSafe(x, y) || visited[x][y] || grid[x][y] == -1)
            return;
		
		if(grid[x][y] == 2 && empty == -1){
            ans++;
            return;
        }
        
        if(grid[x][y] == 2 || empty < 0)
            return;

        visited[x][y] = true;
        empty--;
        
		for(int i=0; i<dir.length; i++){
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];                
            pathCounter(nx, ny, grid, visited);
		}
       
        empty++;
         visited[x][y] = false;
        
	}

    public int uniquePathsIII(int[][] grid) {
        r = grid.length;
		c = grid[0].length;
		visited = new boolean[r][c];
		init(grid);
        pathCounter(start[0], start[1], grid, visited);
        return ans;
    }
}


