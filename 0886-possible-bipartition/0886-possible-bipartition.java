class Solution {
    
    Map<Integer, Set<Integer>> adj;
    int[] colors;
    int[][] dislikes;
    
    int n;
    
    public void init(){
        adj = new HashMap<>();
        colors = new int[n+1];
        for(int[] dis: dislikes){
            adj.putIfAbsent(dis[0], new HashSet<>());
            adj.putIfAbsent(dis[1], new HashSet<>());
            
            adj.get(dis[0]).add(dis[1]);
            adj.get(dis[1]).add(dis[0]);
        }
        
        Arrays.fill(colors, -1);
    }
    
    public boolean bfs(int src){
        
        Queue<Integer> q = new LinkedList<>();
        colors[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            int currColor = colors[curr];
            
            for(int nei: adj.getOrDefault(curr, new HashSet<>())){
                if(colors[nei] == -1){
                    colors[nei] = 1 - currColor;
                    q.add(nei);
                }
                else {
                    if(colors[nei] != 1-currColor)
                        return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        this.dislikes = dislikes;
        this.n = n;
        init();
        
        for(int i=0; i<n; i++){
            if(colors[i] == -1)
                if(!bfs(i))
                    return false;
        }
        
        return true;
    }
}