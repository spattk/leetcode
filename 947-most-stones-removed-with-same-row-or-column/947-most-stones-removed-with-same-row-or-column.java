class Solution {
    
    int count = 0;
    public String getKey(int[] stone){
        return "(" + stone[0] + "," + stone[1] + ")";
    }
    
    public void dfsUtil(String curr, Set<String> visited, Map<String, List<String>> map) {
        visited.add(curr);
        for(String adj: map.getOrDefault(curr, new ArrayList<>())){
            if(!visited.contains(adj))
            dfsUtil(adj, visited, map);
        }
    }
    
    public void dfs(Set<String> all, Set<String> visited, Map<String, List<String>> map) {
        
        for(String s: all){
            if(!visited.contains(s)){
                count++;
                dfsUtil(s, visited, map);
            }
        }
    }
    
    
    public int removeStones(int[][] stones) {
        Map<String, List<String>> map = new HashMap<>();
        
        int n = stones.length;
        String k1 = null, k2 = null;
        Set<String> all = new HashSet<>();
        for(int i=0;i<n;i++){
        
            k1 = getKey(stones[i]);
            all.add(k1);
            if(map.get(k1) == null)
                map.put(k1, new ArrayList<>());
            
            for(int j=0;j<i;j++){
                k2 = getKey(stones[j]);
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    List<String> first = map.get(k1);
                    List<String> second = map.get(k2);
                    
                    first.add(k2);
                    second.add(k1);
                    map.put(k1, first);
                    map.put(k2, second);
                }
            }
        }
        
        // System.out.println(map);
        // System.out.println("all" + all);
        Set<String> visited = new HashSet<>();
        dfs(all, visited, map);
        return n - count;
    }
}