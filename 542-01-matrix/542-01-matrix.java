class Solution {
    
    int[][] dx = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
            
        for(int i=0; i< r; i++){
            for(int j=0; j<c; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            mat[x][y] = curr[2];
            
            for(int k=0; k<dx.length; k++){
                int nx = x + dx[k][0];
                int ny = y + dx[k][1];
                
                if(isSafe(nx, ny, r, c) && !visited[nx][ny]){
                    q.add(new int[]{nx, ny, curr[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return mat;
    }
}