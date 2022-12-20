class Solution {
    
    public void dfs(int src, Set<Integer> visited, Map<Integer, Set<Integer>> adj){
        visited.add(src);
        for(int nei: adj.getOrDefault(src, new HashSet<>())){
            if(!visited.contains(nei)){
                dfs(nei, visited, adj);
            }
        }
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int n = rooms.size();
        for(int i=0; i<n; i++){
            List<Integer> keys = rooms.get(i);
            adj.putIfAbsent(i, new HashSet<>());
            for(int key: keys){
                adj.get(i).add(key);
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        dfs(0, visited, adj);
        
        return visited.size() == n;
    }
}