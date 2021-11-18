class Solution {
    
    class Node {
        int x, y, val;
        Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    public boolean isSafe(int x, int y, int n){
        return x>=0 && x<n && y>=0 && y<n;
    }
    
    int[][] dx = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> q = new PriorityQueue<>((p1, p2) -> p1.val - p2.val);
        int n = grid.length;
        boolean [][] visited = new boolean[n][n];
        visited[0][0] = true;
        q.add(new Node(0,0, grid[0][0]));
        int result = 0;
        while(!q.isEmpty()){
            
            Node temp = q.poll();
            result = Math.max(temp.val, result);
            if(temp.x == n-1 && temp.y == n-1){
                return result;
            }
            for(int i=0;i<dx.length;i++){
                int nx = temp.x + dx[i][0];
                int ny = temp.y + dx[i][1];
                
                if(isSafe(nx, ny, n) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, grid[nx][ny]));
                }
            }
            
        }
        
        return result;
        
    }
}