class Solution {
    
    
    public boolean isValid(int x, int y, int r, int c){
        return x>=0 && x<r & y>=0 && y<c;
    }
    
    public int dfs(int[][] matrix, int i, int j, int r, int c, int[][] dp){
        int max = 0;
        if(dp[i][j]>0)
            return dp[i][j];
        for(int k=0;k<4;k++){
            int nx = i + d[k][0];
            int ny = j + d[k][1];
            if(isValid(nx, ny, r, c) && matrix[nx][ny] > matrix[i][j]){
                max = Math.max(max, dfs(matrix, nx, ny, r, c, dp));
            }
        }
        dp[i][j] = max + 1;
        return max+1;
    }
    
    int[][] d = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[][] dp = new int[r][c];
        int length = 0, temp;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++) {
                temp = dfs(matrix, i, j, r, c, dp);
                length = Math.max(length, temp);
            }
        }
        return length;
    }
}