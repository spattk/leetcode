class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                Set<Integer> set = adj.getOrDefault(routes[i][j], new HashSet<>());
                set.add(i);
                adj.put(routes[i][j], set);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        q.add(source);
        visited.add(source);
        
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int ele = q.poll();
                
                if(ele == target)
                    return ans;
                
                for(int rId: adj.getOrDefault(ele, new HashSet<>())){
                    if(!seen.contains(rId)){
                        for(int newStop: routes[rId]){
                            if(!visited.contains(newStop)){
                                q.add(newStop);
                                visited.add(newStop);
                            }
                        }
                        seen.add(rId);
                    }
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}