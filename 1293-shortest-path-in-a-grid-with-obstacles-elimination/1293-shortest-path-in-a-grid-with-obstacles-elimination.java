class Solution {
    int[][]dx = {{-1,0}, {1,0}, {0, 1}, {0,-1}};
    
    public boolean isSafe(int x, int y, int r, int c){
        return x>=0 && x<r && y>=0 && y<c;
    }
    
    public int shortestPath(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k});
        
        boolean[][][]visited = new boolean [r+1][c+1][k+1];
        visited[0][0][k] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                if(curr[0] == r-1 && curr[1] == c-1)
                    return steps;
                for(int z=0;z<dx.length;z++){
                    int nx = curr[0] + dx[z][0];
                    int ny = curr[1] + dx[z][1];

                    if(isSafe(nx, ny, r, c)){
                        if(grid[nx][ny] == 1 && curr[2]>0 && !visited[nx][ny][curr[2]-1]){
                            q.add(new int[]{nx, ny, curr[2]-1});
                            visited[nx][ny][curr[2]-1] = true;
                        }
                        else if(grid[nx][ny] == 0 && !visited[nx][ny][curr[2]]) {
                            q.add(new int[]{nx, ny, curr[2]});
                            visited[nx][ny][curr[2]] = true;
                        }
                    }
                }
            }
            steps++;
        }
        
        
        return -1;
        
    }
}