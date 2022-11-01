class Solution {
    Integer curr;
    int r, c;
    
    public boolean isSafe(int x, int y){
        return y>=0 && y<c;
    }
    
    public boolean isStuck(int x, int y, int[][]grid){
        if(grid[x][y] == 1){
            if(isSafe(x, y+1) && grid[x][y+1] == -1)
                return true;
            
            if(!isSafe(x, y+1))
                return true;
        }
        else {
            if(isSafe(x, y-1) && grid[x][y-1] == 1)
                return true;
            
            if(!isSafe(x, y-1))
                return true;
        }
        
        return false;
    }
    
    public void dfs(int x, int y, int[][] grid){
        
        if(curr != null)
            return;
        
        if(x >= r){
            curr = y;
            return;
        }
        
        if(!isSafe(x, y) || isStuck(x, y, grid) ){
            return;
        }
        
        if(grid[x][y] == 1){
            dfs(x+1, y+1, grid);
        }
        else {
            dfs(x+1, y-1, grid);
        }
    }
    
    public int[] findBall(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        
        int[] result = new int[c];
        Arrays.fill(result, -1);
        
        for(int col = 0; col< c; col++){
            curr = null;
            dfs(0, col, grid);
            if(curr == null || curr > c || curr < 0){
                result[col] = -1;
            } else {
                result[col] = curr;
            }
        }
        
        return result;
    }
}