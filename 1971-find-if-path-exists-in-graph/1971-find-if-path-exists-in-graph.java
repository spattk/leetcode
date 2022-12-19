class Solution {
    Map<Integer, Set<Integer>> adj;
    
    public boolean bfs(Map<Integer, Set<Integer>> adj, int src, int dest){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(src);
        visited.add(src);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == dest)
                return true;
            
            for(int nei: adj.getOrDefault(curr, new HashSet<>())){
                if(!visited.contains(nei)){
                    q.add(nei);
                    visited.add(nei);
                }
            }
        }
        
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        adj = new HashMap<>();
        for(int []edge: edges){
            adj.putIfAbsent(edge[0], new HashSet<>());
            adj.get(edge[0]).add(edge[1]);
            
            adj.putIfAbsent(edge[1], new HashSet<>());
            adj.get(edge[1]).add(edge[0]);
        }
        
        return bfs(adj, src, dest);

    }
}