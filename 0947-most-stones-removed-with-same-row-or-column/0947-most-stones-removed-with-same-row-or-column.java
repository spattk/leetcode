class Solution {
    
    public boolean isSameRowOrCol(int[] s1, int []s2){
        return s1[0] == s2[0] || s1[1] == s2[1];
    }
    
    public void dfs(int i){
        visited.add(i);
        
        for(int nei: adj.getOrDefault(i, new HashSet<>())){
            if(!visited.contains(nei)){
                dfs(nei);
            }
        }
    }
    
    Set<Integer> visited;
    Map<Integer, Set<Integer>> adj;
    public int removeStones(int[][] stones) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        int n = stones.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
 
                if(isSameRowOrCol(stones[i],stones[j])){
                    adj.putIfAbsent(i, new HashSet<>());
                    adj.get(i).add(j);

                    adj.putIfAbsent(j, new HashSet<>());
                    adj.get(j).add(i);
                }
            }
        }
        
        int connectedComponent = 0;
        for(int i=0; i<n; i++){
            if(!visited.contains(i)){
                connectedComponent++;
                dfs(i);
            }
        }
        
        
        return n - connectedComponent;
    }
}