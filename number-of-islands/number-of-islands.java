class Solution {
    int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int island = 0;
    
    public void bfs(int i, int j, int r, int c, char[][] grid){
        if(i >=r || i < 0 || j < 0 || j >= c || grid[i][j]!='1')
            return;
        
        grid[i][j] = 0;
        
        for(int[] d: dir){
            bfs(i+d[0], j+d[1], r, c, grid);
        }
    }
    
    public int numIslands(char[][] grid) {
        int noOfOnes = 0;
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i =0;i<r;i++){
            for(int j = 0; j<c; j++){
                if(grid[i][j] == '1'){
                    island++;
                    bfs(i,j,r,c, grid);
                }
            }
        }
        
        return island;
        
    }
}