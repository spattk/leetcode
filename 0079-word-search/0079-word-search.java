class Solution {
    
    int r, c;
    String word;
    int[][]dx = {{0,1},{0, -1}, {1, 0}, {-1, 0}};
    public boolean isSafe(int x, int y){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public boolean dfs(char[][] board, boolean[][]visited, int x, int y, int idx){
        
        if(word.charAt(idx) != board[x][y])
            return false;
        
        if(idx == word.length()-1)
            return true;
        
        visited[x][y] = true;
        boolean result = false;
        
        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny) && !visited[nx][ny]){
                result |= dfs(board, visited, nx, ny, idx+1);
            }
        }
        visited[x][y] = false;
        return result;
        
    }
    
    public boolean exist(char[][] board, String word) {
        r = board.length;
        c = board[0].length;
        this.word = word;
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(dfs(board, new boolean[r][c], i, j, 0))
                    return true;
            }
        }
        
        return false;
    }
}