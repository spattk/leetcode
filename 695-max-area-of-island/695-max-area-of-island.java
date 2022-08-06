class Solution {
    
    int max = 0;
    
    static int val = 0;
    
    int[][]d = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x< r && y>=0 && y<c;
    }
    
    public void dfs(int[][] grid, int x, int y, int r, int c){
        val++;
        grid[x][y] = 0;
        if(val > max){
            max = val;
        }
        
        for(int i=0;i<d.length;i++){
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            
            if(isSafe(nx, ny, r, c) && grid[nx][ny] == 1){
                dfs(grid, nx, ny, r, c);
            }
        }
        
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j] == 1){
                    val = 0;
                    dfs(grid, i, j, r, c);
                }
            }
        }
        
        return max;
    }
}