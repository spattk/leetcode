class Solution {
    
    public int getDist(int[]p1, int[]p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        int n = points.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                List<int[]> list = adj.getOrDefault(i, new ArrayList<>());
                int dist = getDist(points[i], points[j]);
                list.add(new int[]{j , dist});
                adj.put(i, list);
                
                list = adj.getOrDefault(j, new ArrayList<>());
                list.add(new int[]{i , dist});
                adj.put(j, list);
            }
        }
        
        // System.out.println(adj);
        
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->p[1]-q[1]);
        Set<Integer> visited = new HashSet<>();
        pq.add(new int[]{0,0});
        int count = 0;
        int[] temp;
        while(count < n){
            temp = pq.poll();
            // System.out.println(Arrays.toString(temp));
            
            if(visited.contains(temp[0]))
                continue;
            
            visited.add(temp[0]);
            res += temp[1];
            
            for(int[] ele: adj.getOrDefault(temp[0], new ArrayList<>())){
                if(!visited.contains(ele[0])){
                    pq.add(new int[]{ele[0], ele[1]});
                }
            }
            
            count++;
        }
        
        return res;
    }
}