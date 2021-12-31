class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for(int [] ar: prerequisites){
            Set<Integer> temp = map.getOrDefault(ar[1], new HashSet<>());
            temp.add(ar[0]);
            map.put(ar[1], temp);
            indegree[ar[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] answer = new int[n];
        int k = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            answer[k++] = temp;
            for(int neigh: map.getOrDefault(temp, new HashSet<>())){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }
        
        return k == n ? answer: new int[0];
    }
}