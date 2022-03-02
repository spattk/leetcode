class Solution {
    
    int [][]dx = {{0,-1}, {0,1},{1,0}, {-1,0}};
    
    public boolean isValid(int i, int j, int n){
        return i>=0 && i<n && j>=0 && j<n;
    }
    
    public void dfs(int i, int j, int[][] grid, int n, int num, boolean[][] visited) {
        grid[i][j] = num;
        visited[i][j] = true;
        for(int z=0;z<4;z++){
            int nx = i + dx[z][0];
            int ny = j + dx[z][1];
            
            if(isValid(nx, ny, n) && !visited[nx][ny] && grid[nx][ny] == 1){
                dfs(nx, ny, grid, n, num, visited);
            }
        }
    }
    
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int flag = 0;
        boolean[][]visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(i,j, grid, n, 2, visited);
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
        }
        
        Queue<int[]> q = new LinkedList<>();
        flag = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i,j, 0});
                }
            }
        }
        
        
        
        while(!q.isEmpty()){
            int [] temp = q.poll();
            if(grid[temp[0]][temp[1]] == 2){
                return temp[2] - 1;
            }
            
            for(int i=0;i<4;i++){
                int nx = temp[0] + dx[i][0];
                int ny = temp[1] + dx[i][1];
                
                if(isValid(nx, ny, n) && (!visited[nx][ny] || (grid[nx][ny] == 2))){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,temp[2]+1});
                }
            }
        }
        
        return -1;
        
    }
}