class Solution {
    int[] ans;    
    int[] closerNodesCount;
    Set<Integer> visited;
    Map<Integer, Set<Integer>> adj;
    int n;
    
    public int getCloserNodesCount(int node){
        int closerCount = 1;
        visited.add(node);
        for(int nei: adj.getOrDefault(node, new HashSet<>())){
            if(!visited.contains(nei)){
                int temp = getCloserNodesCount(nei);
                closerCount += temp;
                ans[0] += temp;
            }
        }
        
        closerNodesCount[node] = closerCount;
        return closerCount;
    }
    
    public void init(){
        ans = new int[n];
        closerNodesCount = new int[n];
        visited = new HashSet<>();
        adj = new HashMap<>();
    }
    
    public void setAnswer(int curr){
        visited.add(curr);
        for(int nei: adj.getOrDefault(curr, new HashSet<>())){
            if(!visited.contains(nei)){
                ans[nei] = ans[curr] - closerNodesCount[nei] + ( n - closerNodesCount[nei]);
                setAnswer(nei);
            }
        }
    } 
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        init();
        for(int[] edge: edges){
            adj.putIfAbsent(edge[0], new HashSet<>());
            adj.get(edge[0]).add(edge[1]);
            
            adj.putIfAbsent(edge[1], new HashSet<>());
            adj.get(edge[1]).add(edge[0]);
        }
        
        
        getCloserNodesCount(0);

        
        visited = new HashSet<>();
        setAnswer(0);
        
        return ans;
    }
}