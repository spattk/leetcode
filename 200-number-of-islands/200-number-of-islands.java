class Solution {
    
    int[][]dx = {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x < r && y>=0 && y<c;
    }
    
    public void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        for(int i=0; i<4; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny, grid.length, grid[0].length) && grid[nx][ny] == '1'){
                dfs(grid, nx, ny);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        //traverse i,j
        //as soon as we hit one, we do a dfs and turn all of them zero
        //increase the count
        
        int count = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' ){
                    count ++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
}