class Solution {
    int [] parent = new int[1001];
    
    public int parent(int x) {
        while (parent[x] != -1){
            return parent(parent[x]);
        }
        
        return x;
    }
    
    public void union(int x, int y){
        int px = parent(x);
        int py = parent(y);
        
        parent[py] = px;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        Arrays.fill(parent, -1);
        int ax = -1;
        int ay = -1;
        
        for(int[] edge: edges) {
            int x = edge[0];
            int y = edge[1];
            int px = parent(x);
            int py = parent(y);
            
            if (px == py){
                ax = x;
                ay = y;
            } else {
                //union
                union(x,y);
            }
        }
        
        return new int[] {ax, ay};
        
    }
}