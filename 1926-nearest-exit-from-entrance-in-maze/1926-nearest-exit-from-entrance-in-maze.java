class Solution {
    
    int[][]dx = {{-1,0}, {1,0}, {0,1 }, {0,-1}};
    int r,c;
    public boolean isSafe(int x, int y){
        return x>=0 && x<r && y>=0 && y<c;
    }
    

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        r = maze.length;
        c = maze[0].length;
        q.add(new int[]{entrance[0], entrance[1], 0});
        visited.add(new Pair(entrance[0], entrance[1]));
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if((curr[0] == r-1 || curr[1] == c-1 || curr[0] == 0 || curr[1] == 0) && curr[2] != 0)
                return curr[2];
            
            for(int i=0; i<dx.length; i++){
                int nx = curr[0] + dx[i][0];
                int ny = curr[1] + dx[i][1];
                
                if(isSafe(nx, ny) && !visited.contains(new Pair(nx, ny)) && maze[nx][ny] != '+'){
                    q.add(new int[]{nx, ny, curr[2]+1});
                    visited.add(new Pair(nx, ny));
                }
            }
        }
        
        return -1;
    }
}