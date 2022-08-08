class Solution {
    List<String> result;
    Map<String, List<String>> adj;
    
    public boolean dfs(String u, int n){
        if(result.size() == n + 1)
            return true;
        
        List<String> temp = adj.getOrDefault(u, new ArrayList<>());
        // System.out.println(temp);
        
        for(int i=0; i<temp.size(); i++){
            String v = temp.get(i);
            result.add(v);
            adj.get(u).remove(v);
            
            if(dfs(v, n))
                return true;
            
            result.remove(result.size()-1);
            adj.get(u).add(i, v);
        }
        
        return false;
    }
        
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket: tickets){
            String u = ticket.get(0), v = ticket.get(1);
            List<String> curr = adj.getOrDefault(u, new ArrayList<>());
            curr.add(v);
            adj.put(u, curr);
        }
        
        for(String key: adj.keySet()){
            List<String> curr = adj.get(key);
            Collections.sort(curr);
            adj.put(key, curr);
        }
        // System.out.println(adj);
        result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", tickets.size());
        return result;
    }
}