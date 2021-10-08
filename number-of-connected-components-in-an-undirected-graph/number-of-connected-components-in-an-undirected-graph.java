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
    
    public int countComponents(int n, int[][] edges) {
        Graph g = new Graph(n);
        for(int[] edge: edges)
            g.union(edge[0], edge[1]);
        
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(g.findParent(i));
        }
        
        return set.size();
    }
    
}