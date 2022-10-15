class Solution {
    
    int result = 1;
    int r,c;
    int[][] len;
    
    int[][] dx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public boolean isSafe(int x, int y){
        return x>=0 && x < r && y >=0 && y<c;
    }
    
    public int computeLength(int x, int y, int[][]matrix, boolean[][] visited){
        visited[x][y] = true;
        
        int ans = 1;
        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i][0];
            int ny = y + dx[i][1];
            
            if(isSafe(nx, ny) && (matrix[nx][ny] > matrix[x][y])) {
                int temp;
                if(visited[nx][ny]) {
                    temp = 1 + len[nx][ny];
                } else {
                     temp = 1 + computeLength(nx, ny, matrix, visited);
                }
                
                result = Math.max(result, temp);
                ans = Math.max(ans, temp);
            }
        }
        
        return len[x][y] = ans;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        
        len = new int[r][c];
        for(int i=0; i<r; i++){
            Arrays.fill(len[i], 0);
        }
        boolean[][] visited = new boolean[r][c];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(!visited[i][j]){
                    computeLength(i, j, matrix, visited);
                }
            }
        }
        
        return result;
    }
}