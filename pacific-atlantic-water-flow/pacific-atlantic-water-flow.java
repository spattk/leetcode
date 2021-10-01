class Solution {
    
    class Node {
        int i;
        int j;
        
        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    List<List<Integer>> result;
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, -1, 0, 1};
    boolean isAtlantic = false;
    boolean isPacific = false;
    
    public boolean isSafe(int x, int y, int i, int j, int r, int c, int[][] heights){
        boolean temp = (i>=0 && i<r && j>=0 && j<c) ;
        if(temp){
            return heights[i][j]<=heights[x][y];
        }
        
        return false;
    }
    
    public boolean isPacificAtlanticConnected(int x, int y, int r, int c, boolean[][] visited, int[][] heights) {
        // if(x == 1 && y == 4){
        //     // System.out.println("hey" + r + " " + c);
        // }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            // System.out.println(temp.i + " " + temp.j + "^^") ;
            if (temp.i == 0 || temp.j == 0){
                isPacific = true;
            }
            
            if (temp.i == r-1 || temp.j == c-1){
                isAtlantic = true;
            }
            
            if(isPacific && isAtlantic){
                return true;
            }
            
            // System.out.println(isPacific + " " + isAtlantic);
            
            for(int i=0;i<4;i++){
                int nx = temp.i + dx[i];
                int ny = temp.j + dy[i];
                
                // System.out.println(nx + " " + ny + "####") ;
                
                if(isSafe(temp.i, temp.j, nx, ny, r, c, heights) && !visited[nx][ny] ){
                    // System.out.println(nx + " " + ny);
                    visited[nx][ny] = true;
                    q.add(new Node(nx,ny));
                }
            }
        }
        
        return false;
    }
    
    public void resetVisited(boolean[][] visited){
        int r = visited.length;
        int c = visited[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                visited[i][j] = false;
            }
        }
        
        isPacific = false;
        isAtlantic = false;
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //for each position do a BFS
        int m = heights.length;
        int n = heights[0].length;
        result = new ArrayList<>();
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                resetVisited(visited);
                // if (!(i == 1 && j ==4)){
                //     continue;
                // }
                if (isPacificAtlanticConnected(i,j,m,n,visited, heights)){
                    // System.out.println(i + " " + j);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                    // return result;
                }
            }
        }
        
        return result;
    }
}