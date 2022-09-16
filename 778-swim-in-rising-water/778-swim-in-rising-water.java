class Solution {
    
    class Node {
        int x,y,max;
        
        Node(int x, int y, int m){
            this.x = x;
            this.y = y;
            this.max = m;
        }
    }
    
    
    public boolean isSafe(int x, int y, int n){
        return x>=0 && x<n && y>=0 && y<n;
    }
    
    int [][] dx = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> pq = new PriorityQueue<>((p,q)->p.max - q.max);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        pq.add(new Node(0,0,grid[0][0]));
        
        int n = grid.length;
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(curr.x == n-1 && curr.y == n-1){
                return curr.max;
            }
            
            for(int i=0; i<dx.length; i++){
                int nx = curr.x + dx[i][0];
                int ny = curr.y + dx[i][1];
                
                if(isSafe(nx, ny, n) && !visited.contains(new Pair(nx, ny))){
                    visited.add(new Pair(nx, ny));
                    pq.add(new Node(nx, ny, Math.max(curr.max, grid[nx][ny])));
                }
            }
            
        }
        
        return -1;
        
    }
}