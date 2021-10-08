class Solution {
    class Graph {
        int V;
        int[] parent;
        int[] rank;
        
        Graph(int v){
            this.V = v;
            parent = new int[v];
            rank = new int[v];
            
            Arrays.fill(rank,0);
            for(int i=0;i<v;i++){
                parent[i] = i;
            }
        }
        
        public boolean union(int u, int v){
            int parentU = findParent(u);
            int parentV = findParent(v);
            
            if(parentU == parentV)
                return false;
            
            int ru = rank[parentU];
            int rv = rank[parentV];
            
            if(ru < rv){
                parent[parentU] = parentV;
            } else if (ru > rv) {
                parent[parentV] = parentU;
            } else {
                parent[parentV] = parentU;
                rank[parentU]++;
            }
            
            return true;
        }
        
        public int findParent(int u){
            if(parent[u] != u){
                parent[u] = findParent(parent[u]);
            }
            return parent[u];
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n-1)
            return false;
        
        Graph g = new Graph(n);
        for(int[] edge: edges){
            if(!g.union(edge[0], edge[1]))
                return false;
        }
        return true;
    }
}