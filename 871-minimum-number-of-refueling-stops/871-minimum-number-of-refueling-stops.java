class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->q[1]-p[1]);
        
        Arrays.sort(stations, (p,q)->p[0]-q[0]);
        int n = stations.length;
        int count = 0, curr = startFuel;
        int i = 0;
        
        while(true) {
            if(curr >= target)
                return count;
            
            while(i < n && stations[i][0] <= curr) {
                pq.add(stations[i]);
                i++;
            }
            
            if(!pq.isEmpty()){
                curr += pq.poll()[1];
                count++;
            } else {
                break;
            }
        }
        
        if (curr >= target){
            return count;
        } else {
            return -1;
        }
    }
}