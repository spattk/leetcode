class Solution {
    
    public int diff(int[] p){
        return p[1]-p[0] + 1;
    }
    
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] modQueries = new int[n][2];
        for(int i=0; i<n; i++){
            modQueries[i][0] = queries[i];
            modQueries[i][1] = i;
        }
        
        Arrays.sort(modQueries, (p, q) -> p[0]-q[0]);
        
        Arrays.sort(intervals, new Comparator<int[]> (){
            public int compare(int[] p, int []q){
                int val = Integer.compare(p[0], q[0]);
                if(val != 0)
                    return val;
                
                return Integer.compare(p[1], q[1]);
            } 
        });
        
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[]p, int []q){
               int val = Integer.compare(p[0], q[0]);
               if(val != 0)
                   return val;
               
               return Integer.compare(p[1], q[1]);
           } 
        });
        
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int i=0, j=0;
        int l = intervals.length;
        
        for(; j<n; j++){
            for(; i<l; i++){
                if(intervals[i][0] <= modQueries[j][0] ){
                    int[] temp = new int[]{diff(intervals[i]), intervals[i][1]};
                    pq.add(temp);
                } else {
                    break;
                }
            }
            
        
            while(!pq.isEmpty() && pq.peek()[1] < modQueries[j][0]){
                int [] temp = pq.poll();
            }
            if(!pq.isEmpty())
            result[modQueries[j][1]] = pq.peek()[0];
            
        }
        
        return result;
    }
}