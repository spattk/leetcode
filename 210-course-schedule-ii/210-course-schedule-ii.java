class Solution {
    
    public void topologicalSort(Map<Integer, List<Integer>> adj, int [] indegree, List<Integer> result){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
                visited.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            result.add(curr);
            
            for(int nei: adj.getOrDefault(curr, new ArrayList<>())){
                if(!visited.contains(nei)){
                    indegree[nei]--;
                    if(indegree[nei] == 0){
                        q.add(nei);
                    }
                }
            }
        }
    }
    
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        for(int[] pre: prerequisites){
            List<Integer> curr = adj.getOrDefault(pre[0], new ArrayList<>());
            curr.add(pre[1]);
            adj.put(pre[0], curr);
            indegree[pre[1]]++;
        }
        
        List<Integer> result = new ArrayList<>();
        topologicalSort(adj, indegree, result);
        
        if(result.size() == n){
            Collections.reverse(result);
            return result.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[]{};
        }
    }
}