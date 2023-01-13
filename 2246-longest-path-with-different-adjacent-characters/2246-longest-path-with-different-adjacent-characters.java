class Solution {
    int longestPathValue = 1;
    int n;
    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = parent.length;
        for(int i = 0; i < n; i++){
            int j = parent[i];
            adj.putIfAbsent(j, new LinkedList<>());
            if(j != -1){
                adj.get(j).add(i);
            }   
        }
        dfs(0, adj, s);
        return longestPathValue;
    }

    public int dfs(int node, Map<Integer, List<Integer>> adj, String s){

        if(adj.getOrDefault(node, new LinkedList<>()).size() == 0)
            return 1;
        
        int max = 0, secondMax = 0;

        for(int nbr : adj.get(node)){
            int longestPathFromNbrNode = dfs(nbr , adj, s);
            
            if(s.charAt(node) == s.charAt(nbr))
                continue;

            if(longestPathFromNbrNode > max){
                secondMax = max;
                max = longestPathFromNbrNode;
            } else if(longestPathFromNbrNode > secondMax){
                secondMax = longestPathFromNbrNode;
            }
        }

        longestPathValue = Math.max(longestPathValue, max+secondMax+1);
        return max+1;
    }
}