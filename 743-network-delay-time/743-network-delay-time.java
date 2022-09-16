class Solution {
    
    class Node {
        int v;
        int wt;
        
        Node(int u, int wt){
            this.v = u;
            this.wt = wt;
        }
    }
    
    public void generateAdj(int[][]times, Map<Integer, Set<Node>> adj){
        for(int[] time: times){
            Set<Node> set = adj.getOrDefault(time[0], new HashSet<>());
            set.add(new Node(time[1], time[2]));
            adj.put(time[0], set);
        }
    }
    
    public int minTime(int[] dist){
        int time = 0;
        for(int i=1;i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;
            
            time = Math.max(time, dist[i]);
        }
        
        return time;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((p,q)->p.wt-q.wt);
        pq.add(new Node(k, 0));
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Node>> adj = new HashMap<>();
        Set<Integer> toPrint = new HashSet<>();
        generateAdj(times, adj);
        
        while(!pq.isEmpty()){
            
            Node curr = pq.poll();
            
            for(Node nei: adj.getOrDefault(curr.v, new HashSet<>())){
                if(dist[curr.v] + nei.wt < dist[nei.v]) {
                    dist[nei.v] = dist[curr.v] + nei.wt;
                    pq.add(new Node(nei.v, dist[curr.v] + nei.wt));
                }
                
            }
        }
        
        return minTime(dist);
    }
}